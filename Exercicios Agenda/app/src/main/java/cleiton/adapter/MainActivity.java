package cleiton.adapter;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CustomAdapter;
import adapter.view.Update;
import butterknife.Bind;
import butterknife.ButterKnife;
import helper.Banco;
import model.Agenda;

public class MainActivity extends AppCompatActivity {
    Banco b;
    @Bind(R.id.listItens)
    ListView listView;
    private List<Agenda> agendas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        b =  new Banco(getBaseContext(), "agenda", null, 1);
        consultaBanco();

        CustomAdapter custonAdapter = new CustomAdapter(agendas, getApplicationContext());
        listView.setAdapter(custonAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getBaseContext(),Update.class);
                startActivity(i);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getBaseContext(), Update.class);
                i.putExtra("agenda", agendas.get(position));
                startActivity(i);
            }
        });
    }

    private void consultaBanco() {
        String sql = "SELECT  nome, telefone, imagem FROM agenda";
        agendas = new ArrayList<Agenda>();
        Cursor cursor = b.buscar(sql);

        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            for (int i = 0; i < cursor.getCount(); i++) {
                Agenda a = new Agenda();
                a.setNome(cursor.getString(0));
                a.setTelefone(cursor.getString(1));
                a.setImagem(cursor.getInt(2));
                agendas.add(a);
                cursor.moveToNext();
            }
        }
    }

    private void Insere(Agenda agenda) {

        SQLiteDatabase base = b.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("nome", agenda.getNome());
        values.put("valor", agenda.getTelefone());

        long resultado = base.insert("lanche", null, values);

        if (resultado != -1) {
            Toast.makeText(this, "Deu Certo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Erro", Toast.LENGTH_SHORT).show();
        }
    }

}
package adapter.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import cleiton.adapter.R;
import model.Agenda;


/**
 * Created by Cleiton Gonçalves on 25/02/2016.
 */
public class Update extends AppCompatActivity {

    @Bind(R.id.imagem)ImageView imagem;
    @Bind(R.id.edtTelefone)EditText telefone;
    @Bind(R.id.edtNome)EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        if(b!=null){
            Agenda a = (Agenda) b.get("agenda");
            updateUI(a);
        }

    }


    public void updateUI(Agenda agenda){
        if(agenda==null){
            nome.setText(null);
            imagem.setImageResource(R.drawable.bauru);
            telefone.setText(null);
        }else{
            nome.setText(agenda.getNome());
            imagem.setImageResource(agenda.getImagem());
            telefone.setText(agenda.getTelefone());
        }
    }
}
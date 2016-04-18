package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import cleiton.adapter.R;
import model.Agenda;

/**
 * Created by Cleiton Gonçalves on 28/01/2016.
 */
public class Banco extends SQLiteOpenHelper {

        public Banco(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE agenda(_id integer primary key,nome TEXT, telefone TEXT, imagem INTEGER)";
            db.execSQL(sql);
            sql = "INSERT INTO agenda VALUES(1,'Cleiton','(67)9614-4798',"+R.drawable.foto2+")";
            db.execSQL(sql);
            sql = "INSERT INTO agenda VALUES(2,'Priscila','(67)8765-9879',"+R.drawable.foto1+")";
            db.execSQL(sql);
            sql = "INSERT INTO agenda VALUES(3,'Creuza','(78)7876-4535',"+R.drawable.foto4+")";
            db.execSQL(sql);
            sql = "INSERT INTO agenda VALUES(4,'Renan','(43)3456-9850',"+R.drawable.foto3+")";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            String sql = "DROP TABLE IF EXISTS agenda";
            db.execSQL(sql);

        }

        public Cursor buscar(String sql) {
            return getWritableDatabase().rawQuery(sql, null);
        }

         public int updateAgenda(Agenda agenda) {
            SQLiteDatabase db = this.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nome", agenda.getNome());
            values.put("telefone", agenda.getTelefone());
            // updating row
            return db.update("a", values, "_id = ?", new String[]{String.valueOf(agenda.getId())});
         }

         public void deleteAgenda(Agenda agenda) {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete("agenda", "_id = ?", new String[]{String.valueOf(agenda.getId())});
            db.close();
    }


    }


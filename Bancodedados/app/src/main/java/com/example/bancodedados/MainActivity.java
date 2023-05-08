package com.example.bancodedados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ADD(View view) {
        EditText CPF = findViewById(R.id.editText01);
        EditText NOME = findViewById(R.id.editText02);
        EditText EMAIL = findViewById(R.id.editText03);
        EditText TEL = findViewById(R.id.editText04);
        EditText DATE = findViewById(R.id.editText05);
        EditText SEXO = findViewById(R.id.editText06);

        String CPF1 = CPF.getText().toString();
        String NOME1 = NOME.getText().toString();
        String EMAIL1 = EMAIL.getText().toString();
        String TEL1 = TEL.getText().toString();
        String DATE1 = DATE.getText().toString();
        String SEXO1 = SEXO.getText().toString();

        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());

        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CPF, CPF1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_USER, NOME1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, EMAIL1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TELEFONE, TEL1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_DATANASCIMENTO, DATE1);
        values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SEXO, SEXO1);

        long newRowId = db.insert(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                null,
                values
        );



         CPF.getText().clear();
         NOME.getText().clear();
         EMAIL.getText().clear();
         TEL.getText().clear();
         DATE.getText().clear();
         SEXO.getText().clear();
    }

    public void Consultardados(View view) {
        EditText CPF = findViewById(R.id.editText01);
        String CPF1 = CPF.getText().toString();
        TextView textView = findViewById(R.id.textView02);

        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());
        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_CPF,
                FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_USER,
                FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TELEFONE,
                FeedReaderContract.FeedEntry.COLUMN_NAME_DATANASCIMENTO,
                FeedReaderContract.FeedEntry.COLUMN_NAME_SEXO
        };

        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_CPF + " = ?";
        String[] selectionArgs = { CPF1 };

        String sortOrder = FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_USER + " DESC";

        Cursor c = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                sortOrder
        );

        if (c.getCount() == 0) {
            textView.setText("CPF não encontrado");
            return;
        }

        c.moveToFirst();
        String item1 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_CPF)
        );

        String item2 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_USER)
        );

        String item3 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL)
        );

        String item4 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TELEFONE)
        );

        String item5 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_DATANASCIMENTO)
        );

        String item6 = c.getString(
                c.getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SEXO)
        );

        CPF.getText().clear();
        textView.setText("CPF: "+item1+"\nNOME: "+item2+"\nEMAIL: "+item3+"\nTELEFONE: "+item4+"\nDATA_NASCIMENTO: "+item5+"\nSEXO: "+item6);
    }


    public void Alterardados(View view) {
        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());

        SQLiteDatabase db = mDbHealper.getWritableDatabase();

//
        EditText CPF = findViewById(R.id.editText01);

        EditText Tipo1 = findViewById(R.id.editText777);
        String tipo = Tipo1.getText().toString().toUpperCase();
//

        String title = "";




        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_CPF + " = ?";
        String[] selectionArgs = { CPF.getText().toString() };




        if(tipo.equals("CPF")){
            EditText CPF1 = findViewById(R.id.editText01);
            title = CPF1.getText().toString();

            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_CPF, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );

        }

        else if (tipo.equals("NOME")) {
            EditText NOME = findViewById(R.id.editText02);
            title = NOME.getText().toString();
            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_USER, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }


        else if (tipo.equals("EMAIL")) {
            EditText EMAIL = findViewById(R.id.editText03);
            title = EMAIL.getText().toString();
            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }


        else if (tipo.equals("TELEFONE")) {
            EditText tel = findViewById(R.id.editText04);
            title = tel.getText().toString();

            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_TELEFONE, title);

            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }


        else if (tipo.equals("DATA")) {
            EditText data = findViewById(R.id.editText05);
            title = data.getText().toString();

            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_DATANASCIMENTO, title);


            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }

        else if (tipo.equals("SEXO")) {
            EditText sexo = findViewById(R.id.editText06);
            title = sexo.getText().toString();
            ContentValues values = new ContentValues();
            values.put(FeedReaderContract.FeedEntry.COLUMN_NAME_SEXO, title);

            int count  = db.update(
                    FeedReaderContract.FeedEntry.TABLE_NAME,
                    values,
                    selection,
                    selectionArgs

            );
        }



    }

    public void deletar(View view) {


        FeedReaderDbHealper mDbHealper = new FeedReaderDbHealper(getApplicationContext());

        SQLiteDatabase db = mDbHealper.getWritableDatabase();

        EditText CPF = findViewById(R.id.editText01);
        String cpf1 = CPF.getText().toString();

        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_CPF + " = ?";
        String[] selectionArgs = { cpf1 };

        int rowsDeleted = db.delete(FeedReaderContract.FeedEntry.TABLE_NAME, selection, selectionArgs);

        if(rowsDeleted > 0){
            Toast.makeText(getApplicationContext(), "Registro deletado com sucesso", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(), "Erro ao deletar registro", Toast.LENGTH_SHORT).show();
        }
    }


}
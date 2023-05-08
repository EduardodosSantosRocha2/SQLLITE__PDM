package com.example.bancodedados;

import android.provider.BaseColumns;

public final class FeedReaderContract {

    public FeedReaderContract(){}

    public static abstract class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME = "Cadastro";
        public static final String COLUMN_NAME_CPF = "CPF";
        public static final String COLUMN_NAME_NAME_USER = "Nome";
        public static final String COLUMN_NAME_EMAIL = "Email";
        public static final String COLUMN_NAME_TELEFONE = "Telefone";
        public static final String COLUMN_NAME_DATANASCIMENTO = "DataNascimento";
        public static final String COLUMN_NAME_SEXO = "Sexo";

        public static final String TEXT_TYPE = "TEXT";
        public static final String COMMA_SEP = ",";


        public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " (" +
                FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_CPF + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_NAME_USER + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_EMAIL + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_TELEFONE + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_DATANASCIMENTO + " TEXT," +
                FeedReaderContract.FeedEntry.COLUMN_NAME_SEXO + " TEXT)";



        public static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedEntry.TABLE_NAME;

    }

}

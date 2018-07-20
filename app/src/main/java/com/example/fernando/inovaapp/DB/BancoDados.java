package com.example.fernando.inovaapp.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BancoDados {
    private static final String NOME_BANCO = "baseDados";
    private static final String NOME_TABELA = "tbl";
    private static final int VERSAO_BANCO = 1;

    private static final String[] SCRIPT_DATABASE_DELETE = new String[0];
    private static final String[] SCRIPT_DATABASE_CREATE =  new String[0];

    private static SQLiteDatabase sqLiteDatabase;

    public static SQLiteDatabase getDb(Context ctx){
        SCRIPT_DATABASE_DELETE [0] = "DROP TABLE IF EXISTS" + NOME_TABELA;
        SCRIPT_DATABASE_CREATE [0] = "CREATE TABLE " + NOME_TABELA + "(_id_usuario integer primary key, nome text)";

        return sqLiteDatabase;
    }
}

package com.example.fernando.inova.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class BancoDados {
    private static final String NOME_BANCO = "baseDados";
    private static final String NOME_TABELA_USUARIO = "tbl_usuario";
    private static final String NOME_TABELA_CLIENTE = "tbl_cliente";
    private static final int VERSAO_BANCO = 1;

    private static final String[] SCRIPT_DATABASE_DELETE = new String[4];
    private static final String[] SCRIPT_DATABASE_CREATE =  new String[4];

    private static SQLiteDatabase sqLiteDatabase;

    public static SQLiteDatabase getDb(Context ctx){
        SCRIPT_DATABASE_DELETE [0] = "DROP TABLE IF EXISTS" + NOME_TABELA_USUARIO;
        SCRIPT_DATABASE_DELETE [1] = "DROP TABLE IF EXISTS" + NOME_TABELA_CLIENTE;


        SCRIPT_DATABASE_CREATE [0] = "CREATE TABLE " + NOME_TABELA_USUARIO + "(_id_usuario integer primary key, " +
                "nome text not null, email text not null)";
        SCRIPT_DATABASE_CREATE [1] = "CREATE TABLE " + NOME_TABELA_CLIENTE + "(_id_cliente integer primary key, " +
                "nome text not null, situacao text not null, endereco text not null)";

        try {
            if(sqLiteDatabase == null){
                SQLiteHelper sqLiteHelper = new SQLiteHelper(ctx,NOME_BANCO, SCRIPT_DATABASE_CREATE, SCRIPT_DATABASE_DELETE ,VERSAO_BANCO);
                sqLiteDatabase = sqLiteHelper.getWritableDatabase();
                Log.i("banco","BANCO DE DADOS CRIADO COM SUCESSO!");
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return sqLiteDatabase;
    }
}

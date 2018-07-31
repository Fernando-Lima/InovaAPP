package com.example.fernando.inova.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLiteHelper extends SQLiteOpenHelper {
    private String[] scriptSQLCreate;
    private String[] scriptSQLDelete;

    public SQLiteHelper(Context context, String name, String[] scriptSQLCreate, String[] scriptSQLDelete, int version) {
        super(context, name, null, version);
        this.scriptSQLCreate = scriptSQLCreate;
        this.scriptSQLDelete = scriptSQLDelete;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        int qtdScript = scriptSQLCreate.length;

        for ( int i = 0; i < qtdScript; i++ ){
            sqLiteDatabase.execSQL(scriptSQLCreate[i]);
            Log.i("banco","SQLiteHelper banco criado com sucesso");
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        int qtdScript = scriptSQLCreate.length;
        for (int i = 0; i < qtdScript; i++) {
            sqLiteDatabase.execSQL(scriptSQLDelete[i]);
            Log.i("banco","Drop db");
        }
        onCreate(sqLiteDatabase);
        Log.i("banco","update db");
    }
}

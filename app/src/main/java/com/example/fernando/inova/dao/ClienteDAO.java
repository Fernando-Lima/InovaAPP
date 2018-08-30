package com.example.fernando.inova.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fernando.inova.db.BancoDados;
import com.example.fernando.inova.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fernando on 30/08/18.
 */

public class ClienteDAO {
    SQLiteDatabase dbCliente; //representa a conexão com o banco de dados SQLite.

    public ClienteDAO(Context context){
        dbCliente = BancoDados.getDb(context);
    }

    public void salvar(Cliente cliente){
        ContentValues values = new ContentValues();
        values.put("nome", cliente.getNome());
        values.put("endereco", cliente.getEndereco());
        values.put("situacao",cliente.getSituacao());
        dbCliente.insert("tbl_cliente",null,values);
    }

    public void excluir(Long id){

    }

    public List<Cliente> listar(){
        String[] colunas = new String[]{"_id,nome,situacao,endereco"};
        List<Cliente> clientes;
        Cursor c = dbCliente.query("tbl_cliente",colunas,null,null,null,null,null);
        clientes = new ArrayList<Cliente>();

        if(c.moveToFirst()){
            do {
                Cliente cliente = new Cliente();

                cliente.setCodigo(c.getLong(c.getColumnIndex("_id")));
                cliente.setNome(c.getString(c.getColumnIndex("nome")));
                cliente.setEndereco(c.getString(c.getColumnIndex("endereco")));
                cliente.setSituacao(c.getString(c.getColumnIndex("situacao")));
                clientes.add(cliente);
            }while (c.moveToNext());
        }
        c.close();
        return clientes;
    }

    public Cliente BuscarPorId(Long id){
        return null;
    }
}

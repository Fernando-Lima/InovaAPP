package com.example.fernando.inova;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.fernando.inova.adapter.RecycleViewCliente;
import com.example.fernando.inova.model.Cliente;
import com.example.fernando.inova.service.HTTPService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class ClienteActivity extends Debug {
    private RecyclerView recyclerView;
    private String[] items={"Cliente 1", "Cliente 2 ","Cliente 3","Cliente 4","Cliente 5","Cliente 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        //Conexão com webservice
        HTTPService httpService = new HTTPService();
        List<Cliente> clientes = null;
        try {
            clientes = httpService.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        Intent it = new Intent();
        it.putExtra("key","teste de retorno Cliente");
        setResult(RESULT_OK,it);

        recyclerView = (RecyclerView)findViewById(R.id.recycleView_cliente);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecycleViewCliente(this, clientes));

    }
}

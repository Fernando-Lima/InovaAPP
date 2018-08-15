package com.example.fernando.inova;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fernando.inova.adapter.RecycleViewSetor;

public class SetorActivity extends Debug {
    private RecyclerView mRecyclerView;
    private String[] items={"Setor 1", "Setor 2 ","Setor 3","Setor 4","Setor 5","Setor 6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setor);

        mRecyclerView = (RecyclerView)findViewById(R.id.recycleView_setor);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new RecycleViewSetor(this,items));
    }
}

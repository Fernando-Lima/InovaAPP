package com.example.fernando.inovaapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class RecyclerViewAdapter extends  RecyclerView.Adapter<RecyclerViewAdapter.Item>{

    private Context context;
    private String[] items;

    public RecyclerViewAdapter (Context context, String[] items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public Item onCreateViewHolder(@NonNull ViewGroup parent, int typeView) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Item item, int i) {

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class Item extends RecyclerView.ViewHolder{

        private TextView tvNome;
        private View mView;

        public Item(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

        }
    }
}

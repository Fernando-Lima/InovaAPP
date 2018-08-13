package com.example.fernando.inova.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fernando.inova.R;
/**
 * Created by fernando on 13/08/18.
 */

public class RecycleViewCliente extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    String[]items;

    public RecycleViewCliente(Context context, String[]items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View row = layoutInflater.inflate(R.layout.recycle_view_cliente_row,parent,false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if(viewHolder instanceof Item){
            final Item item = (Item) viewHolder;
            item.tvNome.setText(items[position]);

            //ação do click do item da lista
        }
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class Item extends RecyclerView.ViewHolder{
        private View mView;
        private TextView tvNome;

        public Item(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            tvNome = (TextView)itemView.findViewById(R.id.tv_recycler_item_nome_cliente);
        }
    }
}

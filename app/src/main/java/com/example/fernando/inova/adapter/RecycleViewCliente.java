package com.example.fernando.inova.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fernando.inova.R;
import com.example.fernando.inova.SetorActivity;
import com.example.fernando.inova.model.Cliente;

import java.util.List;

/**
 * Created by fernando on 13/08/18.
 */

public class RecycleViewCliente extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<Cliente> clientes;
    private Cliente cliente;

    public RecycleViewCliente(Context context, List<Cliente> clientes){
        this.context = context;
        this.clientes = clientes;
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
        if(clientes != null && clientes.size()>0){
            final Item item = (Item) viewHolder;
            cliente = clientes.get(position);
            item.tvNome.setText(cliente.getNome());
            item.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, SetorActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return clientes.size();
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

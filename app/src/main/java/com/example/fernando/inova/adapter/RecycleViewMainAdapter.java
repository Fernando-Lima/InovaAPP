package com.example.fernando.inova.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fernando.inova.R;

public class RecycleViewMainAdapter extends RecyclerView.Adapter<RecycleViewMainAdapter.Item>{
    Context context;
    String[] items;

    public RecycleViewMainAdapter(Context context, String[]items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecycleViewMainAdapter.Item onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View row = layoutInflater.inflate(R.layout.recycle_view_main_row,parent,false);
        Item item = new Item(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull Item item, int position) {
        ((Item)item).tvItem.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class Item extends RecyclerView.ViewHolder{
        private TextView tvItem;
        private View mView;


        public Item(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            tvItem = (TextView)itemView.findViewById(R.id.item);
        }
    }
}

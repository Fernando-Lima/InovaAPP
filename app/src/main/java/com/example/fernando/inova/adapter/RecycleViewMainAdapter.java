package com.example.fernando.inova.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.fernando.inova.R;

public class RecycleViewMainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
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
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
      if(holder instanceof Item){
          final Item item = (Item) holder;
          item.tvNome.setText(items[i]);

      }
    }

   // @Override
    //public void onBindViewHolder(@NonNull Item item, int position) {
     //   ((Item)item).tvItem.setText(items[position]);
    //}

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class Item extends RecyclerView.ViewHolder{
        private RelativeLayout relativeLayout;
        private View mView;
        private TextView tvNome;


        public Item(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            relativeLayout = itemView.findViewById(R.id.rela_round);
            tvNome = (TextView)itemView.findViewById(R.id.tv_recycler_item_1);
        }
    }
}

package com.example.inventoryapp;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.MyViewholder> {

    private Context context;
    private ArrayList nameId, unitId,priceId,dateId,invId,costId;

    public itemAdapter(Context context, ArrayList nameId, ArrayList unitId, ArrayList priceId, ArrayList dateId, ArrayList invId, ArrayList costId) {
        this.context = context;
        this.nameId = nameId;
        this.unitId = unitId;
        this.priceId = priceId;
        this.dateId = dateId;
        this.invId = invId;
        this.costId = costId;

    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_list, parent,false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {

        holder.nameId.setText(String.valueOf(nameId.get(position)));
        holder.unitId.setText(String.valueOf(unitId.get(position)));
        holder.priceId.setText(String.valueOf(priceId.get(position)));
        holder.dateId.setText(String.valueOf(dateId.get(position)));
        holder.invId.setText(String.valueOf(invId.get(position)));
        holder.costId.setText(String.valueOf(costId.get(position)));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(context, "Item "+ position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context,editList.class);
                intent.putExtra("name", String.valueOf(nameId.get(position)));
                intent.putExtra("unit", String.valueOf(unitId.get(position)));
                intent.putExtra("price", String.valueOf(priceId.get(position)));
                intent.putExtra("date", String.valueOf(dateId.get(position)));
                intent.putExtra("inv", String.valueOf(invId.get(position)));
                intent.putExtra("cost", String.valueOf(costId.get(position)));
                context.startActivity(intent);


            }
        });
    }

    @Override
    public int getItemCount() {

        return nameId.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {

        TextView nameId,unitId,priceId,dateId,invId,costId;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            nameId = itemView.findViewById(R.id.itemNameRv);
            unitId = itemView.findViewById(R.id.itemUnitRv);
            priceId = itemView.findViewById(R.id.itemPriceRv);
            dateId = itemView.findViewById(R.id.itemDateRv);
            invId = itemView.findViewById(R.id.itemInvRv);
            costId = itemView.findViewById(R.id.itemCostRv);


        }
    }
}

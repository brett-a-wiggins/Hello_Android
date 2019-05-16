package com.example.hello_android;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Recycler_View_Adapter_Fuel_Statistics extends RecyclerView.Adapter<View_Holder> {

    ArrayList<FuelTransaction> list = SelectVehicleActivity.getTempVehicle().getFuelTransList();
    Context context;

    public Recycler_View_Adapter_Fuel_Statistics(ArrayList<FuelTransaction> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Inflate the layout, initialize the View Holder
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fuelstat_row_layout, parent, false);
        View_Holder holder = new View_Holder(v);
        return holder;

    }

    @Override
    public void onBindViewHolder(View_Holder holder, int position) {

        //Use the provided View Holder on the onCreateViewHolder method to populate the current row on the RecyclerView
        holder.fuelDateTextView.setText(list.get(position).getTransactionDate().toString());
        holder.fuelLocationTextView.setText(list.get(position).getLocation());
        holder.fuelPricePerLitreTextView.setText(String.format("$%.2f" ,list.get(position).getPricePerLitre()));
        holder.fuelLitresTextView.setText(String.format("%.2f",list.get(position).getLitres()));
        holder.fuelCostTextView.setText(String.format("$%.2f",list.get(position).getFuelTotal()));

        //animate(holder);

    }

    @Override
    public int getItemCount() {
        //returns the number of elements the RecyclerView will display
        return list.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    // Insert a new item to the RecyclerView on a predefined position
    public void insert(int position, FuelTransaction data) {
        list.add(position, data);
        notifyItemInserted(position);
    }

    // Remove a RecyclerView item containing a specified Data object
    public void remove(FuelTransaction data) {
        int position = list.indexOf(data);
        list.remove(position);
        notifyItemRemoved(position);
    }

}
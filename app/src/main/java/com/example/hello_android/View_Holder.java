package com.example.hello_android;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class View_Holder extends RecyclerView.ViewHolder {

    CardView cv;
    TextView fuelDateTextView;
    TextView fuelLocationTextView;
    TextView fuelPricePerLitreTextView;
    TextView fuelLitresTextView;
    TextView fuelCostTextView;

    View_Holder(View itemView) {
        super(itemView);
        cv = (CardView) itemView.findViewById(R.id.cardView);
        fuelDateTextView = itemView.findViewById(R.id.fueldate_textview);
        fuelLocationTextView = itemView.findViewById(R.id.location_textview);
        fuelPricePerLitreTextView = itemView.findViewById(R.id.priceperlitre_textview);
        fuelLitresTextView = itemView.findViewById(R.id.litres_textview);
        fuelCostTextView = itemView.findViewById(R.id.fuelcost_textview);
    }
}
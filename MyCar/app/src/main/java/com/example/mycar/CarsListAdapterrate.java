package com.example.mycar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CarsListAdapterrate extends ArrayAdapter<Appoin>{

    // invoke the suitable constructor of the ArrayAdapter class
    public CarsListAdapterrate(@NonNull Context context, ArrayList<Appoin> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view_follow, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Appoin currentNumberPosition = getItem(position);

        TextView t=currentItemView.findViewById(R.id.text);
        TextView t1=currentItemView.findViewById(R.id.type);
        TextView t2=currentItemView.findViewById(R.id.date);
        t1.setText(currentNumberPosition.getType());
        t.setText(currentNumberPosition.getImmat());
        t2.setText(currentNumberPosition.getDate());
        currentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getContext(),Rate2.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("immat",currentNumberPosition.getImmat());
                getContext().startActivity(i);
            }
        });

        // then return the recyclable view
        return currentItemView;
    }
}

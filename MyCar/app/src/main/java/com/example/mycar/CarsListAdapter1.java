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

public class CarsListAdapter1 extends ArrayAdapter<Vehicle>{

    // invoke the suitable constructor of the ArrayAdapter class
    public CarsListAdapter1(@NonNull Context context, ArrayList<Vehicle> arrayList) {

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
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.custom_list_view, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        Vehicle currentNumberPosition = getItem(position);

        TextView t=currentItemView.findViewById(R.id.text);
        t.setText(currentNumberPosition.getImmat());
        currentItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getContext(),Apointement1.class);
                i.putExtra("immat",currentNumberPosition.getImmat());
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                getContext().startActivity(i);
            }
        });

        // then return the recyclable view
        return currentItemView;
    }
}

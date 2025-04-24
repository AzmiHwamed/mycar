package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ApointemetDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apointemet_details);
        TextView type=findViewById(R.id.type);
        type.setText(getIntent().getExtras().getString("type"));
        TextView shop=findViewById(R.id.shop);
        shop.setText(getIntent().getExtras().getString("shop"));
        TextView date=findViewById(R.id.date);
        date.setText(getIntent().getExtras().getString("date"));
        TextView immat=findViewById(R.id.regis);
        immat.setText(getIntent().getExtras().getString("immat"));
    }
}
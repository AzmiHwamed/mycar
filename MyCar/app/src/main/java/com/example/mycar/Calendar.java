package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.widget.ArrayAdapter;

public class Calendar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.setting);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.follow:
                        startActivity(new Intent(getApplicationContext(),FollowUp.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.cars:
                        startActivity(new Intent(getApplicationContext(),Cars.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.quest:
                        startActivity(new Intent(getApplicationContext(),Help.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.setting:
                        return true;
                }
                return false;
            }
        });
        Button b=findViewById(R.id.next);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=getIntent().getExtras().getInt("type",3);
                switch (x){
                    case 0:{
                        Intent i =new Intent(getApplicationContext(),Map.class);
                        i.putExtra("type",x);
                        i.putExtra("kilo",getIntent().getExtras().getString("kilo"));
                        i.putExtra("taille",getIntent().getExtras().getString("taille"));
                        i.putExtra("date","5/9/2023 10:00");
                        i.putExtra("immat",getIntent().getExtras().getString("immat"));
                        startActivity(i);
                    }
                    case 1:{
                        Intent i =new Intent(getApplicationContext(),Map.class);
                        i.putExtra("type",x);
                        i.putExtra("desc",getIntent().getExtras().getString("desc"));
                        i.putExtra("immat",getIntent().getExtras().getString("immat"));
                        i.putExtra("date","5/9/2023 10:00");
                        startActivity(i);
                    }
                    case 3:{
                        Intent i =new Intent(getApplicationContext(),Map.class);
                        i.putExtra("type",x);
                        i.putExtra("date","5/9/2023 10:00");
                        i.putExtra("immat",getIntent().getExtras().getString("immat"));
                        startActivity(i);
                    }
                }
            }
        });
        Spinner sd=findViewById(R.id.spinday);
        String[] day = { "12/10/2023","13/10/2023","14/10/2023","15/10/2023","16/10/2023"};
        String[] hour = {"10:00","10:30","11:00","11:30","12:00"};
        ArrayAdapter ad
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, day);
        ArrayAdapter ah
                = new ArrayAdapter(
                this,
                android.R.layout.simple_spinner_item, hour);
        sd.setAdapter(ad);
        Spinner sh=findViewById(R.id.spinhour);
        sd.setAdapter(ah);
    }
}
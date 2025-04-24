package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Rate2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate2);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.quest);

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
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),Apointement.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        RatingBar r=findViewById(R.id.stars);
        Button b=findViewById(R.id.rate);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(getApplicationContext(),Rate3.class);
                i.putExtra("immat",getIntent().getExtras().getString("immat"));
                EditText e=findViewById(R.id.etdesc);
                i.putExtra("stars",Float.toString(r.getRating()));
                startActivity(i);
            }
        });
    }
}
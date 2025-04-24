package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Rapide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rapide);
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
        LinearLayout l=findViewById(R.id.K10);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t=findViewById(R.id.kilo);
                Intent i =new Intent(getApplicationContext(),Calendar.class);
                i.putExtra("type",0);
                i.putExtra("immat",getIntent().getExtras().getString("immat"));
                i.putExtra("taille","10");
                i.putExtra("kilo",t.getText().toString());
                startActivity(i);
            }
        });
        LinearLayout l1=findViewById(R.id.K40);
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t=findViewById(R.id.kilo);
                Intent i =new Intent(getApplicationContext(),Calendar.class);
                i.putExtra("type",0);
                i.putExtra("taille","40");
                i.putExtra("immat",getIntent().getExtras().getString("immat"));
                i.putExtra("kilo",t.getText().toString());
                startActivity(i);
            }
        });
    }
}
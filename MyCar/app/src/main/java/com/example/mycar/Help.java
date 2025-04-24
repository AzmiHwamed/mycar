package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Help extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
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
        CardView c1=findViewById(R.id.satsfaction);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Rate1.class));
            }
        });
        CardView c2=findViewById(R.id.complaint);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Complaint1.class));
            }
        });
    }
}
package com.example.mycar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;

public class Addvehicle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addvehicle);
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.cars);

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
                        return true;
                    case R.id.quest:
                        startActivity(new Intent(getApplicationContext(),Help.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.setting:
                        startActivity(new Intent(getApplicationContext(),Apointement.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        Button b=findViewById(R.id.add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth mAuth=FirebaseAuth.getInstance();
                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference myRef=firebaseDatabase.getReference();
                String vid= Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
                System.out.println(vid);
                EditText e=findViewById(R.id.EtImmat);
                myRef.child("Vehicles").child(vid).child("immat").setValue(e.getText().toString());
                EditText e1=findViewById(R.id.Etchassis);
                myRef.child("Vehicles").child(vid).child("carburant").setValue("Gaz");
                myRef.child("Vehicles").child(vid).child("chassis").setValue(e1.getText().toString());
                myRef.child("Vehicles").child(vid).child("owner").setValue(mAuth.getCurrentUser().getUid());
            }
        });

    }
}
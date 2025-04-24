package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Timestamp;

public class ApointDone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoint_done);





        int x=getIntent().getExtras().getInt("type",3);
        switch (x){
            case 0:{
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                String vid= Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
                myRef.child("apointements").child(vid).child("type").setValue("Rapide");
                myRef.child("apointements").child(vid).child("immat").setValue(getIntent().getExtras().getString("immat"));
                myRef.child("apointements").child(vid).child("taille").setValue(getIntent().getExtras().getString("taille"));
                myRef.child("apointements").child(vid).child("kilo").setValue(getIntent().getExtras().getString("kilo"));
                myRef.child("apointements").child(vid).child("date").setValue(getIntent().getExtras().getString("date"));
                myRef.child("apointements").child(vid).child("shop").setValue(getIntent().getExtras().getString("shop"));
                myRef.child("apointements").child(vid).child("owner").setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
            }
            case 1:{
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                String vid= Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
                myRef.child("apointements").child(vid).child("type").setValue("Diagnostics");
                myRef.child("apointements").child(vid).child("immat").setValue(getIntent().getExtras().getString("immat"));
                myRef.child("apointements").child(vid).child("desc").setValue(getIntent().getExtras().getString("desc"));
                myRef.child("apointements").child(vid).child("date").setValue(getIntent().getExtras().getString("date"));
                myRef.child("apointements").child(vid).child("shop").setValue(getIntent().getExtras().getString("shop"));
                myRef.child("apointements").child(vid).child("owner").setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());

            }
            case 3:{
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference();
                String vid= Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
                myRef.child("apointements").child(vid).child("type").setValue("Reparation");
                myRef.child("apointements").child(vid).child("immat").setValue(getIntent().getExtras().getString("immat"));
                myRef.child("apointements").child(vid).child("date").setValue(getIntent().getExtras().getString("date"));
                myRef.child("apointements").child(vid).child("shop").setValue(getIntent().getExtras().getString("shop"));
                myRef.child("apointements").child(vid).child("owner").setValue(FirebaseAuth.getInstance().getCurrentUser().getUid());
            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent i =new Intent(getApplicationContext(),Apointement.class);
        startActivity(i);
    }
}
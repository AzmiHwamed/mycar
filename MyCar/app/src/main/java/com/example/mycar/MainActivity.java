package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
        if(mAuth.getCurrentUser()!=null){
            //TODO:Go To Main Page
        }
        else{
            System.out.println("a8aaaaaa");
            Intent i =new Intent(getApplicationContext(),Login.class);
            startActivity(i);
        }
}
}
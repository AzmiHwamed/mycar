package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ImageView map=findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x=getIntent().getExtras().getInt("type",3);
                switch (x){
                    case 0:{
                        Intent i =new Intent(getApplicationContext(),ApointDone.class);
                        i.putExtra("type",x);
                        i.putExtra("kilo",getIntent().getExtras().getString("kilo"));
                        i.putExtra("immat",getIntent().getExtras().getString("immat"));
                        i.putExtra("taille",getIntent().getExtras().getString("taille"));
                        i.putExtra("date",getIntent().getExtras().getString("date"));
                        i.putExtra("shop","gabes");
                        startActivity(i);
                    }
                    case 1:{
                        Intent i =new Intent(getApplicationContext(),ApointDone.class);
                        i.putExtra("type",x);
                        i.putExtra("desc",getIntent().getExtras().getString("desc"));
                        i.putExtra("immat",getIntent().getExtras().getString("immat"));
                        i.putExtra("date",getIntent().getExtras().getString("date"));
                        i.putExtra("shop","gabes");

                        startActivity(i);
                    }
                    case 3:{
                        Intent i =new Intent(getApplicationContext(),ApointDone.class);
                        i.putExtra("type",x);
                        i.putExtra("date",getIntent().getExtras().getString("date"));
                        i.putExtra("immat",getIntent().getExtras().getString("immat"));
                        i.putExtra("shop","gabes");
                        startActivity(i);
                    }
                }
            }
        });
    }
}
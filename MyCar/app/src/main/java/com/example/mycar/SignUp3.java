package com.example.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class SignUp3 extends AppCompatActivity {
    EditText etChassis;
    EditText etimmat;
    EditText marque;
    RadioGroup radioGroup;
    Button signUp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);
        etChassis=findViewById(R.id.Etchassis);
        etimmat=findViewById(R.id.EtImmat);
        marque=findViewById(R.id.EtModel);
        radioGroup=findViewById(R.id.group);
        signUp=findViewById(R.id.signUp);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SignUp4.class);
                i.putExtra("type",getIntent().getExtras().getString("type"));
                i.putExtra("email",getIntent().getExtras().getString("email"));
                i.putExtra("password",getIntent().getExtras().getString("password"));
                i.putExtra("name",getIntent().getExtras().getString("name"));
                i.putExtra("last",getIntent().getExtras().getString("last"));
                i.putExtra("address",getIntent().getExtras().getString("address"));
                i.putExtra("phone",getIntent().getExtras().getString("phone"));
                i.putExtra("chassis",etChassis.getText().toString());
                i.putExtra("immat",etimmat.getText().toString());
                RadioButton r=findViewById(radioGroup.getCheckedRadioButtonId());
                i.putExtra("carburant",r.getText());
                startActivity(i);
            }
        });
    }
}

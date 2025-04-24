package com.example.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp1 extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;
    EditText etName;
    EditText etLast;
    EditText etNumber;
    EditText etAdress;
    Button next;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);
        etEmail=findViewById(R.id.Etemail);
        etPassword=findViewById(R.id.EtPassword);
        etAdress=findViewById(R.id.EtAdress);
        etLast=findViewById(R.id.Etlastname);
        etNumber=findViewById(R.id.EtPhone);
        etName=findViewById(R.id.Etname);
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth firebaseAuth =FirebaseAuth.getInstance();
                firebaseAuth.signInWithEmailAndPassword(etEmail.getText().toString(),etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(SignUp1.this, "User with this Email already exists", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent i=new Intent(getApplicationContext(),SignUp3.class);
                            i.putExtra("type","Indiv");
                            i.putExtra("email",etEmail.getText().toString());
                            i.putExtra("password",etPassword.getText().toString());
                            i.putExtra("email",etEmail.getText().toString());
                            i.putExtra("name",etName.getText().toString());
                            i.putExtra("last",etLast.getText().toString());
                            i.putExtra("address",etAdress.getText().toString());
                            i.putExtra("phone",etNumber.getText().toString());
                            firebaseAuth.signOut();
                            startActivity(i);

                        }
                    }
                });
            }
        });


    }
}

package com.example.mycar;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
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

import java.util.Properties;
import java.util.Random;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.sql.Timestamp;
public class SignUp4 extends AppCompatActivity {
    CardView comp;
    CardView indiv;
    TextView login;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);
//        String to="majdiboubaker82@gmail.com";
//        String subject="Verification mail from MyCar";
//        Random r = new Random();
//        int i1 = r.nextInt(9999 - 1000) + 1000;
//        String messag=Integer.toString(i1);
//        String host = "smtp.gmail.com"; // replace with your SMTP server host
//        String port = "587"; // replace with your SMTP server port
//        String username = "akihimaazmi@gmail.com"; // replace with your Gmail email address
//        String password = "qweasdyxc1"; // replace with your Gmail account password
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", host);
//        properties.put("mail.smtp.port", port);
//        properties.put("mail.smtp.auth", "true");
//        properties.put("mail.smtp.starttls.enable", "true");
//
//        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
//                return new javax.mail.PasswordAuthentication(username, password);
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(username));
//            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("majdiboubaker82@gmail.com"));
//            message.setSubject("subject");
//            message.setText(messag);
//
//            Transport.send(message);
//
//            // Email sent successfully
//        } catch (MessagingException e) {
//            // Handle the exception
//        }

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(getIntent().getExtras().getString("email"),getIntent().getExtras().getString("password")).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                   FirebaseAuth mAuth=FirebaseAuth.getInstance();
                    FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                    DatabaseReference myRef=firebaseDatabase.getReference();
                    myRef.child("CLients").child(getIntent().getExtras().getString("type")).child(mAuth.getCurrentUser().getUid()).child("Email").setValue(getIntent().getExtras().getString("email"));
                    myRef.child("CLients").child(getIntent().getExtras().getString("type")).child(mAuth.getCurrentUser().getUid()).child("Password").setValue(getIntent().getExtras().getString("password"));
                    myRef.child("CLients").child(getIntent().getExtras().getString("type")).child(mAuth.getCurrentUser().getUid()).child("Name").setValue(getIntent().getExtras().getString("name"));
                    myRef.child("CLients").child(getIntent().getExtras().getString("type")).child(mAuth.getCurrentUser().getUid()).child("Last").setValue(getIntent().getExtras().getString("last"));
                    myRef.child("CLients").child(getIntent().getExtras().getString("type")).child(mAuth.getCurrentUser().getUid()).child("Address").setValue(getIntent().getExtras().getString("address"));
                    myRef.child("CLients").child(getIntent().getExtras().getString("type")).child(mAuth.getCurrentUser().getUid()).child("Phone").setValue(getIntent().getExtras().getString("phone"));
                    String vid= Long.toString(new Timestamp(System.currentTimeMillis()).getTime());
                    System.out.println(vid);
                    myRef.child("Vehicles").child(vid).child("immat").setValue(getIntent().getExtras().getString("immat"));
                    myRef.child("Vehicles").child(vid).child("carburant").setValue(getIntent().getExtras().getString("carburant"));
                    myRef.child("Vehicles").child(vid).child("chassis").setValue(getIntent().getExtras().getString("chassis"));
                    myRef.child("Vehicles").child(vid).child("owner").setValue(mAuth.getCurrentUser().getUid());
                   Intent i =new Intent(getApplicationContext(),Cars.class);
                   startActivity(i);
                }
                else{
                    Toast.makeText(SignUp4.this, task.getException().toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}

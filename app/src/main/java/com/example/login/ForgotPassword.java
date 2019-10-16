package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    Button reset;
    EditText email;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        reset=(Button)findViewById(R.id.reset);
        email=(EditText)findViewById(R.id.email);
        firebaseAuth=FirebaseAuth.getInstance();
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               firebaseAuth.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                   @Override
                   public void onComplete(@NonNull Task<Void> task) {
                       if(task.isSuccessful())
                       {
                           Toast.makeText(ForgotPassword.this,"password reset wmail sent!",Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(ForgotPassword.this,Create.class));
                       }
                       else {
                           Toast.makeText(ForgotPassword.this,"password reset error!",Toast.LENGTH_SHORT).show();
                       }
                   }
               });
            }
        });

    }
}

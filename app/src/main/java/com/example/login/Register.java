package com.example.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    TextInputEditText email,password,confirm;
    Button register;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        email=(TextInputEditText)findViewById(R.id.email);
        password=(TextInputEditText)findViewById(R.id.password);
        confirm=(TextInputEditText)findViewById(R.id.confirm);
        register=(Button)findViewById((R.id.register));

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth =FirebaseAuth.getInstance();
                    firebaseAuth.createUserWithEmailAndPassword(email.getText().toString()
                            , password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Register.this, "Register successfull", Toast.LENGTH_SHORT).show();

                                startActivity(new Intent(Register.this,Create.class));
                            } else {
                                Toast.makeText(Register.this, "error", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }

        });

    }
}

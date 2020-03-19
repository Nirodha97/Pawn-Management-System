package com.example.pawn01;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button log;
    TextView createNew;
    EditText username;
    EditText password;
    FirebaseAuth firebaseAuth;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = (Button) findViewById(R.id.login_button);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        createNew=(TextView) findViewById(R.id.create_account);

        firebaseAuth = FirebaseAuth.getInstance();
        //Goto dash board
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1= username.getText().toString().trim();
                String password1=password.getText().toString().trim();

                if(TextUtils.isEmpty(email1))
                {
                  //  progressBar.setVisibility(View.INVISIBLE);
                    username.setError("User Name is required");
                    return;
                }

                if(TextUtils.isEmpty(password1))
                {
                   // progressBar.setVisibility(View.INVISIBLE);
                    password.setError("Password is required");
                    return;
                }

                if(password1.length()<6)
                {
                    //progressBar.setVisibility(View.INVISIBLE);
                    password.setError("Password must be more than 6 characters");
                }


                firebaseAuth.signInWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), dashboard.class));
                    } else {
                        Toast.makeText(MainActivity.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
                });


            }
        });

        //Go to register page
        createNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity1();
            }
        });
    }
    public void openNewActivity1(){

        Intent i1 = new Intent(this, register.class);
        startActivity(i1);
    }


    }

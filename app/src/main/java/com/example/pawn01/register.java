package com.example.pawn01;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    Button register;
    EditText username;
    EditText nic;
    EditText email;
    EditText password;
    EditText conform_password;
    TextView login_here;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register=(Button) findViewById(R.id.reg);
        username =(EditText) findViewById(R.id.username);
        nic= (EditText) findViewById(R.id.nic);
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.pw);
        conform_password=(EditText) findViewById(R.id.cpw);
        login_here=(TextView) findViewById(R.id.login_here);
        progressBar=(ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);

               firebaseAuth = FirebaseAuth.getInstance();

        /*if (firebaseAuth.getCurrentUser()!=null)
        {
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
         */

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email1= email.getText().toString().trim();
                String password1=password.getText().toString().trim();

                if(TextUtils.isEmpty(email1))
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    email.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(password1))
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    password.setError("Password is required");
                    return;
                }

                if(password1.length()<6)
                {
                    progressBar.setVisibility(View.INVISIBLE);
                    password.setError("Password must be more than 6 characters");
                }

                progressBar.setVisibility(View.VISIBLE);


                firebaseAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(register.this, "User Created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));

                        }
                        else
                        {
                            progressBar.setVisibility(View.INVISIBLE);
                            Toast.makeText(register.this, "Error !"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });

        login_here.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

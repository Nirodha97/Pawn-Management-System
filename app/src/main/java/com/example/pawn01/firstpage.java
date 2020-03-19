package com.example.pawn01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class firstpage extends AppCompatActivity {

    Button user;
    Button admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstpage);
        user=(Button) findViewById(R.id.user);
        admin=(Button) findViewById(R.id.admin);


    user.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openNewActivity();
        }
    });
    admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity2();
            }
        });
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void openNewActivity2(){
        Intent intent = new Intent(this, adminlogin.class);
        startActivity(intent);
    }
}

package com.example.pawn01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class adminlogin extends AppCompatActivity {

    Button admin_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        admin_login=(Button) findViewById(R.id.admin_login_button);
        admin_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity3();
            }
        });
    }

    public void openNewActivity3(){
        Intent intent = new Intent(this,admin_dashboard1.class);
        startActivity(intent);
    }
}

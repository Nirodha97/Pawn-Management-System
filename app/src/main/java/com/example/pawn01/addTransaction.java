package com.example.pawn01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class addTransaction extends AppCompatActivity {

    EditText name;
    EditText nic;
    EditText address;
    EditText tel;
    EditText email;
    EditText ammount;
    EditText description;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);

        name=(EditText) findViewById(R.id.fullname);
        nic=(EditText) findViewById(R.id.nic);
        address=(EditText) findViewById(R.id.address);
        tel=(EditText) findViewById(R.id.telephone);
        email=(EditText) findViewById(R.id.email);
        ammount=(EditText) findViewById(R.id.ammount);
        description=(EditText) findViewById(R.id.description);

    }
}

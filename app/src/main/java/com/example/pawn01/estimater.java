package com.example.pawn01;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class estimater extends AppCompatActivity {

    EditText quantity;
    EditText gold_purity;
    EditText white_gold_purity;
    EditText silver_purity;
    EditText weight;
    EditText rate;
    Button calculater;
    Button transaction;
    EditText loan;
    TextView value;
    double q;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estimater);

        Spinner spinner = findViewById(R.id.spinner);
        quantity =(EditText)findViewById(R.id.quantity);
        gold_purity =(EditText)findViewById(R.id.Gold_purity);
        white_gold_purity =(EditText)findViewById(R.id.whiteGold_purity);
        silver_purity =(EditText)findViewById(R.id.silver_purity);
        weight =(EditText)findViewById(R.id.weight);
        rate =(EditText)findViewById(R.id.rate);
        loan =(EditText)findViewById(R.id.loan_ammount);
        calculater =(Button) findViewById(R.id.calculater);
        transaction =(Button) findViewById(R.id.transaction);
        value =(TextView)findViewById(R.id.value);

        q=Double.parseDouble(quantity.getText().toString());
        q=q+10;



        calculater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("-SELECT-");
        arrayList.add("Bangle");
        arrayList.add("Bracelet");
        arrayList.add("Necklace");
        arrayList.add("Chain");
        arrayList.add("Pendant");
        arrayList.add("Earring");
        arrayList.add("Anklet");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,                         android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String tutorialsName = parent.getItemAtPosition(position).toString();
                if(tutorialsName!="-SELECT-") {
                    Toast.makeText(parent.getContext(), "Selected: " + tutorialsName, Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }

    private void calculate() {
        value.setText(Double.toString(q)+" Rs");
    }
}

package com.example.pawn01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class dashboard extends AppCompatActivity {

    Button estimater;
    Button transaction_details;
    Button add_transaction;
    Button calculater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        estimater= (Button) findViewById(R.id.estimater);
        transaction_details=(Button) findViewById(R.id.transaction_details);
        add_transaction=(Button) findViewById(R.id.add_transaction);
        calculater=(Button) findViewById(R.id.calculater);

        estimater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEstimater();
            }
        });


        transaction_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransactionDetail();
            }
        });

        add_transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddTransaction();
            }
        });


        calculater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalculater();
            }
        });
    }

    private void openCalculater() {
        Intent i2= new Intent();
        i2.setAction(Intent.ACTION_MAIN);
        i2.addCategory(Intent.CATEGORY_APP_CALCULATOR);
        i2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i2);
    }


    private void openAddTransaction() {
        Intent i1 = new Intent(this, addTransaction.class);
        startActivity(i1);
    }

    private void openTransactionDetail() {
        Intent i1 = new Intent(this, transactionDetails.class);
        startActivity(i1);
    }

    private void openEstimater() {
        Intent i1 = new Intent(this, estimater.class);
        startActivity(i1);
    }





}

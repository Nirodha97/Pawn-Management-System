package com.example.pawn01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class admin_dashboard1 extends AppCompatActivity {

    Button estimater;
    Button transaction_details;
    Button add_transaction;
    Button calculater;
    Button users_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard1);

        estimater= (Button) findViewById(R.id.estimater);
        transaction_details=(Button) findViewById(R.id.transaction_details);
        add_transaction=(Button) findViewById(R.id.add_transaction);
        calculater=(Button) findViewById(R.id.calculater1);
        users_details=(Button) findViewById(R.id.users_details);



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
        users_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUsersDetail();
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

    private void openEstimater() {
        Intent i1 = new Intent(this, estimater.class);
        startActivity(i1);
    }

    private void openTransactionDetail() {
        Intent i1 = new Intent(this, transactionDetails.class);
        startActivity(i1);
    }

    private void openAddTransaction() {
        Intent i1 = new Intent(this, addTransaction.class);
        startActivity(i1);
    }

    private void openUsersDetail() {
        Intent i1 = new Intent(this, userDetails.class);
        startActivity(i1);
    }




}

package com.example.nyasha.zimmobo.make_payment.regularpayments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.make_payment.regularpayments.ecocashinvest.EcocashInvest;
import com.example.nyasha.zimmobo.make_payment.regularpayments.paytollgate.PayTollGate;
import com.example.nyasha.zimmobo.make_payment.regularpayments.payzesa.PayZesa;
import com.example.nyasha.zimmobo.make_payment.regularpayments.payzol.PayZol;

public class RegularPayments extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regular_payments);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void payZesa(View view){
        Intent intent = new Intent(RegularPayments.this,PayZesa.class);
        startActivity(intent);
    }
    public void buyZol(View view){
        Intent intent = new Intent(RegularPayments.this, PayZol.class);
        startActivity(intent);
    }
    public void ecocashInvest(View view){
        Intent intent = new Intent(RegularPayments.this, EcocashInvest.class);
        startActivity(intent);
    }
    public void payTollGate(View view){
        Intent intent = new Intent(RegularPayments.this, PayTollGate.class);
        startActivity(intent);
    }
}

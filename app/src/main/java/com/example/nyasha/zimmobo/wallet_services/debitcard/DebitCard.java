package com.example.nyasha.zimmobo.wallet_services.debitcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.wallet_services.debitcard.physical.MasterCard_Physical;
import com.example.nyasha.zimmobo.wallet_services.debitcard.virtual.MasterCard_Virtual;

public class DebitCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debit_card);
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

    public void masterCardPhy(View view){
        Intent intent = new Intent(DebitCard.this, MasterCard_Physical.class);
        startActivity(intent);
    }
    public void masterCardVirt(View view){
        Intent intent = new Intent(DebitCard.this, MasterCard_Virtual.class);
        startActivity(intent);
    }
}

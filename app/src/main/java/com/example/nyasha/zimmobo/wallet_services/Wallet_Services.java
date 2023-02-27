package com.example.nyasha.zimmobo.wallet_services;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.wallet_services.account_enquiry.AccountEnquiry;
import com.example.nyasha.zimmobo.wallet_services.changelanguage.ChangeLanguage;
import com.example.nyasha.zimmobo.wallet_services.debitcard.DebitCard;
import com.example.nyasha.zimmobo.wallet_services.multicurrency.Multi_Currency;
import com.example.nyasha.zimmobo.wallet_services.nextofkin.NextOfKin;

public class Wallet_Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet__services);
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

    public void debitCard(View view){
        Intent intent = new Intent(Wallet_Services.this, DebitCard.class);
        startActivity(intent);
    }

    public void accountEnquiry(View view){
        Intent intent = new Intent(Wallet_Services.this, AccountEnquiry.class);
        startActivity(intent);
    }

    public void nxtOfKin(View view){

        Intent intent = new Intent(Wallet_Services.this, NextOfKin.class);
        startActivity(intent);
    }
    public void language(View view){
        Intent intent = new Intent(Wallet_Services.this, ChangeLanguage.class);
        startActivity(intent);
    }
    public void multiCurrency(View view){
        Intent intent = new Intent(Wallet_Services.this, Multi_Currency.class);
        startActivity(intent);
    }
    public void pinReset(View view){
        
    }
}

package com.example.nyasha.zimmobo.databundles;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.airtime.BuyAirtime;
import com.example.nyasha.zimmobo.databundles.facebook.Facebook_Bundles;
import com.example.nyasha.zimmobo.databundles.whatsapp.Whatsapp_Bundles;

public class Data_Bundles extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data__bundles);

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
    public void dataBundles(View view){
    }

    public void whatsappBundles(View view){
        Intent intent = new Intent(Data_Bundles.this, Whatsapp_Bundles.class);
        startActivity(intent);
    }

    public void facebookBundles(View view){
        Intent intent = new Intent(Data_Bundles.this, Facebook_Bundles.class);
        startActivity(intent);
    }
}

package com.example.nyasha.zimmobo.databundles.whatsapp;

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

public class Other_Whatsapp extends AppCompatActivity {

    EditText rcvr;
    String txtRcvr;
    TelephonyManager telephonyManager;
    String simOperatorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other__whatsapp);
        telephonyManager = ((TelephonyManager) Other_Whatsapp.this.getSystemService(Context.TELEPHONY_SERVICE));
        simOperatorName = telephonyManager.getSimOperatorName();
        rcvr = (EditText) findViewById(R.id.rcvrNumber);

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
    public void sendBundles(View view){
        Intent intent = getIntent();
        String name = intent.getExtras().getString("nyasha");
        txtRcvr = rcvr.getText().toString();
        if(simOperatorName.equalsIgnoreCase("Econet")){
            String ussdCode = "*" + "151"+"*"+"4"+"*"+"5"+"*"+"2"+"*"+txtRcvr+"*"+name+ Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(Other_Whatsapp.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));
        }
        else if(simOperatorName.equalsIgnoreCase("Telecel")){
            Toast.makeText(Other_Whatsapp.this,"ot supported yet on "+simOperatorName,Toast.LENGTH_LONG).show();
        }
    }
}

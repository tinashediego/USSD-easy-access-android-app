package com.example.nyasha.zimmobo.airtime;

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

public class OtherMobile extends AppCompatActivity {
    EditText amount,phoneNumber;
    String txtAmount,txtPhoneNumber;
    TelephonyManager telephonyManager;
    String simOperatorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_mobile);
        telephonyManager = ((TelephonyManager) OtherMobile.this.getSystemService(Context.TELEPHONY_SERVICE));
        simOperatorName = telephonyManager.getSimOperatorName();
        amount = (EditText)findViewById(R.id.amount);
        phoneNumber = (EditText) findViewById(R.id.mobile_number);
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
    public void otherMobile(View view){
        Intent intent = getIntent();
        txtAmount = intent.getStringExtra("value");
        txtPhoneNumber = phoneNumber.getText().toString();

        if(simOperatorName.equalsIgnoreCase("Econet")){
            String ussdCode = "*" + "151"+"*"+"4"+"*"+"1"+"*"+"2"+"*"+txtPhoneNumber+"*"+txtAmount+ Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(OtherMobile.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));
        }
        else if(simOperatorName.equalsIgnoreCase("Telecel")){
            Toast.makeText(OtherMobile.this,"not supported yet on "+simOperatorName,Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(OtherMobile.this,"not supported yet on "+simOperatorName,Toast.LENGTH_LONG).show();
        }
    }
}

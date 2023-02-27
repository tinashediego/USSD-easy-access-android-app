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
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.databundles.Data_Bundles;

public class Whatsapp_Bundles extends AppCompatActivity {
    int reg;
    TelephonyManager telephonyManager;
    String simOperatorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp__bundles);
        telephonyManager = ((TelephonyManager) Whatsapp_Bundles.this.getSystemService(Context.TELEPHONY_SERVICE));
        simOperatorName = telephonyManager.getSimOperatorName();
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
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.daily:
                if (checked)
                    reg = 1;
                break;
            case R.id.weekly:
                if (checked)
                    reg = 2;
                break;
            case R.id.monthly:
                if (checked)
                    reg = 3;
                break;
        }
    }
    public void otherMobile(View view){
        String txtReg = String.valueOf(reg);
        Intent intent = new Intent(Whatsapp_Bundles.this,Other_Whatsapp.class);
        intent.putExtra("nyasha",txtReg);
        startActivity(intent);
    }
    public void myWhatsappMobile(View view){
        if(simOperatorName.equalsIgnoreCase("Econet")){
            String ussdCode = "*" + "151"+"*"+"4"+"*"+"5"+"*"+"1"+"*"+reg+ Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(Whatsapp_Bundles.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling

                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));
        }
        else if(simOperatorName.equalsIgnoreCase("Telecel")){
            Toast.makeText(Whatsapp_Bundles.this,"ot supported yet on "+simOperatorName,Toast.LENGTH_LONG).show();
        }
    }
}

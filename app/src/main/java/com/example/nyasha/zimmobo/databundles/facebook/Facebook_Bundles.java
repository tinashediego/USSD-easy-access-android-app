package com.example.nyasha.zimmobo.databundles.facebook;

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
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.databundles.whatsapp.Whatsapp_Bundles;

public class Facebook_Bundles extends AppCompatActivity {

    int reg;
    TelephonyManager telephonyManager;
    String simOperatorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        telephonyManager = ((TelephonyManager) Facebook_Bundles.this.getSystemService(Context.TELEPHONY_SERVICE));
        simOperatorName = telephonyManager.getSimOperatorName();
        setContentView(R.layout.activity_facebook__bundles);
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
    public void myFacebookMobile(View view){
        if(simOperatorName.equalsIgnoreCase("Econet")){
            String ussdCode = "*" + "151"+"*"+"4"+"*"+"4"+"*"+"1"+"*"+reg+ Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(Facebook_Bundles.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));
        }
        else if(simOperatorName.equalsIgnoreCase("Telecel")){
            Toast.makeText(Facebook_Bundles.this,"ot supported yet on "+simOperatorName,Toast.LENGTH_LONG).show();
        }
    }
    public void otherMobile(View view){
        String txtReg = String.valueOf(reg);
        Intent intent = new Intent(Facebook_Bundles.this,OtherFacebook.class);
        intent.putExtra("value",txtReg);
        startActivity(intent);
    }
}

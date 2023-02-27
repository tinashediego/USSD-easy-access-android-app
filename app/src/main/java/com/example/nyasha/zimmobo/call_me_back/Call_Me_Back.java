package com.example.nyasha.zimmobo.call_me_back;

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

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.airtime.Airtime_Menu;
import com.example.nyasha.zimmobo.airtime.Transfer_Airtime;

public class Call_Me_Back extends AppCompatActivity {
    EditText rcvr;
    String txtrcvr;
    TelephonyManager telephonyManager;
    String simOperatorName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call__me__back);
        telephonyManager = ((TelephonyManager) Call_Me_Back.this.getSystemService(Context.TELEPHONY_SERVICE));
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
    public void sendCallMeBack(View view){
        txtrcvr = rcvr.getText().toString();
        if(simOperatorName.equalsIgnoreCase("Econet")) {
            String ussdCode = "*" + "555" + "*" + txtrcvr + Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(Call_Me_Back.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));
        }
        else if(simOperatorName.equalsIgnoreCase("Telecel")) {
            String ussdCode = "*" + "140" + "*" + txtrcvr + Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(Call_Me_Back.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));
        }

    }
}

package com.example.nyasha.zimmobo.banking_services;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nyasha.zimmobo.R;

public class Banking_Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking__services);
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
    public void WalletToBank(View view){
        Intent intent = new Intent(Banking_Services.this,WalletToBank.class);
        startActivity(intent);
    }
    public void BankToWalletTransfer(View view){
        Intent intent = new Intent(Banking_Services.this,BankToWallet.class);
        startActivity(intent);
    }
    public void accountStatement(View view){
        String ussdCode = "*" + "151" + "*" + "8" + "*" +3+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(Banking_Services.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
    public void balEnquiry(View view){
        String ussdCode = "*" + "151" + "*" + "8" + "*" +4+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(Banking_Services.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

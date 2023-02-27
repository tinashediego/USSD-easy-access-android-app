package com.example.nyasha.zimmobo.make_payment;

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
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.nyasha.zimmobo.R;

public class TransferToChurch extends AppCompatActivity {

    int reg;
    EditText merchant_code,amount,assembly;
    String txtMerchant_code,txtAmount,txtAssembly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer_to_church);
        merchant_code = (EditText) findViewById(R.id.merchant_code);
        amount = (EditText) findViewById(R.id.amount);
        assembly = (EditText) findViewById(R.id.assembly);
        reg = 4;
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
            case R.id.offering:
                if (checked)
                    reg = 1;
                break;
            case R.id.tithe:
                if (checked)
                    reg = 2;
                break;
            case R.id.buildingFund:
                if (checked)
                    reg = 3;
                break;
            case R.id.other:
                if (checked)
                    reg = 4;
                break;
        }
    }
    public void makePayment(View view){
        txtMerchant_code = merchant_code.getText().toString();
        txtAmount = amount.getText().toString();
        txtAssembly = assembly.getText().toString();
        String ussdCode = "*" + "151" +"*"+"2"+"*"+"5"+"*"+txtMerchant_code+"*"+txtAmount+"*"+reg+"*"+txtAssembly+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(TransferToChurch.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

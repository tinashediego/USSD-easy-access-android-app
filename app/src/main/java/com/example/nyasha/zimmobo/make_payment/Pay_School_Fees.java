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

import com.example.nyasha.zimmobo.R;

public class Pay_School_Fees extends AppCompatActivity {

    EditText merchant_code,amount,reference;
    String txtMerchant_code,txtAmount,txtReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay__school__fees);
        merchant_code = (EditText) findViewById(R.id.merchant_code);
        reference = (EditText) findViewById(R.id.referenceNumber);
        amount = (EditText) findViewById(R.id.amount);
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
    public void paySchoolFees(View view){
        txtMerchant_code = merchant_code.getText().toString();
        txtAmount = amount.getText().toString();
        txtReference = reference.getText().toString();
        String ussdCode = "*" + "151" +"*"+"2"+"*"+"3"+"*"+txtMerchant_code+"*"+txtAmount+"*"+txtReference+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(Pay_School_Fees.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

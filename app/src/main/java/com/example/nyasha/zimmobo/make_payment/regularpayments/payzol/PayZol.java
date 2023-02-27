package com.example.nyasha.zimmobo.make_payment.regularpayments.payzol;

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
import com.example.nyasha.zimmobo.banking_services.Banking_Services;

public class PayZol extends AppCompatActivity {

    EditText accnumber,amount;
    String txtAccnumber,txtAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_zol);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        accnumber = findViewById(R.id.accnumber);
        amount = findViewById(R.id.amount);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
//2 6 3 amt
    public void buyZol(View view){
        txtAccnumber = accnumber.getText().toString();
        txtAmount = amount.getText().toString();
        String ussdCode = "*" + "151" + "*" + "2" + "*" +6+"*"+3+"*"+txtAmount+"*"+txtAccnumber+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(PayZol.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

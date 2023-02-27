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

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.make_payment.regularpayments.RegularPayments;

public class Make_Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make__payment);
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
    public void addBiller(View view){
        Intent intent = new Intent(Make_Payment.this,Add_Biller.class);
        startActivity(intent);
    }
    public void payBill(View view){
        Intent intent = new Intent(Make_Payment.this,PayBill.class);
        startActivity(intent);
    }
    public void payMerchant(View view){
        Intent intent = new Intent(Make_Payment.this,PayMerchant.class);
        startActivity(intent);
    }
    public void paySchoolFees(View view){
        Intent intent = new Intent(Make_Payment.this,Pay_School_Fees.class);
        startActivity(intent);
    }
    public void paymentApproval(View view){
        String ussdCode = "*" + "151" +"*"+"2"+"*"+"4"+"*"+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(Make_Payment.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
    public void transferToChurch(View view){
        Intent intent = new Intent(Make_Payment.this,TransferToChurch.class);
        startActivity(intent);
    }
    public void regularPayments(View view){
        Intent intent = new Intent(Make_Payment.this, RegularPayments.class);
        startActivity(intent);
    }
}
package com.example.nyasha.zimmobo.banking_services;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.nyasha.zimmobo.R;

public class BankToWallet extends AppCompatActivity {

    EditText walletamount;
    String txtwalletamount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_to_wallet);
        walletamount = findViewById(R.id.walletamount);
    }
    public void completeTransfer(View view){
        txtwalletamount = walletamount.getText().toString();
        String ussdCode = "*" + "151" + "*" + "8" + "*" +2+ "*" +txtwalletamount+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(BankToWallet.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

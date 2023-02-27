package com.example.nyasha.zimmobo.wallet_services.multicurrency;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.wallet_services.account_enquiry.AccountEnquiry;

public class Multi_Currency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi__currency);
    }

    public void activateOtherCurrency(View view){
        String ussdCode = "*" + "151" + "*" + "7" + "*" + 5 + "*" + 1+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(Multi_Currency.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

    public void changeCurrency(View view){
        Intent intent = new Intent(Multi_Currency.this,ChangeCurrency.class);
        startActivity(intent);
    }
}

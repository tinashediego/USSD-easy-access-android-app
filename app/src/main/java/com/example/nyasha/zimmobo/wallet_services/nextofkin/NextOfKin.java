package com.example.nyasha.zimmobo.wallet_services.nextofkin;

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
import com.example.nyasha.zimmobo.wallet_services.account_enquiry.AccountEnquiry;

public class NextOfKin extends AppCompatActivity {

    EditText fname,surname,msid,id;
    String txtFname,txtSurname,txtMsid,txtId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_of_kin);
        fname = findViewById(R.id.firstName);
        surname = findViewById(R.id.sname);
        msid = findViewById(R.id.msisnd);
        id = findViewById(R.id.id);
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
    public void addNextOfKin(View view){
        txtFname = fname.getText().toString();
        txtSurname = surname.getText().toString();
        txtMsid = msid.getText().toString();
        txtId = id.getText().toString();
        String ussdCode = "*" + "151" + "*" + "7" + "*" + 3+ "*" + 1+"*"+txtFname+"*"+txtSurname+"*"+txtMsid+"*"+txtId+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(NextOfKin.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

package com.example.nyasha.zimmobo.send_money;

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
import android.widget.Toast;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.airtime.Transfer_Airtime;
import com.example.nyasha.zimmobo.call_me_back.Call_Me_Back;

public class Send_Money extends AppCompatActivity {

    int reg = 1;
    EditText number,amount;
    String txtPhoneNumber,txtAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send__money);
        number = (EditText) findViewById(R.id.rcvrNumber);
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
        public void onRadioButtonClicked(View view) {
            // Is the button now checked?
            boolean checked = ((RadioButton) view).isChecked();

            // Check which radio button was clicked
            switch(view.getId()) {
                case R.id.registered:
                    if (checked)
                        reg = 1;
                        break;
                case R.id.unregistered:
                    if (checked)
                        reg = 2;
                        break;
            }
    }
    public void sendMoney(View view){
        txtPhoneNumber = number.getText().toString();
        txtAmount = amount.getText().toString();
        String ussdCode = "*" + "151" +"*"+"1"+"*"+reg+"*"+txtPhoneNumber+"*"+txtAmount+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(Send_Money.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

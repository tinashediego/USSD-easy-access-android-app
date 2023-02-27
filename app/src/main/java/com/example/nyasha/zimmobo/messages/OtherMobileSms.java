package com.example.nyasha.zimmobo.messages;

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
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nyasha.zimmobo.R;

public class OtherMobileSms extends AppCompatActivity {

    TelephonyManager telephonyManager;
    String simOperatorName,txtRcvrNmbr;
    EditText rcvrNmbr;
    int reg = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_mobile_sms);
        telephonyManager = ((TelephonyManager) OtherMobileSms.this.getSystemService(Context.TELEPHONY_SERVICE));
        simOperatorName = telephonyManager.getSimOperatorName();
        rcvrNmbr = (EditText) findViewById(R.id.rcvrNumber);
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
            case R.id.sms5:
                if (checked)
                    reg = 1;
                break;
            case R.id.sms15:
                if (checked)
                    reg = 2;
                break;
            case R.id.sms50:
                if (checked)
                    reg = 3;
                break;
            case R.id.sms130:
                if (checked)
                    reg = 4;
                break;
            case R.id.sms250:
                if (checked)
                    reg = 5;
                break;
            case R.id.sms500:
                if (checked)
                    reg = 6;
                break;
        }
    }
    public void sendMoney(View view){
        txtRcvrNmbr = rcvrNmbr.getText().toString();
        if((simOperatorName).equalsIgnoreCase("Econet")) {
            String ussdCode = "*" + "151" +"*"+"4"+"*"+"2"+"*"+"2"+"*"+txtRcvrNmbr+"*"+reg+ Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(OtherMobileSms.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
        else if(simOperatorName.equalsIgnoreCase("Telecel")){
           /* String ussdCode = "*" + "122" + Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(MyMobileSms.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));*/
            Toast.makeText(this,"Not yet Available for "+simOperatorName,Toast.LENGTH_LONG).show();
        }
        else if((simOperatorName.trim()).equalsIgnoreCase("Netone")){
            /*String ussdCode = "*" + "134" + Uri.encode("#");
            if (ActivityCompat.checkSelfPermission(MyMobileSms.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + ussdCode)));*/
            Toast.makeText(this,"Not yet Available for "+simOperatorName,Toast.LENGTH_LONG).show();
        }

    }
}

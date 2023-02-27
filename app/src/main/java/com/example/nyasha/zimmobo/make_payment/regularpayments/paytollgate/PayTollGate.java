package com.example.nyasha.zimmobo.make_payment.regularpayments.paytollgate;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import com.example.nyasha.zimmobo.R;
import com.example.nyasha.zimmobo.make_payment.PayMerchant;

public class PayTollGate extends AppCompatActivity {

    int reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_toll_gate);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.registerVRN:
                if (checked)
                    reg = 1;
                break;
            case R.id.de_registerVRN:
                if (checked)
                    reg = 2;
                break;
            case R.id.loadTollGateAcc:
                if (checked)
                    reg = 3;
                break;
            case R.id.balEnquiry:
                if (checked)
                    reg = 4;
                break;
            case R.id.miniStatement:
                if (checked)
                    reg = 5;
                break;
        }
    }
    public void clickTOContinue(View view){
        String ussdCode = "*" + "151" +"*"+"2"+"*"+"6"+"*"+5+"*"+reg+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(PayTollGate.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

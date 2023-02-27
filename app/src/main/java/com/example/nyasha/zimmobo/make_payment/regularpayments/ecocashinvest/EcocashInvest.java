package com.example.nyasha.zimmobo.make_payment.regularpayments.ecocashinvest;

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

public class EcocashInvest extends AppCompatActivity {

    int reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ecocash_invest);
    }
    /////2 6 4 1
    public void clickTOContinue(View view){
        String ussdCode = "*" + "151" +"*"+"2"+"*"+"6"+"*"+4+"*"+1+"*"+reg+ Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(EcocashInvest.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.accCreation:
                if (checked)
                    reg = 1;
                break;
            case R.id.priBuyOrder:
                if (checked)
                    reg = 2;
                break;
            case R.id.secBuyOrder:
                if (checked)
                    reg = 3;
                break;
            case R.id.secSellOrder:
                if (checked)
                    reg = 4;
                break;
        }
    }
}

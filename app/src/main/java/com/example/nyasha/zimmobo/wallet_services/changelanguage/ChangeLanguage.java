package com.example.nyasha.zimmobo.wallet_services.changelanguage;

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
import com.example.nyasha.zimmobo.wallet_services.account_enquiry.AccountEnquiry;

public class ChangeLanguage extends AppCompatActivity {

    int reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_language);
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.Ndebele:
                if (checked)
                    reg = 1;
                break;
            case R.id.English:
                if (checked)
                    reg = 2;
                break;
            case R.id.Shona:
                if (checked)
                    reg = 3;
                break;
        }
    }
    public void changeLanguage(View view){
        String ussdCode = "*" + "151" + "*" + "7" + "*" + 4+ "*" + 1+"*"+reg+Uri.encode("#");
        if (ActivityCompat.checkSelfPermission(ChangeLanguage.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
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

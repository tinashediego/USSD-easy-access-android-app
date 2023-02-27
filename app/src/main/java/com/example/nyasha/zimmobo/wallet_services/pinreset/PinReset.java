package com.example.nyasha.zimmobo.wallet_services.pinreset;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nyasha.zimmobo.R;

public class PinReset extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_reset);
    }
    public void changePin(View view){
        Intent intent = new Intent(PinReset.this,ChangePin.class);
        startActivity(intent);
    }
    public void answerSecurityQuestions(View view){

    }
}

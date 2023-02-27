package com.example.nyasha.zimmobo.messages;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.nyasha.zimmobo.R;

public class Buy_Messages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

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
    public void myMobileSms(View view){
        Intent intent = new Intent(Buy_Messages.this, MyMobileSms.class);
        startActivity(intent);
    }
    public void otherMobileSms(View view){
        Intent intent = new Intent(Buy_Messages.this, OtherMobileSms.class);
        startActivity(intent);
    }
}

package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        handleToast("Carregando, por favor aguarde");


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), InitializeActivity.class);
                startActivity(i);
                finish();
            }
        }, 5000);
    }

    private void handleToast(String message)
        {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
}
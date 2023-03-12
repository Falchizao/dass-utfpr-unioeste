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


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // This method will be executed once the timer is over
                Intent i = new Intent(getApplicationContext(), InitializeActivity.class);
                handleToast("Carregando, por favor aguarde");
                startActivity(i);
                finish();
            }
        }, 1000);
    }

    private void handleToast(String message)
        {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
}
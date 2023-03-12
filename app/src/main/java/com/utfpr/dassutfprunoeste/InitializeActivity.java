package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class InitializeActivity extends AppCompatActivity {
    private static Button inicializar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        findId();
        getData();
    }

    private void findId(){
        inicializar = findViewById(R.id.center_button);
    }

    private void getData(){
        inicializar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FirstColumnQuestionsActivity.class));
            }
        });
    }
}
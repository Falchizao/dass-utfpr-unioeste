package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InitializeActivity extends AppCompatActivity {
    private static Button inicializar;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    EditText email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        findId();
        getData();
    }

    private void findId(){
        inicializar = findViewById(R.id.center_button);
        email = findViewById(R.id.editTextEmail);
    }

    private void getData(){

        sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPref.edit();
        inicializar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String emailTot = email.getText().toString();

                if(emailTot != "") {
                    editor.putString("email", emailTot);
                    editor.commit();
                }


                startActivity(new Intent(getApplicationContext(), FirstColumnQuestionsActivity.class));
            }
        });
    }
}
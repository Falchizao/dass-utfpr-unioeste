package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InitializeActivity extends AppCompatActivity {
    private static Button inicializar;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    EditText cpfet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initialize);
        findId();
        getData();
    }

    private void findId(){
        inicializar = findViewById(R.id.center_button);
        cpfet = findViewById(R.id.editTextEmail);
        cpfet.addTextChangedListener(new CpfMaskTextWatcher());
    }

    private class CpfMaskTextWatcher implements TextWatcher {
        private boolean isUpdating;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (isUpdating) {
                isUpdating = false;
                return;
            }

            String cpf = s.toString().replaceAll("[^\\d]", "");

            if (cpf.length() > 11) {
                cpf = cpf.substring(0, 11);
            }

            StringBuilder formattedCpf = new StringBuilder();
            int groups = cpf.length() / 3;

            for (int i = 0; i < groups; i++) {
                int startIndex = i * 3;
                int endIndex = startIndex + 3;

                formattedCpf.append(cpf, startIndex, endIndex).append(".");
            }

            // Último grupo pode ter apenas 2 caracteres
            formattedCpf.append(cpf.substring(groups * 3));

            isUpdating = true;
            cpfet.setText(formattedCpf.toString());
            cpfet.setSelection(formattedCpf.length());
        }
    }

    private void getData(){

        sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPref.edit();
        inicializar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String cpf = cpfet.getText().toString();

                if(cpf != null && cpf.length() > 13) {
                    editor.putString("cpf", cpf);
                    editor.commit();
                    startActivity(new Intent(getApplicationContext(), VerifyActivity.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), FirstColumnQuestionsActivity.class));
                }

            }
        });
    }
}
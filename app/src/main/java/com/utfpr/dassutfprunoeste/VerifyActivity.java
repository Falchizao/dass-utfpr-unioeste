package com.utfpr.dassutfprunoeste;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;
import java.util.Calendar;

public class VerifyActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;

    TextView datetv;

    private static Button iniciarquest;

    private EditText editTextIncome;
    private Button buttonDatePicker;

    private String dataNasc;

    private Spinner spinnerEducationLevel;
    private String selectedEducationLevel;

    private Spinner spinnerRace;
    private Spinner spinnerGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        sharedPref = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPref.edit();

        datetv = findViewById(R.id.tvDateSelected);

        iniciarquest = findViewById(R.id.iniciarquest);

        spinnerGender = findViewById(R.id.spinnerGender);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.gender_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGender.setAdapter(adapter);
        spinnerGender.setOnItemSelectedListener(this);

        spinnerRace = findViewById(R.id.spinnerRace);
        ArrayAdapter<CharSequence> adapterrace = ArrayAdapter.createFromResource(
                this,
                R.array.race_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRace.setAdapter(adapterrace);
        spinnerRace.setOnItemSelectedListener(this);

        spinnerEducationLevel = findViewById(R.id.spinnerEducationLevel);
        ArrayAdapter<CharSequence> adapteredu = ArrayAdapter.createFromResource(
                this,
                R.array.education_levels,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEducationLevel.setAdapter(adapteredu);
        spinnerEducationLevel.setOnItemSelectedListener(this);

        editTextIncome = findViewById(R.id.editTextIncome);
        editTextIncome.addTextChangedListener(new TextWatcher() {
            private String current = "";

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().equals(current)) {
                    editTextIncome.removeTextChangedListener(this);

                    String cleanString = s.toString().replaceAll("[R$,.\\s]", "");

                    double parsed = Double.parseDouble(cleanString);
                    String formatted = NumberFormat.getCurrencyInstance().format((parsed / 100));

                    current = formatted;
                    editTextIncome.setText(formatted);
                    editTextIncome.setSelection(formatted.length());

                    editTextIncome.addTextChangedListener(this);
                }
            }
        });

        buttonDatePicker = findViewById(R.id.buttonDatePicker);
        buttonDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        iniciarquest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(selectedEducationLevel != null) {
                    editor.putString("educacao", selectedEducationLevel);
                    editor.commit();
                }

                if(spinnerGender.getSelectedItem()  != null) {
                    editor.putString("genero", spinnerGender.getSelectedItem().toString());
                    editor.commit();
                }

                if(spinnerRace.getSelectedItem() != null) {
                    editor.putString("raca", spinnerRace.getSelectedItem().toString());
                    editor.commit();
                }

                if(editTextIncome.getText() != null) {
                    editor.putString("familiar", editTextIncome.getText().toString());
                    editor.commit();
                }

                editTextIncome.setText("0");

                if(dataNasc != null) {
                    editor.putString("datanasc", dataNasc);
                    editor.commit();
                }

                dataNasc = "";

                startActivity(new Intent(getApplicationContext(), FirstColumnQuestionsActivity.class));
            }
        });
    }

    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                VerifyActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        dataNasc = dayOfMonth + "/" + (month + 1) + "/" + year;
                        datetv.setText(dataNasc);
                    }
                },
                year,
                month,
                dayOfMonth
        );

        datePickerDialog.show();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedEducationLevel = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
}
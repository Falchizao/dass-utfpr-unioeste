package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

public class FirstColumnQuestionsActivity extends AppCompatActivity {
    private static Button calculateButton;

    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioGroup radioGroup5;
    RadioGroup radioGroup6;
    RadioGroup radioGroup7;
    RadioGroup radioGroup8;
    RadioGroup radioGroup9;
    RadioGroup radioGroup10;
    RadioGroup radioGroup11;
    RadioGroup radioGroup12;
    RadioGroup radioGroup13;
    RadioGroup radioGroup14;
    RadioGroup radioGroup15;
    RadioGroup radioGroup16;
    RadioGroup radioGroup17;
    RadioGroup radioGroup18;
    RadioGroup radioGroup19;
    RadioGroup radioGroup20;
    RadioGroup radioGroup21;
    RadioButton radioButton1_1;
    RadioButton radioButton2_1;
    RadioButton radioButton3_1;
    RadioButton radioButton4_1;
    RadioButton radioButton5_1;
    RadioButton radioButton6_1;
    RadioButton radioButton7_1;
    RadioButton radioButton8_1;
    RadioButton radioButton9_1;
    RadioButton radioButton10_1;
    RadioButton radioButton11_1;
    RadioButton radioButton12_1;
    RadioButton radioButton13_1;
    RadioButton radioButton14_1;
    RadioButton radioButton15_1;
    RadioButton radioButton16_1;
    RadioButton radioButton17_1;
    RadioButton radioButton18_1;
    RadioButton radioButton19_1;
    RadioButton radioButton20_1;
    RadioButton radioButton21_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_column_questions);
        findId();
        getData();
    }

    private void findId(){
        calculateButton = findViewById(R.id.calculateButton);
        radioGroup1 = findViewById(R.id.radioGroup1_1);
        radioGroup2 = findViewById(R.id.radioGroup1_2);
        radioGroup3 = findViewById(R.id.radioGroup1_3);
        radioGroup4 = findViewById(R.id.radioGroup1_4);
        radioGroup5 = findViewById(R.id.radioGroup1_5);
        radioGroup6 = findViewById(R.id.radioGroup1_6);
        radioGroup7 = findViewById(R.id.radioGroup1_7);
        radioGroup8 = findViewById(R.id.radioGroup1_8);
        radioGroup9 = findViewById(R.id.radioGroup1_9);
        radioGroup10 = findViewById(R.id.radioGroup1_10);
        radioGroup11 = findViewById(R.id.radioGroup1_11);
        radioGroup12 = findViewById(R.id.radioGroup1_12);
        radioGroup13= findViewById(R.id.radioGroup1_13);
        radioGroup14= findViewById(R.id.radioGroup1_14);
        radioGroup15 = findViewById(R.id.radioGroup1_15);
        radioGroup16= findViewById(R.id.radioGroup1_16);
        radioGroup17= findViewById(R.id.radioGroup1_17);
        radioGroup18= findViewById(R.id.radioGroup1_18);
        radioGroup19= findViewById(R.id.radioGroup1_19);
        radioGroup20= findViewById(R.id.radioGroup1_20);
        radioGroup21= findViewById(R.id.radioGroup1_21);
        radioButton1_1= findViewById(R.id.radioButton1_1);
        radioButton2_1= findViewById(R.id.radioButton1_2);
        radioButton3_1= findViewById(R.id.radioButton1_3);
        radioButton4_1= findViewById(R.id.radioButton1_4);
        radioButton5_1= findViewById(R.id.radioButton1_5);
        radioButton6_1= findViewById(R.id.radioButton1_6);
        radioButton7_1= findViewById(R.id.radioButton1_7);
        radioButton8_1= findViewById(R.id.radioButton1_8);
        radioButton9_1= findViewById(R.id.radioButton1_9);
        radioButton10_1 = findViewById(R.id.radioButton1_10);
        radioButton11_1= findViewById(R.id.radioButton1_11);
        radioButton12_1= findViewById(R.id.radioButton1_12);
        radioButton13_1= findViewById(R.id.radioButton1_13);
        radioButton14_1= findViewById(R.id.radioButton1_14);
        radioButton15_1= findViewById(R.id.radioButton1_15);
        radioButton16_1= findViewById(R.id.radioButton1_16);
        radioButton17_1= findViewById(R.id.radioButton1_17);
        radioButton18_1= findViewById(R.id.radioButton1_18);
        radioButton19_1= findViewById(R.id.radioButton1_19);
        radioButton20_1= findViewById(R.id.radioButton1_20);
        radioButton21_1= findViewById(R.id.radioButton1_21);
    }


    private void getData(){
        radioButton1_1.setChecked(true);
        radioButton2_1.setChecked(true);
        radioButton3_1.setChecked(true);
        radioButton4_1.setChecked(true);
        radioButton5_1.setChecked(true);
        radioButton6_1.setChecked(true);
        radioButton7_1.setChecked(true);
        radioButton8_1.setChecked(true);
        radioButton9_1.setChecked(true);
        radioButton10_1.setChecked(true);
        radioButton11_1.setChecked(true);
        radioButton12_1.setChecked(true);
        radioButton13_1.setChecked(true);
        radioButton14_1.setChecked(true);
        radioButton15_1.setChecked(true);
        radioButton16_1.setChecked(true);
        radioButton17_1.setChecked(true);
        radioButton18_1.setChecked(true);
        radioButton19_1.setChecked(true);
        radioButton20_1.setChecked(true);
        radioButton21_1.setChecked(true);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent result = new Intent(getApplicationContext(), ScoreActivity.class);

                RadioButton selectedRadioButton1 = findViewById(radioGroup1.getCheckedRadioButtonId());
                result.putExtra("1_answer", selectedRadioButton1.getText());

                RadioButton selectedRadioButton2 = findViewById(radioGroup2.getCheckedRadioButtonId());
                result.putExtra("2_answer", selectedRadioButton2.getText());

                RadioButton selectedRadioButton3 = findViewById(radioGroup3.getCheckedRadioButtonId());
                result.putExtra("3_answer", selectedRadioButton3.getText());

                RadioButton selectedRadioButton4 = findViewById(radioGroup4.getCheckedRadioButtonId());
                result.putExtra("4_answer", selectedRadioButton4.getText());

                RadioButton selectedRadioButton5 = findViewById(radioGroup5.getCheckedRadioButtonId());
                result.putExtra("5_answer", selectedRadioButton5.getText());

                RadioButton selectedRadioButton6 = findViewById(radioGroup6.getCheckedRadioButtonId());
                result.putExtra("6_answer", selectedRadioButton6.getText());

                RadioButton selectedRadioButton7 = findViewById(radioGroup7.getCheckedRadioButtonId());
                result.putExtra("7_answer", selectedRadioButton7.getText());

                RadioButton selectedRadioButton8 = findViewById(radioGroup8.getCheckedRadioButtonId());
                result.putExtra("8_answer", selectedRadioButton8.getText());

                RadioButton selectedRadioButton9 = findViewById(radioGroup9.getCheckedRadioButtonId());
                result.putExtra("9_answer", selectedRadioButton9.getText());

                RadioButton selectedRadioButton10 = findViewById(radioGroup10.getCheckedRadioButtonId());
                result.putExtra("10_answer", selectedRadioButton10.getText());

                RadioButton selectedRadioButton11 = findViewById(radioGroup11.getCheckedRadioButtonId());
                result.putExtra("11_answer", selectedRadioButton11.getText());

                RadioButton selectedRadioButton12 = findViewById(radioGroup12.getCheckedRadioButtonId());
                result.putExtra("12_answer", selectedRadioButton12.getText());

                RadioButton selectedRadioButton13 = findViewById(radioGroup13.getCheckedRadioButtonId());
                result.putExtra("13_answer", selectedRadioButton13.getText());

                RadioButton selectedRadioButton14 = findViewById(radioGroup14.getCheckedRadioButtonId());
                result.putExtra("14_answer", selectedRadioButton14.getText());

                RadioButton selectedRadioButton15 = findViewById(radioGroup15.getCheckedRadioButtonId());
                result.putExtra("15_answer", selectedRadioButton15.getText());

                RadioButton selectedRadioButton16 = findViewById(radioGroup16.getCheckedRadioButtonId());
                result.putExtra("16_answer", selectedRadioButton16.getText());

                RadioButton selectedRadioButton17 = findViewById(radioGroup17.getCheckedRadioButtonId());
                result.putExtra("17_answer", selectedRadioButton17.getText());

                RadioButton selectedRadioButton18 = findViewById(radioGroup18.getCheckedRadioButtonId());
                result.putExtra("18_answer", selectedRadioButton18.getText());

                RadioButton selectedRadioButton19 = findViewById(radioGroup19.getCheckedRadioButtonId());
                result.putExtra("19_answer", selectedRadioButton19.getText());

                RadioButton selectedRadioButton20 = findViewById(radioGroup20.getCheckedRadioButtonId());
                result.putExtra("20_answer", selectedRadioButton20.getText());

                RadioButton selectedRadioButton21 = findViewById(radioGroup1.getCheckedRadioButtonId());
                result.putExtra("21_answer", selectedRadioButton21.getText());
                startActivity(result);
            }
        });

    }


}
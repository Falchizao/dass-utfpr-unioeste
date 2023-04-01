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
    private static Button nextPage;

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

    }

    private void storeData() {

    }
}
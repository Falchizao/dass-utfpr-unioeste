package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class FourthColumnQuestionsActivity extends AppCompatActivity {
    private static Button nextPage;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Spinner question4_1;
    Spinner question4_2;
    Spinner question4_3;
    Spinner question4_4;
    Spinner question4_5;
    Spinner question4_6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth_column_questions);
        findId();
        getData();
    }

    private void findId(){
        question4_1 = findViewById(R.id.answer1);
        question4_2 = findViewById(R.id.answer2);
        question4_3 = findViewById(R.id.answer3);
        question4_4 = findViewById(R.id.answer4);
        question4_5 = findViewById(R.id.answer5);
        question4_6 = findViewById(R.id.answer6);
        nextPage = findViewById(R.id.calcular_result);
    }

    private void getData(){
        sharedPref = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        editor = sharedPref.edit();
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
                startActivity(new Intent(getApplicationContext(), ScoreActivity.class));
            }
        });
    }

    private void storeData() {
        editor.putInt("4_1", question4_1.getSelectedItemPosition());
        editor.putInt("4_2", question4_2.getSelectedItemPosition());
        editor.putInt("4_3", question4_3.getSelectedItemPosition());
        editor.putInt("4_4", question4_4.getSelectedItemPosition());
        editor.putInt("4_5", question4_5.getSelectedItemPosition());
        editor.putInt("4_6", question4_6.getSelectedItemPosition());
        editor.commit();
    }
}
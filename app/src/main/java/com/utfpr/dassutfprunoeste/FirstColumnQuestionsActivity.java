package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class FirstColumnQuestionsActivity extends AppCompatActivity {
    private static Button nextPage;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Spinner question1_1;
    Spinner question1_2;
    Spinner question1_3;
    Spinner question1_4;
    Spinner question1_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_column_questions);
        findId();
        getData();
    }

    private void findId(){
        question1_1 = findViewById(R.id.answer1);
        question1_2 = findViewById(R.id.answer2);
        question1_3 = findViewById(R.id.answer3);
        question1_4 = findViewById(R.id.answer4);
        question1_5 = findViewById(R.id.answer5);
        nextPage = findViewById(R.id.next_button_firstPage);
    }

    private void getData(){
        sharedPref = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        editor = sharedPref.edit();
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
                startActivity(new Intent(getApplicationContext(), SecondColumnQuestionsActivity.class));
            }
        });
    }

    private void storeData() {
        editor.putInt("1_1", question1_1.getSelectedItemPosition());
        editor.putInt("1_2", question1_2.getSelectedItemPosition());
        editor.putInt("1_3", question1_3.getSelectedItemPosition());
        editor.putInt("1_4", question1_4.getSelectedItemPosition());
        editor.putInt("1_5", question1_5.getSelectedItemPosition());
        editor.commit();
    }
}
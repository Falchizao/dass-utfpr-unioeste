package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class ThirdColumnQuestionsActivity extends AppCompatActivity {
    private static Button nextPage;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Spinner question3_1;
    Spinner question3_2;
    Spinner question3_3;
    Spinner question3_4;
    Spinner question3_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_column_questions);
        findId();
        getData();
    }

    private void findId(){
        question3_1 = findViewById(R.id.answer1);
        question3_2 = findViewById(R.id.answer2);
        question3_3 = findViewById(R.id.answer3);
        question3_4 = findViewById(R.id.answer4);
        question3_5 = findViewById(R.id.answer5);
        nextPage = findViewById(R.id.next_button_thirdPage);
    }

    private void getData(){
        sharedPref = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        editor = sharedPref.edit();
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
                startActivity(new Intent(getApplicationContext(), FourthColumnQuestionsActivity.class));
            }
        });
    }

    private void storeData() {
        editor.putInt("3_1", question3_1.getSelectedItemPosition());
        editor.putInt("3_2", question3_2.getSelectedItemPosition());
        editor.putInt("3_3", question3_3.getSelectedItemPosition());
        editor.putInt("3_4", question3_4.getSelectedItemPosition());
        editor.putInt("3_4", question3_5.getSelectedItemPosition());
        editor.commit();
    }
}
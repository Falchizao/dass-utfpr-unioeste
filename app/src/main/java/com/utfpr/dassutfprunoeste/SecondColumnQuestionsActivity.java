package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class SecondColumnQuestionsActivity extends AppCompatActivity {
    private static Button nextPage;
    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    Spinner question2_1;
    Spinner question2_2;
    Spinner question2_3;
    Spinner question2_4;
    Spinner question2_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_column_questions);
        findId();
        getData();
    }

    private void findId(){
        question2_1 = findViewById(R.id.answer1);
        question2_2 = findViewById(R.id.answer2);
        question2_3 = findViewById(R.id.answer3);
        question2_4 = findViewById(R.id.answer4);
        question2_5 = findViewById(R.id.answer5);
        nextPage = findViewById(R.id.next_button_secondPage);
    }

    private void getData(){
        sharedPref = getSharedPreferences("MySharedPref",MODE_PRIVATE);
        editor = sharedPref.edit();
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storeData();
                startActivity(new Intent(getApplicationContext(), ThirdColumnQuestionsActivity.class));
            }
        });
    }

    private void storeData() {
        editor.putInt("2_1", question2_1.getSelectedItemPosition());
        editor.putInt("2_2", question2_2.getSelectedItemPosition());
        editor.putInt("2_3", question2_3.getSelectedItemPosition());
        editor.putInt("2_4", question2_4.getSelectedItemPosition());
        editor.putInt("2_5", question2_5.getSelectedItemPosition());
        editor.commit();
    }
}
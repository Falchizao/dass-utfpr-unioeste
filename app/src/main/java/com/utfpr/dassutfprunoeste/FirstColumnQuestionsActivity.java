package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstColumnQuestionsActivity extends AppCompatActivity {
    private static Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_column_questions);
        findId();
        getData();
    }

    private void findId(){
        nextPage = findViewById(R.id.next_button_firstPage);
    }

    private void getData(){
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SecondColumnQuestionsActivity.class));
            }
        });
    }
}
package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    private static Button restart;
    TextView lblDepression, lblAnxiety, lblStress;

    SharedPreferences sh;
    Integer counter_firstSection = 0;
    Integer counter_secondSection = 0;
    Integer counter_thirdSection = 0;
    Integer counter_fourthSection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        handleToast("Calculando resultados... por favor aguarde");
        findId();
        getData();
        startCalc();
    }

    private void findId(){
        restart = findViewById(R.id.restartBtn);
    }

    private void getData(){
        sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InitializeActivity.class));

            }
        });
    }

    private void startCalc() {
        calcFirstSection();
        calcSecondSection();
        calcThirdSection();
        calcFourthSection();
    }

    private void calcFirstSection() {
        counter_firstSection += sh.getInt("1_1", 0);
        counter_firstSection += sh.getInt("1_2", 0);
        counter_firstSection += sh.getInt("1_3", 0);
        counter_firstSection += sh.getInt("1_4", 0);
        counter_firstSection += sh.getInt("1_5", 0);
        handleFirstSectionScore(counter_firstSection);
    }

    private void calcSecondSection(){
        counter_secondSection += sh.getInt("2_1", 0);
        counter_secondSection +=  sh.getInt("2_2", 0);
        counter_secondSection +=  sh.getInt("2_3", 0);
        counter_secondSection +=  sh.getInt("2_4", 0);
        counter_secondSection +=  sh.getInt("2_5", 0);
        handleSecondSectionScore(counter_secondSection);
    }

    private void calcThirdSection() {
        counter_thirdSection +=  sh.getInt("3_1", 0);
        counter_thirdSection += sh.getInt("3_2", 0);
        counter_thirdSection += sh.getInt("3_3", 0);
        counter_thirdSection += sh.getInt("3_4", 0);
        counter_thirdSection += sh.getInt("3_5", 0);
        handleThirdSectionScore(counter_thirdSection);
    }

    private void calcFourthSection() {
        counter_fourthSection += sh.getInt("4_1", 0);
        counter_fourthSection += sh.getInt("4_2", 0);
        counter_fourthSection += sh.getInt("4_3", 0);
        counter_fourthSection += sh.getInt("4_4", 0);
        counter_fourthSection += sh.getInt("4_5", 0);
        counter_fourthSection += sh.getInt("4_5", 0);
        handleFourthSectionScore(counter_fourthSection);
    }

    private void handleFirstSectionScore(final Integer result){

    }

    private void handleSecondSectionScore(final Integer result){

    }

    private void handleThirdSectionScore(final Integer result){

    }

    private void handleFourthSectionScore(final Integer result){

    }


    private void handleToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}

package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreActivity extends AppCompatActivity {

    private static Button restart;
    TextView lblDepression, lblAnxiety, lblStress;

    SharedPreferences sh;
    Bundle bundle;
    Integer counter_firstSection = 0;
    Integer counter_secondSection = 0;
    Integer counter_thirdSection = 0;
    Integer counter_fourthSection = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        bundle = getIntent().getExtras();
        handleToast("Calculando resultados... por favor aguarde");
        findId();
        getData();
        startCalc();

    }

    private void findId(){
        lblDepression = findViewById(R.id.resultDepressao);
        lblAnxiety = findViewById(R.id.resultAnsiedade);
        lblStress = findViewById(R.id.resultStress);
        restart = findViewById(R.id.restartBtn);
    }

    private void getData(){
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
        counter_firstSection += Integer.parseInt(bundle.getString("1_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("2_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("3_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("4_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("5_answer"));
        handleFirstSectionScore(counter_firstSection);
    }

    private void calcSecondSection(){
        counter_secondSection += Integer.parseInt(bundle.getString("6_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("7_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("8_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("9_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("10_answer"));
        handleSecondSectionScore(counter_secondSection);
    }

    private void calcThirdSection() {
        counter_thirdSection +=  Integer.parseInt(bundle.getString("11_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("12_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("13_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("14_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("15_answer"));
        handleThirdSectionScore(counter_thirdSection);
    }

    private void calcFourthSection() {
        counter_fourthSection += Integer.parseInt(bundle.getString("16_answer"));
        counter_fourthSection += Integer.parseInt(bundle.getString("17_answer"));
        counter_fourthSection += Integer.parseInt(bundle.getString("18_answer"));
        counter_fourthSection += Integer.parseInt(bundle.getString("19_answer"));
        counter_fourthSection += Integer.parseInt(bundle.getString("20_answer"));
        counter_fourthSection += Integer.parseInt(bundle.getString("21_answer"));
        handleFourthSectionScore(counter_fourthSection);
    }

    private void handleFirstSectionScore(Integer result){
        result *= 2;
        if(result == 0){
            lblDepression.setText(SeveridadeEnum.ZERO.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else if(result > 0 && result <= 9 ) {
            lblDepression.setText(SeveridadeEnum.LEVE.getContent());
            lblDepression.setTextColor(Color.parseColor("#87CEFA"));
        } else if (result >= 10 && result <= 13) {
            lblDepression.setText(SeveridadeEnum.MINIMO.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFFF99"));
        }else if (result >= 14 && result <= 20) {
            lblDepression.setText(SeveridadeEnum.MODERADO.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFFF00"));
        }else if (result >= 21 && result <= 27) {
            lblDepression.setText(SeveridadeEnum.GRAVE.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFA07A"));
        }else if (result > 27) {
            lblDepression.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblDepression.setTextColor(Color.parseColor("#B22222"));
        }
    }

    private void handleSecondSectionScore(Integer result){
        result *= 2;
        if(result == 0){
            lblAnxiety.setText(SeveridadeEnum.ZERO.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFFFFF"));
        } else if(result > 0 && result <= 7 ) {
            lblAnxiety.setText(SeveridadeEnum.LEVE.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#87CEFA"));
        } else if (result >= 8 && result <= 9) {
            lblAnxiety.setText(SeveridadeEnum.MINIMO.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFFF99"));
        }else if (result >= 10 && result <= 14) {
            lblAnxiety.setText(SeveridadeEnum.MODERADO.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFFF00"));
        }else if (result >= 15 && result <= 19) {
            lblAnxiety.setText(SeveridadeEnum.GRAVE.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFA07A"));
        }else if (result > 20) {
            lblAnxiety.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#B22222"));
        }
    }

    private void handleThirdSectionScore(Integer result){
        result *= 2;
        if(result == 0){
            lblStress.setText(SeveridadeEnum.ZERO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFFFF"));
        } else if(result > 0 && result <= 14 ) {
            lblStress.setText(SeveridadeEnum.LEVE.getContent());
            lblStress.setTextColor(Color.parseColor("#87CEFA"));
        } else if (result >= 15 && result <= 18) {
            lblStress.setText(SeveridadeEnum.MINIMO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFF99"));
        }else if (result >= 19 && result <= 25) {
            lblStress.setText(SeveridadeEnum.MODERADO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFF00"));
        }else if (result >= 26 && result <= 33) {
            lblStress.setText(SeveridadeEnum.GRAVE.getContent());
            lblStress.setTextColor(Color.parseColor("#FFA07A"));
        }else if (result > 34) {
            lblStress.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblStress.setTextColor(Color.parseColor("#B22222"));
        }
    }

    private void handleFourthSectionScore(Integer result){
        result *= 2;
        if(result == 0){
            lblStress.setText(SeveridadeEnum.ZERO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFFFF"));
        } else if(result > 0 && result <= 9 ) {
            lblStress.setText(SeveridadeEnum.LEVE.getContent());
            lblStress.setTextColor(Color.parseColor("#87CEFA"));
        } else if (result >= 10 && result <= 13) {
            lblStress.setText(SeveridadeEnum.MINIMO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFF99"));
        }else if (result >= 14 && result <= 20) {
            lblStress.setText(SeveridadeEnum.MODERADO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFF00"));
        }else if (result >= 21 && result <= 27) {
            lblStress.setText(SeveridadeEnum.GRAVE.getContent());
            lblStress.setTextColor(Color.parseColor("#FFA07A"));
        }else if (result > 27) {
            lblStress.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblStress.setTextColor(Color.parseColor("#B22222"));
        }
    }

    private void handleToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}

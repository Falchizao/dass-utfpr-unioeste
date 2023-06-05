package com.utfpr.dassutfprunoeste;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class ScoreActivity extends AppCompatActivity {

    private static Button restart;
    TextView lblDepression, lblAnxiety, lblStress;

    SharedPreferences sh;
    Bundle bundle;
    Integer counter_firstSection = 0;
    Integer counter_secondSection = 0;
    Integer counter_thirdSection = 0;


    String resultDepression = "";

    String resultAnxiety = "";

    String resultStress = "";

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
        sh = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InitializeActivity.class));

            }
        });
    }

    private void startCalc() {
        calcDepressao();
        calcAnsiedade();
        calcEstresse();

    }

    public void sendEmail(String email){

        try {
            String stringSenderEmail = "oficinautfpr@gmail.com";
            String stringReceiverEmail = email;
            String stringPasswordSenderEmail = "jqmfprvfiojrsuox";

            String stringHost = "smtp.gmail.com";

            Properties properties = System.getProperties();

            properties.put("mail.smtp.host", stringHost);
            properties.put("mail.smtp.port", "465");
            properties.put("mail.smtp.ssl.enable", "true");
            properties.put("mail.smtp.auth", "true");

            javax.mail.Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(stringSenderEmail, stringPasswordSenderEmail);
                }
            });

            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(stringReceiverEmail));

            mimeMessage.setSubject("Pesquisa DASS UTFPR x UNOESTE.");
            mimeMessage.setText("Olá, \n\nVocê utilizou o sistema de pesquisa DASS, desenvolvido pela UTFPR x UNOESTE.. \n\nO resultado para o seu teste é: \nDepressao: "  + resultDepression + "\nAnsiedade: " +  resultAnxiety + "\nEstresse: "  +resultStress);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Transport.send(mimeMessage);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private void calcDepressao() {
        counter_firstSection += Integer.parseInt(bundle.getString("16_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("17_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("10_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("13_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("21_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("3_answer"));
        counter_firstSection += Integer.parseInt(bundle.getString("5_answer"));
        handleDepression(counter_firstSection);
    }

    private void calcEstresse(){
        counter_secondSection += Integer.parseInt(bundle.getString("18_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("6_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("8_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("12_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("11_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("1_answer"));
        counter_secondSection +=  Integer.parseInt(bundle.getString("14_answer"));
        handleEstresse(counter_secondSection);
    }

    private void calcAnsiedade() {
        counter_thirdSection +=  Integer.parseInt(bundle.getString("20_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("9_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("19_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("2_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("15_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("7_answer"));
        counter_thirdSection += Integer.parseInt(bundle.getString("4_answer"));
        handleAnsiedade(counter_thirdSection);
    }


    private void handleDepression(Integer result){
        result *= 2;
        if(result <= 9 ) {
            lblDepression.setText(SeveridadeEnum.LEVE.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFFFFF"));
            resultDepression = SeveridadeEnum.LEVE.getContent();
        } else if (result >= 10 && result <= 13) {
            lblDepression.setText(SeveridadeEnum.MINIMO.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFFF99"));
            resultDepression =SeveridadeEnum.MINIMO.getContent();
        }else if (result >= 14 && result <= 20) {
            lblDepression.setText(SeveridadeEnum.MODERADO.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFFF00"));
            resultDepression =SeveridadeEnum.MODERADO.getContent();
        }else if (result >= 21 && result <= 27) {
            lblDepression.setText(SeveridadeEnum.GRAVE.getContent());
            lblDepression.setTextColor(Color.parseColor("#FFA07A"));
            resultDepression =SeveridadeEnum.GRAVE.getContent();
        }else if (result > 27) {
            lblDepression.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblDepression.setTextColor(Color.parseColor("#B22222"));
            resultDepression = SeveridadeEnum.MUITOGRAVE.getContent();
        }
    }

    private void handleAnsiedade(Integer result){
        result *= 2;
        if(result <= 7 ) {
            lblAnxiety.setText(SeveridadeEnum.LEVE.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFFFFF"));
            resultAnxiety = SeveridadeEnum.LEVE.getContent();
        } else if (result >= 8 && result <= 9) {
            lblAnxiety.setText(SeveridadeEnum.MINIMO.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFFF99"));
            resultAnxiety = SeveridadeEnum.MINIMO.getContent();
        }else if (result >= 10 && result <= 14) {
            lblAnxiety.setText(SeveridadeEnum.MODERADO.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFFF00"));
            resultAnxiety = SeveridadeEnum.MODERADO.getContent();
        }else if (result >= 15 && result <= 19) {
            lblAnxiety.setText(SeveridadeEnum.GRAVE.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#FFA07A"));
            resultAnxiety = SeveridadeEnum.GRAVE.getContent();
        }else if (result > 19) {
            lblAnxiety.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblAnxiety.setTextColor(Color.parseColor("#B22222"));
            resultAnxiety = SeveridadeEnum.MUITOGRAVE.getContent();
        }
    }

    private void handleEstresse(Integer result){
        result *= 2;
        if(result <= 14 ) {
            lblStress.setText(SeveridadeEnum.LEVE.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFFFF"));
            resultStress = SeveridadeEnum.LEVE.getContent();
        } else if (result >= 15 && result <= 18) {
            lblStress.setText(SeveridadeEnum.MINIMO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFF99"));
            String resultStress =SeveridadeEnum.MINIMO.getContent();
        }else if (result >= 19 && result <= 25) {
            lblStress.setText(SeveridadeEnum.MODERADO.getContent());
            lblStress.setTextColor(Color.parseColor("#FFFF00"));
            resultStress = SeveridadeEnum.MODERADO.getContent();
        }else if (result >= 26 && result <= 33) {
            lblStress.setText(SeveridadeEnum.GRAVE.getContent());
            lblStress.setTextColor(Color.parseColor("#FFA07A"));
            resultStress = SeveridadeEnum.GRAVE.getContent();
        }else if (result > 33) {
            lblStress.setText(SeveridadeEnum.MUITOGRAVE.getContent());
            lblStress.setTextColor(Color.parseColor("#B22222"));
            resultStress = SeveridadeEnum.MUITOGRAVE.getContent();
        }

        String storedEmail = sh.getString("email", null);
        if (storedEmail != null && storedEmail != "") {
            sendEmail(storedEmail);
        }
    }

    private void handleToast(String message) {
        Toast.makeText(this,message, Toast.LENGTH_LONG).show();
    }
}

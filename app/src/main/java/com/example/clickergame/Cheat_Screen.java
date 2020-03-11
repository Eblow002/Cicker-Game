package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static com.example.clickergame.MainActivity.cash;
import static com.example.clickergame.MainActivity.autoPay;
import static com.example.clickergame.MainActivity.x;
import static com.example.clickergame.MainActivity.prestige;
import static com.example.clickergame.MainActivity.decimil;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class Cheat_Screen extends AppCompatActivity {

    private Button BtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat__screen);
        mhandler.postDelayed(autopayout, 100);
        displayAuto(autoPay);

        BtnMove = findViewById(R.id.back);


        BtnMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                back();
            }
        });

    }


    private void back(){
        Intent intent = new Intent(Cheat_Screen.this, MainActivity.class);
        startActivity(intent);
    }

    public void displaymoney(double money) {
        decimil = 0;
        while (money >= 1000 && decimil <= 26) {
            money = money / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.money);
        scoreView.setText(String.valueOf("$" + (float) Math.round(money * 100) / 100 + roundMeArr[decimil]));
        if (decimil > 26){
            scoreView.setText(String.valueOf("$∞"));
        }
    }

    public void displayAuto(double money) {
        money = (money * 10);
        decimil = 0;
        while (money >= 1000 && decimil <= 26) {
            money = money / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.autoDisplay);
        scoreView.setText(String.valueOf("$" + (float) Math.round(money * 100) / 100 + "" + roundMeArr[decimil] + "/sec"));
        if (decimil > 26){
            scoreView.setText(String.valueOf("$∞"));
        }
    }

    public void updateButton(double money) {
        decimil = 0;
        while (money >= 1000 && decimil <= 26) {
            money = money / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.mainbutton);
        scoreView.setText(String.valueOf("$" + (float) Math.round(money * 100) / 100 + roundMeArr[decimil]));
        if (decimil > 26){
            scoreView.setText(String.valueOf("$∞"));
        }
    }

    private Handler mhandler = new Handler();

    public Runnable autopayout = new Runnable() {
        @Override
        public void run() {
            //every .1 seconds this will run
            cash = cash + (autoPay * prestige);
            displaymoney(cash);

            mhandler.postDelayed(this, 100);
        }


    };


    public void Comfirm_Cash(View v){
        double input = 0;
        EditText inputText = (EditText)findViewById(R.id.cash);
        input = Double.parseDouble(inputText.getText().toString());
        cash = input;
    }

    public void Comfirm_Auto(View v){
        double input = 0;
        EditText inputText = (EditText)findViewById(R.id.Auto);
        input = Double.parseDouble(inputText.getText().toString());
        input = input/10;
        autoPay = input;
        displayAuto(autoPay);
    }

    public void click(View v) {
        cash = cash + (x * prestige);

        int firstDigit = (int) pow(10, (int) log(cash));
        displaymoney(cash);


    }

    public void Comfirm_Click(View v){
        double input = 0;
        EditText inputText = (EditText)findViewById(R.id.Click);
        input = Double.parseDouble(inputText.getText().toString());
        x = input;
        updateButton(x);
    }



    String[] roundMeArr = new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};















}

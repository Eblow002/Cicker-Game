package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//vv this is how to use variables here vv
import static com.example.clickergame.MainActivity.cash;
import static com.example.clickergame.MainActivity.autoPay;
import static com.example.clickergame.MainActivity.autoMult;
import static com.example.clickergame.MainActivity.autoPrice;
import static com.example.clickergame.MainActivity.autoPriceLevel;
import static com.example.clickergame.MainActivity.decimil;

//^^ this is how to use variables here ^^

public class Auto_Click_Upgrade extends AppCompatActivity {

    private Button BtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto__click__upgrade);
        mhandler.postDelayed(autopayout, 100);
        displayAutoUpgrade(autoPrice);
        displayAutoUpgradeText(autoPriceLevel);
        displaymoney(cash);



        BtnMove = findViewById(R.id.back);

        BtnMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                back();
            }
        });
    }

    private void back(){
        Intent intent = new Intent(Auto_Click_Upgrade.this, MainActivity.class);
        startActivity(intent);
    }



    String[] roundMeArr = new String[]{"", "K", "M", "B", "T", "q", "Q", "s", "S", "O", "N", "D"};

    public void displaymoney(double money) {
        decimil = 0;
        while(money >= 1000) {
            money = money/1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.money);
        scoreView.setText(String.valueOf("$" + (float)Math.round(money * 100) / 100 + roundMeArr[decimil]));
    }

    public void displayAutoUpgradeText(int level) {
        decimil = 0;
        while(level >= 1000) {
            level = level/1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.autoUpgradeText);
        scoreView.setText(String.valueOf(" Upgrade Auto Clicker: LEVEL " + level + roundMeArr[decimil]));
    }

    public void displayAutoUpgrade(double price) {
        decimil = 0;
        while(price >= 1000) {
            price = price/1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.autoUpgrade);
        scoreView.setText(String.valueOf("$" + (float)Math.round(price * 100) / 100 + roundMeArr[decimil]));
    }

















    private Handler mhandler = new Handler();

    private Runnable autopayout = new Runnable() {
        @Override
        public void run() {
            //every .1 seconds this will run and add auto pay to cash
            cash = cash + autoPay;
            displaymoney(cash);
            mhandler.postDelayed(this, 100);
        }
    };

    public void autoUpgrade(View v){
        if (cash >= autoPrice){
            cash = cash - autoPrice;
            autoPay = (autoPay + autoMult);
            autoMult = autoMult * 1.074;
            autoPrice = autoPrice * 1.1;
            autoPriceLevel = autoPriceLevel + 1;
            if (autoPriceLevel == 10 || autoPriceLevel == 20 || autoPriceLevel == 50 || autoPriceLevel == 100){
                autoMult = autoMult * 2;
            }
        }
        displayAutoUpgrade(autoPrice);
        displayAutoUpgradeText(autoPriceLevel);
        displaymoney(cash);
    }













}

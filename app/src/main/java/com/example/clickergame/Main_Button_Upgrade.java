package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

//vv this is how to use variables here vv
import static com.example.clickergame.MainActivity.cash;
import static com.example.clickergame.MainActivity.autoPay;
import static com.example.clickergame.MainActivity.x;
import static com.example.clickergame.MainActivity.xMult;
import static com.example.clickergame.MainActivity.clickPrice;
import static com.example.clickergame.MainActivity.clickPriceLevel;
import static com.example.clickergame.MainActivity.decimil;







//^^ this is how to use variables here ^^

public class Main_Button_Upgrade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__button__upgrade);
        mhandler.postDelayed(autopayout, 100);

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

    public void displayClickUpgrade(double price) {
        decimil = 0;
        while(price >= 1000) {
            price = price/1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.clickUpgrade);
        scoreView.setText(String.valueOf("$" + (float)Math.round(price * 100) / 100 + roundMeArr[decimil]));
    }

    public void displayClickUpgradeText(int level) {
        decimil = 0;
        while(level >= 1000) {
            level = level/1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.clickUpgradeText);
        scoreView.setText(String.valueOf(" Upgrade Main Button: LEVEL " + level + roundMeArr[decimil]));
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

    public void clickUpgrade(View v){
        if (cash >= clickPrice){
            cash = cash - clickPrice;
            x = (x + xMult);
            xMult = xMult * 1.075;
            clickPrice = clickPrice * 1.1;
            clickPriceLevel = clickPriceLevel + 1;
        }
        displayClickUpgrade(clickPrice);
        displayClickUpgradeText(clickPriceLevel);
        displaymoney(cash);


    }













}

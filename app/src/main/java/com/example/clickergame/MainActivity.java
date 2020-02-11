package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhandler.postDelayed(autopayout, 100);
    }


    double cash = 0;

    double x = 1;
    double xMult= 1;
    double clickPrice = 5;
    int clickPriceLevel = 1;

    double autoPrice = 50;
    double autoPay = 0;
    double autoMult = 0.1;
    int autoPriceLevel = 0;

    public void updateButton(double money) {
        TextView scoreView = (TextView) findViewById(R.id.mainbutton);
        scoreView.setText(String.valueOf("$" + (float)Math.round(money * 100) / 100));
    }


    public void displaymoney(double money) {
        TextView scoreView = (TextView) findViewById(R.id.money);
        scoreView.setText(String.valueOf("$" + (float)Math.round(money * 100) / 100));
    }

    public void displayClickUpgrade(double price) {
        TextView scoreView = (TextView) findViewById(R.id.clickUpgrade);
        scoreView.setText(String.valueOf("$" + (float)Math.round(price * 100) / 100));
    }

    public void displayClickUpgradeText(int level) {
        TextView scoreView = (TextView) findViewById(R.id.clickUpgradeText);
        scoreView.setText(String.valueOf(" Upgrade Main Button: LEVEL " + level));
    }

    public void displayAutoUpgradeText(int level) {
        TextView scoreView = (TextView) findViewById(R.id.autoUpgradeText);
        scoreView.setText(String.valueOf(" Upgrade Auto Clicker: LEVEL " + level));
    }

    public void displayAutoUpgrade(double price) {
        TextView scoreView = (TextView) findViewById(R.id.autoUpgrade);
        scoreView.setText(String.valueOf("$" + (float)Math.round(price * 100) / 100));
    }

    public void displayAuto(double money) {
        TextView scoreView = (TextView) findViewById(R.id.autoDisplay);
        money = money * 10;
        scoreView.setText(String.valueOf("$" + (float)Math.round(money * 100) / 100 + "/sec"));
    }


    public void click(View v){
        cash = (cash + x);


        displaymoney(cash);


    }

    public void clickUpgrade(View v){
        if (cash >= clickPrice){
            cash = cash - clickPrice;
            x = (x + xMult);
            xMult = xMult * 1.02;
            clickPrice = clickPrice * 1.1;
            clickPriceLevel = clickPriceLevel + 1;
        }
        displayClickUpgrade(clickPrice);
        displayClickUpgradeText(clickPriceLevel);
        displaymoney(cash);
        updateButton(x);
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
            autoMult = autoMult * 1.05;
            autoPrice = autoPrice * 1.1;
            autoPriceLevel = autoPriceLevel + 1;
        }
        displayAutoUpgrade(autoPrice);
        displayAutoUpgradeText(autoPriceLevel);
        displaymoney(cash);
        displayAuto(autoPay);
    }

































}

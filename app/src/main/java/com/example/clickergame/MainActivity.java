package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Handler;

import static java.lang.Math.log;
import static java.lang.Math.pow;

public class MainActivity extends AppCompatActivity {

    //for new page
    private Button MainButtonUpgrade;
    private Button AutoClickUpgrade;
    private Button DevOptionsReal;
    private Button Prestige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhandler.postDelayed(autopayout, 100);
        updateButton(x);
        displaymoney(cash);
        displayAuto(autoPay);

        //form here
        MainButtonUpgrade = findViewById(R.id.UpgradeMainButton);
        AutoClickUpgrade = findViewById(R.id.UpgradeAutoClick);
        DevOptionsReal = findViewById(R.id.DevOptionsReal);
        Prestige = findViewById(R.id.Prestige);

        MainButtonUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToMainButtonUpgrade();
            }
        });

        AutoClickUpgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAutoClickUpgrade();
            }
        });

        DevOptionsReal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDevOptionsReal();
            }
        });

        Prestige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToPrestige();
            }
        });


    }

    private void moveToMainButtonUpgrade() {
        Intent intent = new Intent(MainActivity.this, Main_Button_Upgrade.class);
        startActivity(intent);
    }

    private void moveToAutoClickUpgrade() {
        Intent intent = new Intent(MainActivity.this, Auto_Click_Upgrade.class);
        startActivity(intent);
    }

    private void moveToDevOptionsReal() {
        Intent intent = new Intent(MainActivity.this, Dev_Options_Real.class);
        startActivity(intent);
    }

    private void moveToPrestige() {
        Intent intent = new Intent(MainActivity.this, Prestige.class);
        startActivity(intent);
    }
    //to here is also for new page


    public static double cash = 0;
    public static int decimil = 0;
    public static double prestige = 1;

    public static double x = 1;
    public static double xMult = 1;
    public static double clickPrice = 5;
    public static int clickPriceLevel = 1;

    public static double autoPrice = 50;
    public static double autoPay = 0;
    public static double autoMult = 0.1;
    public static int autoPriceLevel = 0;




    String[] roundMeArr = new String[]{"", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

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


    public void click(View v) {
        cash = cash + (x * prestige);

        int firstDigit = (int) pow(10, (int) log(cash));
        displaymoney(cash);


    }





    private Handler mhandler = new Handler();

    public Runnable autopayout = new Runnable() {
        @Override
        public void run() {
            updateButton(x);
            //every .1 seconds this will run
            cash = cash + (autoPay * prestige);
            displaymoney(cash);

            mhandler.postDelayed(this, 100);
        }


    };









}

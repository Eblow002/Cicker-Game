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
    private Button DevOptions;

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
        DevOptions = findViewById(R.id.DevOptions);


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

        DevOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToDevOptions();
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

    private void moveToDevOptions() {
        Intent intent = new Intent(MainActivity.this, Dev_Options.class);
        startActivity(intent);
    }
    //to here is also for new page


    public static double cash = 950000;
    public static int decimil = 0;

    public static double x = 1;
    public static double xMult = 1;
    public static double clickPrice = 5;
    public static int clickPriceLevel = 1;

    public static double autoPrice = 50;
    public static double autoPay = 0;
    public static double autoMult = 0.1;
    public static int autoPriceLevel = 0;



    String[] roundMeArr = new String[]{"", "K", "M", "B", "T", "q", "Q", "s", "S", "O", "N", "D"};

    public void updateButton(double money) {
        decimil = 0;
        while (money >= 1000) {
            money = money / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.mainbutton);
        scoreView.setText(String.valueOf("$" + (float) Math.round(money * 100) / 100 + roundMeArr[decimil]));
    }

    public void displaymoney(double money) {
        decimil = 0;
        while (money >= 1000) {
            money = money / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.money);
        scoreView.setText(String.valueOf("$" + (float) Math.round(money * 100) / 100 + roundMeArr[decimil]));
    }

    public void displayAuto(double money) {
        money = money * 10;
        decimil = 0;
        while (money >= 1000) {
            money = money / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.autoDisplay);
        scoreView.setText(String.valueOf("$" + (float) Math.round(money * 100) / 100 + "" + roundMeArr[decimil] + "/sec"));
    }


    public void click(View v) {
        cash = (cash + x);

        int firstDigit = (int) pow(10, (int) log(cash));
        displaymoney(cash);


    }





    private Handler mhandler = new Handler();

    public Runnable autopayout = new Runnable() {
        @Override
        public void run() {
            updateButton(x);
            //every .1 seconds this will run
            cash = cash + autoPay;
            displaymoney(cash);

            mhandler.postDelayed(this, 100);
        }


    };





}

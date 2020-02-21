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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mhandler.postDelayed(autopayout, 100);
        displayClickUpgrade(clickPrice);
        displayClickUpgradeText(clickPriceLevel);
        updateButton(x);
        displayAutoUpgrade(autoPrice);
        displayAutoUpgradeText(autoPriceLevel);
        displaymoney(cash);
        displayAuto(autoPay);

        //form here
        MainButtonUpgrade = findViewById(R.id.UpgradeMainButton);
        AutoClickUpgrade = findViewById(R.id.UpgradeAutoClick);

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

    }

    private void moveToMainButtonUpgrade() {
        Intent intent = new Intent(MainActivity.this, Main_Button_Upgrade.class);
        startActivity(intent);
    }

    private void moveToAutoClickUpgrade() {
        Intent intent = new Intent(MainActivity.this, Auto_Click_Upgrade.class);
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

    public void displayClickUpgrade(double price) {
        decimil = 0;
        while (price >= 1000) {
            price = price / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.clickUpgrade);
        scoreView.setText(String.valueOf("$" + (float) Math.round(price * 100) / 100 + roundMeArr[decimil]));
    }

    public void displayClickUpgradeText(int level) {
        decimil = 0;
        while (level >= 1000) {
            level = level / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.clickUpgradeText);
        scoreView.setText(String.valueOf(" Upgrade Main Button: LEVEL " + level + roundMeArr[decimil]));
    }

    public void displayAutoUpgradeText(int level) {
        decimil = 0;
        while (level >= 1000) {
            level = level / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.autoUpgradeText);
        scoreView.setText(String.valueOf(" Upgrade Auto Clicker: LEVEL " + level + roundMeArr[decimil]));
    }

    public void displayAutoUpgrade(double price) {
        decimil = 0;
        while (price >= 1000) {
            price = price / 1000;
            decimil = decimil + 1;
        }
        TextView scoreView = (TextView) findViewById(R.id.autoUpgrade);
        scoreView.setText(String.valueOf("$" + (float) Math.round(price * 100) / 100 + roundMeArr[decimil]));
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


    public void clickUpgrade(View v) {
        if (cash >= clickPrice) {
            cash = cash - clickPrice;
            x = (x + xMult);
            xMult = xMult * 1.075;
            clickPrice = clickPrice * 1.1;
            clickPriceLevel = clickPriceLevel + 1;
        }
        displayClickUpgrade(clickPrice);
        displayClickUpgradeText(clickPriceLevel);
        displaymoney(cash);
        updateButton(x);

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


    public void autoUpgrade(View v) {
        if (cash >= autoPrice) {
            cash = cash - autoPrice;
            autoPay = (autoPay + autoMult);
            autoMult = autoMult * 1.074;
            autoPrice = autoPrice * 1.1;
            autoPriceLevel = autoPriceLevel + 1;
            if (autoPriceLevel == 10 || autoPriceLevel == 20 || autoPriceLevel == 50 || autoPriceLevel == 100) {
                autoMult = autoMult * 2;
            }
        }
        displayAutoUpgrade(autoPrice);
        displayAutoUpgradeText(autoPriceLevel);
        displaymoney(cash);
        displayAuto(autoPay);
    }


}

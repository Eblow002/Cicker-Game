package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.clickergame.MainActivity.clickPriceLevel;
import static com.example.clickergame.MainActivity.autoPriceLevel;
import static com.example.clickergame.MainActivity.prestige;
import static com.example.clickergame.MainActivity.cash;
import static com.example.clickergame.MainActivity.decimil;
import static com.example.clickergame.MainActivity.x;
import static com.example.clickergame.MainActivity.xMult;
import static com.example.clickergame.MainActivity.clickPrice;
import static com.example.clickergame.MainActivity.autoPrice;
import static com.example.clickergame.MainActivity.autoPay;
import static com.example.clickergame.MainActivity.autoMult;




public class Prestige extends AppCompatActivity {

    private Button BtnMove;
    private Button Prestige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestige);

        BtnMove = findViewById(R.id.back);
        Prestige = findViewById(R.id.Prestige);



        TextView scoreView = (TextView) findViewById(R.id.prestigeLevel);
        scoreView.setText(String.valueOf("Prestige Multiplier: " + prestige + "X"));


        BtnMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                back();
            }
        });

        Prestige.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Prestige();
            }
        });
    }

    private void back(){
        Intent intent = new Intent(Prestige.this, MainActivity.class);
        startActivity(intent);
    }

    public void displayPrestigeLevel(double money) {
        decimil = 0;
        TextView scoreView = (TextView) findViewById(R.id.prestigeLevel);
        scoreView.setText(String.valueOf("Prestige Multiplier: " + prestige + "X"));
    }
    public void displayPrestigeAddition(double money) {
        decimil = 0;
        TextView scoreView = (TextView) findViewById(R.id.prestigeAddition);
        scoreView.setText(String.valueOf("Prestige To Gain:  " + (prestige - ((clickPriceLevel + autoPriceLevel) / 10)) + "X"));
    }




    private void Prestige(){
        prestige = ((clickPriceLevel + autoPriceLevel) / 100) + prestige;
        //set all vars to reset then make prestige  multiply
        cash = 0;
        decimil = 0;
        x = 1;
        xMult = 1;
        clickPrice = 5;
        clickPriceLevel = 1;
        autoPrice = 50;
        autoPay = 0;
        autoMult = 0.1;
        autoPriceLevel = 0;

        Intent intent = new Intent(Prestige.this, MainActivity.class);
        startActivity(intent);
    }













}

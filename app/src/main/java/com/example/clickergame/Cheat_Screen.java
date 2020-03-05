package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.clickergame.MainActivity.cash;
import static com.example.clickergame.MainActivity.autoPay;
import static com.example.clickergame.MainActivity.x;
import static com.example.clickergame.MainActivity.xMult;
import static com.example.clickergame.MainActivity.clickPrice;
import static com.example.clickergame.MainActivity.clickPriceLevel;
import static com.example.clickergame.MainActivity.decimil;

public class Cheat_Screen extends AppCompatActivity {

    private Button BtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat__screen);

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
    }

    public void Comfirm_Click(View v){
        double input = 0;
        EditText inputText = (EditText)findViewById(R.id.Click);
        input = Double.parseDouble(inputText.getText().toString());
        x = input;
    }


















}

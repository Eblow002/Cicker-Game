package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import static com.example.clickergame.MainActivity.clickPriceLevel;
import static com.example.clickergame.MainActivity.autoPriceLevel;

public class Prestige extends AppCompatActivity {

    private Button BtnMove;
    private Button Prestige;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prestige);

        BtnMove = findViewById(R.id.back);
        BtnMove = findViewById(R.id.Prestige);


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

    public static double prestige = 0;

    private void back(){
        Intent intent = new Intent(Prestige.this, MainActivity.class);
        startActivity(intent);
    }

    private void Prestige(){
        prestige = ((clickPriceLevel + autoPriceLevel) / 10) + prestige;
        //set all vars to reset then make prestige  multiply

        Intent intent = new Intent(Prestige.this, MainActivity.class);
        startActivity(intent);
    }













}

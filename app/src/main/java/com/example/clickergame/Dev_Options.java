package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static com.example.clickergame.MainActivity.cash;


public class Dev_Options extends AppCompatActivity {

    private Button BtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev__options);

        BtnMove = findViewById(R.id.back);


        BtnMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                back();
            }
        });

    }

    private void back(){
        Intent intent = new Intent(Dev_Options.this, MainActivity.class);
        startActivity(intent);
    }

    String devCode = "12345";
    EditText et = (EditText) findViewById(R.id.DevCode);
    String DevCode= et.getEditableText().toString();

    public void submit(View V){
        if (DevCode == devCode){
            back();
        }
    }

//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^




}

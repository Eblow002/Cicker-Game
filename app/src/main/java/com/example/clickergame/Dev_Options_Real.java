package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Dev_Options_Real extends AppCompatActivity {

    private Button BtnMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dev__options__real);



        BtnMove = findViewById(R.id.back);


        BtnMove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                back();
            }
        });

    }

    private void back(){
        Intent intent = new Intent(Dev_Options_Real.this, MainActivity.class);
        startActivity(intent);
    }



    public void submit(View v){
        double attempt = 0;
        double devCode = 12345;
        EditText inputText = (EditText)findViewById(R.id.DevCode);
        attempt = Double.parseDouble(inputText.getText().toString());
        if (attempt == devCode){
            back();
        }
    }
}

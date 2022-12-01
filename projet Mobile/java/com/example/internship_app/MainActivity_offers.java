package com.example.internship_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_offers extends AppCompatActivity {

     private Button submit1,submit2,logout,addoffer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_offers);
        submit1=(Button) findViewById(R.id.submit1);
        submit2=(Button) findViewById(R.id.submit2) ;
        logout=(Button) findViewById(R.id.logout);
        addoffer=(Button)findViewById(R.id.addoffer) ;


        submit1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity_offers.this,MainActivity_submitcv.class));
            }
        });


        submit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_offers.this,MainActivity_submitcv.class));
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_offers.this,MainActivity.class));
            }
        });
        addoffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_offers.this,MainActivity_addoffer.class));
            }
        });

    }
}
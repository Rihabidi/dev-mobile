package com.example.internship_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView student,recruiter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student=(ImageView) findViewById(R.id.student);
        student.setOnClickListener(this);

        recruiter=(ImageView) findViewById(R.id.recruiter);
        recruiter.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.student:
                startActivity(new Intent(MainActivity.this,MainActivity_login.class));
                break;
            case R.id.recruiter:
                startActivity(new Intent(MainActivity.this,MainActivity_login.class));
                break;

        }


    }
}
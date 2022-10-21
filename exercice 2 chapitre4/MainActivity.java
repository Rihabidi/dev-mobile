package com.example.exercicechap4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button b=(Button) findViewById(R.id.btn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton r1 = (RadioButton) findViewById(R.id.radioButton);
                EditText s = (EditText) findViewById(R.id.editTextNumber);
                s.getText();
                Double poids=new Double(s.toString());
                Double res1;
                if (r1.isChecked())
                    res1 = poids * 2.2;
                else
                     res1=poids/2.2;

                Toast.makeText(getApplicationContext(), res1.toString(),Toast.LENGTH_LONG).show();

            }
        });








    }
}
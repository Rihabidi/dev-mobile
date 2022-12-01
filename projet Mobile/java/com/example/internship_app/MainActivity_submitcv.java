package com.example.internship_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;

public class MainActivity_submitcv extends AppCompatActivity {
    private Button Add;
    private EditText fullname,education,experience,skills;
    DatabaseReference databaseCV;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_submitcv);

        Add=(Button)findViewById(R.id.submit3);
        fullname=(EditText) findViewById(R.id.fullname);
        education=(EditText) findViewById(R.id.education);
        experience=(EditText) findViewById(R.id.experience);
        skills=(EditText) findViewById(R.id.skills);

        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCv();

            }
        });




    }

    private void AddCv() {
        String FullNane=fullname.getText().toString();
        String Education=education.getText().toString();
        String Experience=experience.getText().toString();
        String Skills=skills.getText().toString();
        String id=databaseCV.push().getKey();

        if (FullNane.isEmpty()) {
            fullname.setError("Full Name is required");
            fullname.requestFocus();
            return;}


        if (Experience.isEmpty()) {
            experience.setError("Experience is required");
            experience.requestFocus();
            return;}


        if (Education.isEmpty()) {
            education.setError("Education is required");
            education.requestFocus();
            return;}

        if (Skills.isEmpty()) {
            skills.setError("Skills is required");
            skills.requestFocus();
            return;}



        CV cv=new CV(FullNane,Experience,Education,Skills);
        databaseCV.child("CV").child(id).setValue(cv).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity_submitcv.this, "Submit CV done Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });





    }
}
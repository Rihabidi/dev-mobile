package com.example.internship_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity_addoffer extends AppCompatActivity {
    private Button submit ,recyle;

    private EditText postname,description,aboutus;
    DatabaseReference databaseOffer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_addoffer);

        submit=(Button) findViewById(R.id.submit3);
        recyle=(Button)findViewById(R.id.view) ;
        postname=(EditText) findViewById(R.id.fullname);
        description=(EditText) findViewById(R.id.description);
        aboutus=(EditText) findViewById(R.id.aboutus);
        databaseOffer= FirebaseDatabase.getInstance().getReference();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insertData();
            }


        });
        recyle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity_addoffer.this,MainActivity_offers.class));
                finish();
            }
        });








    }

    private void insertData() {
        String PostName=postname.getText().toString();
        String Description=description.getText().toString();
        String AbouUs=aboutus.getText().toString();
        String id=databaseOffer.push().getKey();


        if (PostName.isEmpty()) {
            postname.setError("Post Name is required");
            postname.requestFocus();
            return;}

        if (Description.isEmpty()) {
            description.setError("Post Name is required");
            description.requestFocus();
            return;}

        if (AbouUs.isEmpty()) {
            aboutus.setError("Post Name is required");
            aboutus.requestFocus();
            return;}



        Offer offer=new Offer(PostName,Description,AbouUs);
        databaseOffer.child("Internships").child(id).setValue(offer).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(MainActivity_addoffer.this, "Submit Offer done Successfully", Toast.LENGTH_SHORT).show();
                }

            }
        });



    }
}
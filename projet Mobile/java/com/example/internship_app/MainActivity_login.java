package com.example.internship_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity_login extends AppCompatActivity implements View.OnClickListener {
    private Button signup,login;
    private EditText email,password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);

        login=(Button) findViewById(R.id.btn1);
        login.setOnClickListener(this);

        signup=(Button) findViewById(R.id.btn2);
        signup.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn2:
                startActivity(new Intent(MainActivity_login.this,MainActivity_signup.class));
                break;

            case R.id.btn1:
                loginMethods();
                break;
        }

    }

    private void loginMethods() {

        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();


        if (Email.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;

        }
        if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            email.setError("please provide valid email!");
            email.requestFocus();
            return;

        }
        if (Password.isEmpty()){
            password.setError("Password is required");
            password.requestFocus();
            return;
        }
        if (Password.length()<6){
            password.setError("min password length should be 6 characters");
            password.requestFocus();
            return;
        }

      mAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
          @Override
          public void onComplete(@NonNull Task<AuthResult> task) {
              if(task.isSuccessful()){
                  startActivity(new Intent(MainActivity_login.this,MainActivity_offers.class));

              }else{
                  Toast.makeText(MainActivity_login.this, "Failed to login!", Toast.LENGTH_SHORT).show();
              }




          }
      });

        }


}
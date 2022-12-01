package com.example.internship_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity_signup extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private EditText name, email, password;
    private Button signup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mAuth = FirebaseAuth.getInstance();

        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.Password);

        signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(this);





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.signup:
                signupUser();

        }

    }

    private void signupUser() {
        String FullName = name.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if (FullName.isEmpty()) {
            name.setError("Full Name is required");
            name.requestFocus();
            return;

        }
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

        mAuth.createUserWithEmailAndPassword(Email,Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user=new User(FullName,Email);

                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()){
                                                Toast.makeText(MainActivity_signup.this,"user has been Sign Up successfully",Toast.LENGTH_LONG).show();


                                            }else {
                                                Toast.makeText(MainActivity_signup.this,"Failed to Sign Up!Try Again",Toast.LENGTH_LONG).show();

                                            }
                                        }
                                    });



                        }else {
                            Toast.makeText(MainActivity_signup.this,"Failed to Sign Up!",Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
}

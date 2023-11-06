package com.example.toursimapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class signup extends AppCompatActivity {


    EditText name, email, cpassword, conpass;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        auth = FirebaseAuth.getInstance();
        name = findViewById(R.id.username);
        email = findViewById(R.id.emailadd);
        cpassword = findViewById(R.id.createpass);
        conpass = findViewById(R.id.confpass)


        //clickable text
        TextView textView = findViewById(R.id.logintext);

        String text = "Login";

        SpannableString ss = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                Intent intent = new Intent(signup.this, Login.class);
                startActivity(intent);
            }

        };

        ss.setSpan(clickableSpan1, 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }

    public void signup(View view) {

        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String createPassword = cpassword.getText().toString();
        String confirmPassword = conpass.getText().toString();

        if (TextUtils.isEmpty(userName)) {
            Toast.makeText(this,"Enter Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(userEmail)) {
            Toast.makeText(this,"Enter Email Address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(createPassword)) {
            Toast.makeText(this,"Enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (createPassword.length() < 8){
            Toast.makeText(this,"Password too short", Toast.LENGTH_SHORT).show();
            return;
        }
        if (createPassword == confirmPassword){
            Toast.makeText(this,"Enter confirm password again", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener(signup.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(signup.this, "Successfully Register", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(signup.this, HomeScreen.class));
                        }else {
                            Toast.makeText(signup.this, "Registration Failed"+task.getException(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });

    }


}
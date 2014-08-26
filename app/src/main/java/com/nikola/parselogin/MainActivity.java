package com.nikola.parselogin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;


public class MainActivity extends Activity implements View.OnClickListener {

    EditText etUserName, etPassword;
    Button bForgot, bLogin, bSignUp;
    String username, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Parse.com initialize
        // Paste your own app details here
        // Something like:  Parse.initialize(this, "dsf23432", "23423423423");

        // XML initialize
        XMLInitialize();
    }

    private void XMLInitialize() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        bForgot = (Button) findViewById(R.id.bForgot);
        bLogin = (Button) findViewById(R.id.bLogin);
        bSignUp = (Button) findViewById(R.id.bSignUp);

        bLogin.setOnClickListener(this);
        bForgot.setOnClickListener(this);
        bSignUp.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bLogin:
                username = etUserName.getText().toString();
                password = etPassword.getText().toString();
                // Parse.com login setup
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Login Unsuccessful! Check your username and password.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                break;
            case R.id.bSignUp:
                Intent i = new Intent(this, SignUpActivity.class);
                startActivity(i);
                break;
            case R.id.bForgot:
                Intent j = new Intent(this, ForgotPassActivity.class);
                startActivity(j);
                break;
        }
    }
}


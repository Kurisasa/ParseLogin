package com.nikola.parselogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

/**
 * Created by Nikola on 27.07.2014..
 */
public class SignUpActivity extends Activity implements View.OnClickListener {

    EditText etUserName, etPassword, etEmail;
    Button bSave;
    String username, password, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // XML Initialize
        XMLInitialize();
    }

    private void XMLInitialize() {
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etEmail = (EditText) findViewById(R.id.etEmail);
        bSave = (Button) findViewById(R.id.bSave);

        bSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        username = etUserName.getText().toString();
        password = etPassword.getText().toString();
        email = etEmail.getText().toString();

        // Parse.com signup setup
        ParseUser user = new ParseUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e == null){
                    Toast.makeText(SignUpActivity.this, "Wheee!! You made it!", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(SignUpActivity.this, "Fail! Something wrong.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

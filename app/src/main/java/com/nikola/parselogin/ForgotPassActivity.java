package com.nikola.parselogin;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.RequestPasswordResetCallback;

/**
 * Created by Nikola on 29.07.2014..
 */
public class ForgotPassActivity extends Activity implements View.OnClickListener {

    EditText etNewEmail;
    String newEmail;
    Button bConfrim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpass);

        // XMLInitialize
        etNewEmail = (EditText) findViewById(R.id.etNewEmail);
        bConfrim = (Button) findViewById(R.id.bConfrim);
        bConfrim.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        newEmail = etNewEmail.getText().toString();
        // Parse.com forgot password setup

        ParseUser.requestPasswordResetInBackground(newEmail, new RequestPasswordResetCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null){
                    Toast.makeText(ForgotPassActivity.this, "Check your Email for new Password!", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(ForgotPassActivity.this, "Fail! Check your Email.", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

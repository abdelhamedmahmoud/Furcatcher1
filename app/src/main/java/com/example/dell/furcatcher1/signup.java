package com.example.dell.furcatcher1;


import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;

import android.text.TextWatcher;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.R.attr.button;
import static android.R.attr.id;

public class signup extends AppCompatActivity {
    EditText username, pass, cPass, email;
    TextView Sign, userv, passv, cpassv, emailv;
    String us, pas, cpas, e_mail ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        username = (EditText) findViewById(R.id.username);
        username.requestFocus();

        pass = (EditText) findViewById(R.id.password);
        email = (EditText) findViewById(R.id.email);
        cPass = (EditText) findViewById(R.id.cPassword);


        userv = (TextView) findViewById(R.id.uv);
        passv = (TextView) findViewById(R.id.pv);
        cpassv = (TextView) findViewById(R.id.cpv);
        emailv = (TextView) findViewById(R.id.ev);
        Sign = (TextView)findViewById(R.id.flag);

//////////////////////////// Text listener For Making Validation /////////
        username.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                userv.setAlpha(0);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                us = s.toString();
                if (us.isEmpty()) {
                    username.setError("Username field is Empty");
                    userv.setAlpha(0);
                } else if (!usernameValidation(us)) {
                    username.setError("Username must be As following \n" +
                            "1-Only contains alphanumeric characters, underscore and dot.\n" +
                            "2-Underscore and dot can't be at the end or start of a username\n" +
                            "3-Underscore and dot can't be next to each other\n" +
                            "4-Underscore or dot can't be used multiple times in a row\n" +
                            "5-Number of characters must be between 8 to 25");

                    userv.setAlpha(0);
                } else if (us.length() >= 26) {
                    username.setError("Username field must have Only 25 Character");
                    userv.setAlpha(0);
                } else {

                    userv.setAlpha(1);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        pass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

//                passv.setAlpha(0);
//                if(!usernameValidation(username.getText().toString()))
//                {
//
//                    AlertDialog.Builder Quation= new AlertDialog.Builder(signup.this);
//                    Quation.setMessage("Please Fill Username Field correctly")
//                            .setTitle("Warning")
//                            .show();
//
////                    .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
////                    @Override
////                    public void onClick(DialogInterface dialog, int which) {
////                        username.requestFocus();
////                    }
////                });
//
//
//
//                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                pas = s.toString();
                if (pas.isEmpty()) {
                    pass.setError("Password field is Empty");
                    passv.setAlpha(0);
                } else if (!PasswordValidation(pas)) {
                    pass.setError("Not Valid Password  \n" +
                            " Passwords must have at least 8characters \n" +
                            " and contain at least two of the following:\n" +
                            " upper case letters , lower case letters ,\n" +
                            " numbers and Symbols  ");
                    passv.setAlpha(0);
                } else {
//                    Toast.makeText(getApplicationContext(), "Password is Good", Toast.LENGTH_SHORT).show();


                    passv.setAlpha(1);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        cPass.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                cpassv.setAlpha(0);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                cpas = s.toString();
                if (cpas.isEmpty()) {
                    cPass.setError("Password field is Empty");
                    cpassv.setAlpha(0);
                } else if (!cPass.getText().toString().equals(pass.getText().toString())) {
                    cPass.setError("Password Not Matches \n");
                    cpassv.setAlpha(0);
                } else {
                    cpassv.setAlpha(1);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                emailv.setAlpha(0);

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e_mail = s.toString();
                if (e_mail.isEmpty()) {
                    email.setError("Email field is Empty");
                    emailv.setAlpha(0);
                } else if (!emailValidation(e_mail)) {
                    email.setError("Not Valid Email \n" +
                            "E-mail nust be like this example \n" +
                            "example@example.com");
                    emailv.setAlpha(0);
                } else {

                    emailv.setAlpha(1);

                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
////////////////////////////////////////////////////////////////////////////


////////////////////////////////////  Buttons ///////////////////////////////////
        Button Register = (Button) findViewById(R.id.Register);
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (username.getText().toString().isEmpty() || pass.getText().toString().isEmpty() || cPass.getText().toString().isEmpty() || email.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Complete Missing Fields", Toast.LENGTH_SHORT).show();
                } else if (!emailValidation(email.getText().toString())) {

                    AlertDialog.Builder Quation = new AlertDialog.Builder(signup.this);
                    Quation.setMessage("Please Fill Email Address correctly !! ")
                            .setTitle("Warning")
                            .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    email.requestFocus();
                                }
                            }).show();

                }
                else
                {
                    onSignup();
                }

            }
        });
///////////////////////////////////////////////////////////////////////////////


/////////////////// TextView Listener /////////////////////////////////////////
        Sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(signup.this, login.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                //Toast.makeText(signup.this, "Login Activity Here We Come!!", Toast.LENGTH_SHORT).show();
            }
        });
/////////////////////////////////////////////////////////////////////////////////



///////////////////////////// EditTexts Dialog Alerts ///////////////////////////
pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus)
        {

                    if (!usernameValidation(username.getText().toString())) {

                        AlertDialog.Builder Quation = new AlertDialog.Builder(signup.this);
                        Quation.setMessage("Please Fill Username Field correctly !! ")
                                .setTitle("Warning")
                                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        username.requestFocus();
                                    }
                                }).show();
                    }

        }
    }
});


cPass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus)
        {

                    if (!PasswordValidation(pass.getText().toString())) {

                        AlertDialog.Builder Quation = new AlertDialog.Builder(signup.this);
                        Quation.setMessage("Please Fill Password Field correctly !! ")
                                .setTitle("Warning")
                                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        pass.requestFocus();
                                    }
                                }).show();
                    }

        }
    }
});

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {

                    if (cPass.getText().toString().isEmpty()||!cPass.getText().toString().equals(pass.getText().toString())) {

                        AlertDialog.Builder Quation = new AlertDialog.Builder(signup.this);
                        Quation.setMessage("Please Re-Type The password Correctly!! ")
                                .setTitle("Warning")
                                .setPositiveButton("Dismiss", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        cPass.requestFocus();
                                    }
                                }).show();

                    }
                }
            }
        });



///////////////////////////////////////////////////////////////////////////////////
}


//////////////// Validate Email & Passwords & username By Pattern (Regex) Method///

    public boolean emailValidation(String email) {
        String email_validation = "^[\\w-]+(\\.[\\w-]+)*@([a-z0-9-]+(\\.[a-z0-9-]+)*?\\.[a-z]{2,6}|(\\d{1,3}\\.){3}\\d{1,3})(:\\d{4})?$";
        Pattern pattern = Pattern.compile(email_validation);
        Matcher matcher = pattern.matcher(email);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }                          ///


    public boolean PasswordValidation(String Password) {
        String pass_validation = "^(?=.*\\d)(?=.*[a-zA-Z])(?!.*[\\W_\\x7B-\\xFF]).{6,15}$";
        Pattern pattern = Pattern.compile(pass_validation);
        Matcher matcher = pattern.matcher(Password);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }                    ///


    public boolean usernameValidation(String username) {
        String email_validation = "^(?=.{8,25}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$";
        Pattern pattern = Pattern.compile(email_validation);
        Matcher matcher = pattern.matcher(username);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
        }
    }                    ///
///////////////////////////////////////////////////////////////////////////////////

    public void onSignup ()
    {
        String Username=username.getText().toString();
        String cpassword=cPass.getText().toString();
        String e_mail=email.getText().toString();
        String Type = "SignUp";
        BackgroundDB_helper DB = new BackgroundDB_helper(this);
        DB.execute(Type , Username , cpassword , e_mail);


    }

}



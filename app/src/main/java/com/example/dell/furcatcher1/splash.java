package com.example.dell.furcatcher1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);



        Thread Timer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                }catch(InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(splash.this, entrance.class);
                    startActivity(i);
                }
            }
        };
        Timer.start();
    }
}

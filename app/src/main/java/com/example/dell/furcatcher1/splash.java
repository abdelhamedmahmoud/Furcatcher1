package com.example.dell.furcatcher1;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Timer;

public class splash extends AppCompatActivity implements View.OnClickListener {

    Button retry;
    WifiManager wifiManager;
    NetworkInfo Mobile;
    ConnectivityManager connectivityMgr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        retry= (Button)findViewById(R.id.button2);
        retry.setOnClickListener(this);

        /////method To Check Internet Connection
        internetCheck();
    }

public  void internetCheck() {
    ////// Wifi State
    wifiManager= (WifiManager)getSystemService(Context.WIFI_SERVICE);

    ////// Mobile Data State
    connectivityMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    Mobile = connectivityMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

    if(wifiManager.isWifiEnabled() || Mobile.isConnected()) {
        RelativeLayout r = (RelativeLayout)findViewById(R.id.SplashRelative);
        retry.setAlpha(0);
        r.setBackgroundResource(R.drawable.splash);
        Thread Timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent(splash.this, entrance.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        Timer.start();
    }


    else
    {

//            AlertDialog.Builder builder= new AlertDialog.Builder(this);
//            builder.setMessage("Please Check Your Internet Connection")
//                    .setTitle("Network Warning")
//                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            System.exit(0);
//                        }
//                    }).show();


        retry.setAlpha(1);
    }
}


    @Override
    public void onClick(View v)
    {
       int id = v.getId();
        if(id==R.id.button2)
        {

            internetCheck();

        }
    }


}

package com.example.dell.furcatcher1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class start extends AppCompatActivity {
    Typeface my_Custom;
    TextView scan, explore , exploreformany ,about , scant , ext , exmanyt , aboutt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        my_Custom = Typeface.createFromAsset(getAssets() , "fonts/SEGOEUI.TTF");
        TextView textView = (TextView) findViewById(R.id.info);
        textView.setText("Welcome "+ login.name);

        Button b = (Button)findViewById(R.id.go);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(start.this , scan.class );
                startActivity(i);
            }
        });

        scan = (TextView) findViewById(R.id.scantex);
        explore = (TextView) findViewById(R.id.exploreforone);
        exploreformany = (TextView) findViewById(R.id.exploretomany);
        about = (TextView) findViewById(R.id.about);
        scant = (TextView) findViewById(R.id.scango);
        ext = (TextView) findViewById(R.id.exonetex);
        exmanyt = (TextView) findViewById(R.id.exmanytex);
        aboutt = (TextView) findViewById(R.id.abouttex);

        scan.setTypeface(my_Custom);
        explore.setTypeface(my_Custom);
        exploreformany.setTypeface(my_Custom);
        about.setTypeface(my_Custom);
        scant.setTypeface(my_Custom);
        ext.setTypeface(my_Custom);
        exmanyt.setTypeface(my_Custom);
        aboutt.setTypeface(my_Custom);

    }


    }



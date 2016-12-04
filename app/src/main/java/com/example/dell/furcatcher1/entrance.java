package com.example.dell.furcatcher1;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import me.relex.circleindicator.CircleIndicator;

public class entrance extends FragmentActivity implements View.OnClickListener {
    ViewPager viewPager;
    Button register;
    Button signin;
    private static int currentpage=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrance);
        viewPager=(ViewPager)findViewById(R.id.view_pager);
        signin=(Button) findViewById(R.id.signinmainpage);
        register=(Button) findViewById(R.id.registermainpage);
        signin.setOnClickListener(this);
        register.setOnClickListener(this);
        final SwipeAdapter swipeAdapter=new SwipeAdapter(getSupportFragmentManager());

        viewPager.setAdapter(swipeAdapter);
        CircleIndicator indicator =(CircleIndicator)findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentpage=position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {


            }
        });

    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.signinmainpage){
            Intent i = new Intent(entrance.this, login.class);
            startActivity(i);


        }
        else if (view.getId()==R.id.registermainpage) {

            Intent i = new Intent(entrance.this, signup.class);
            startActivity(i);
        }

    }
}

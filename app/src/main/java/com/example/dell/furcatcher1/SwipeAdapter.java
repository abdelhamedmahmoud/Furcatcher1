package com.example.dell.furcatcher1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Dell on 12/4/2016.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {
    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment=new viewpager();
        Bundle bundle=new Bundle();



            if (i == 0)
                bundle.putString("count", "you can replace this text with some information about the application and the benefits that the client is gonna get after using it");
            else if (i == 1)
                bundle.putString("count", "kareem gamal El deen Mohamed");
            else
                bundle.putString("count", "abdelhamded mahmoud abdelhamed");

            fragment.setArguments(bundle);
            return fragment;


    }

    @Override
    public int getCount() {
        return 3;
    }
}

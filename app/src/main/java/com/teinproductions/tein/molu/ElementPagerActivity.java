package com.teinproductions.tein.molu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;

public class ElementPagerActivity extends ActionBarActivity {

    ViewPager theViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theViewPager = new ViewPager(this);

        theViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    return new ElementListFragment();
                } return Element.values()[position + 1].toFragment();
            }

            @Override
            public int getCount() {
                return Element.values().length + 1;
            }
        });

        setContentView(theViewPager);

    }
}

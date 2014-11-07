package com.teinproductions.tein.molu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class ElementPagerActivity extends ActionBarActivity
                    implements ElementListFragment.onElementClickListener,
                               CalculateFragment.OnCalculateClickListener{

    ViewPager theViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        theViewPager = new ViewPager(this);
        theViewPager.setId(0x1);

        theViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                if(position == 0){
                    return new ElementListFragment();
                } return Element.values()[position - 1].toFragment();
            }

            @Override
            public int getCount() {
                return Element.values().length + 1;
            }
        });

        theViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        setContentView(theViewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.element_pager, menu);
        menu.findItem(R.id.pager_activity_show_list_action).setVisible(!(theViewPager.getCurrentItem() == 0));
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.pager_activity_show_list_action){
            theViewPager.setCurrentItem(0, true);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onElementClick(int position) {
        theViewPager.setCurrentItem(position + 1, true);
    }

    @Override
    public Element onRequestElement() {
        return Element.values()[theViewPager.getCurrentItem() - 1];
    }
}
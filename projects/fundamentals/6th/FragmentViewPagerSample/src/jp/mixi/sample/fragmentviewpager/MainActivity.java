
package jp.mixi.sample.fragmentviewpager;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements TabListener {

    ViewPager mViewPager;

    
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getActionBar();
        
        
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(getActionBar().newTab().setText("Tab1").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab2").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab3").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab4").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab5").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab6").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab6").setTabListener(this));
        actionBar.addTab(getActionBar().newTab().setText("Tab6").setTabListener(this));
        
        mViewPager = (ViewPager) findViewById(R.id.Pager);
        
        FragmentManager fm = getSupportFragmentManager();
        SampleFragmentPagerAdapter sampleFragmentPagerAdapter = new SampleFragmentPagerAdapter(fm);
        
        mViewPager.setAdapter(sampleFragmentPagerAdapter);
        mViewPager.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        // When swiping between pages, select the
                        // corresponding tab.
                        getActionBar().setSelectedNavigationItem(position);
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        if (mViewPager != null) {
            mViewPager.setCurrentItem(tab.getPosition());
        }
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
        // TODO Auto-generated method stub
        
    }

}

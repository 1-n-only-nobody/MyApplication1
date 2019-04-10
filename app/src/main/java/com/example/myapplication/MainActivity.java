package com.example.myapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener,VideoFragment.OnFragmentInteractionListener,DashboardFragment.OnFragmentInteractionListener,ProfileFragment.OnFragmentInteractionListener{

    //private TextView mTextMessage;
    //private static final int NUM_PAGES = 4;
    BottomNavigationView navigation;
    int position = 0;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    position = 0;
                    viewPager.setCurrentItem(position);
                    return true;
                case R.id.navigation_video:
                    //mTextMessage.setText(R.string.title_video);
                    position = 1;
                    viewPager.setCurrentItem(position);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    position = 2;
                    viewPager.setCurrentItem(position);
                    return true;
                case R.id.navigation_Profile:
                    //mTextMessage.setText(R.string.title_profile);
                    position = 3;
                    viewPager.setCurrentItem(position);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //mTextMessage = (TextView) findViewById(R.id.message);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new SwipePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0)
                    navigation.setSelectedItemId(R.id.navigation_home);
                if (i == 1)
                    navigation.setSelectedItemId(R.id.navigation_video);
                if (i == 2)
                    navigation.setSelectedItemId(R.id.navigation_dashboard);
                if (i == 3)
                    navigation.setSelectedItemId(R.id.navigation_Profile);
                System.out.println(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
class SwipePagerAdapter extends FragmentStatePagerAdapter {

    public SwipePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                return homeFragment;
            case 1:
                VideoFragment videoFragment = new VideoFragment();
                return videoFragment;
            case 2:
                DashboardFragment dashboardFragment = new DashboardFragment();
                return dashboardFragment;
            case 3:
                ProfileFragment profileFragment = new ProfileFragment();
                return profileFragment;
        }
        return null;

    }

    @Override
    public int getCount() {
        return 4;
    }

}

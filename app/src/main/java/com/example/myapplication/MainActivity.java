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
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;
    //private static final int NUM_PAGES = 4;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_video:
                    mTextMessage.setText("Video");
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_Profile:
                    mTextMessage.setText(R.string.title_profile);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new SwipePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
class SwipePagerAdapter extends FragmentStatePagerAdapter implements HomeFragment.OnFragmentInteractionListener,VideoFragment.OnFragmentInteractionListener,DashboardFragment.OnFragmentInteractionListener,ProfileFragment.OnFragmentInteractionListener{

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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

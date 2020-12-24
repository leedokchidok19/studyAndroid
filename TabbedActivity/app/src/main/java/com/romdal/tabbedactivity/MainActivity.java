package com.romdal.tabbedactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.vp_pager);

        Fragment[] arrFragments = new Fragment[3];
        arrFragments[0] = new RedFragment();
        arrFragments[1] = new YellowFragment();
        arrFragments[2] = new GreenFragment();

        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager(), arrFragments);
        viewPager.setAdapter(adapter);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter{
        //FragmentPagerAdapter 적은 수의 페이지를 사용할 때
        //FragmentStatePagerAdapter 많은 수의 페이지를 사용할 떄
        private Fragment[] arrFragments;

        public MyPagerAdapter(FragmentManager fm, Fragment[] arrFragments) {
            super(fm);
            this.arrFragments = arrFragments;
        }

        @Override
        public Fragment getItem(int position) {
            return arrFragments[position];
        }

        @Override
        public int getCount() {
            return arrFragments.length;
        }
    }

}

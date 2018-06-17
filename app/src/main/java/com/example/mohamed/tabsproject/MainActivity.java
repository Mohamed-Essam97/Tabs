package com.example.mohamed.tabsproject;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;

public class MainActivity extends AppCompatActivity {

   ViewPager pager;
   TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pager=findViewById(R.id.viewPager);
        tabLayout=findViewById(R.id.tabLayout);

        //create a new class name="MyAdapter" and extends FragmentxStatePagerAdapter

        //and get from the this class new object name="adapter"
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager());

        //ده بيخلى الpager بيدعم الfragment
        pager.setAdapter(adapter);
        //ده بيخلى الpager يمشى او يتحرك مع ال tablayout
        tabLayout.setupWithViewPager(pager);

    }
    //this is the new class
    class MyAdapter extends FragmentStatePagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            if (position==0)
            {
                fragment=new FragmentOne();
            }
            if (position==1)
            {
                fragment=new FragmentTwo();
            }
            if (position==2)
            {
                fragment=new FragmentThree();
            }
                return fragment;
        }
        //this is the number of fragment
        @Override
        public int getCount() {
            return 3;
        }

        //this is the name of tabs and here position
        @Override
        public CharSequence getPageTitle(int position) {
            if (position==0)
                return "first tab";
            else if (position==1)
                return "Second tab";
            else if (position==2)
                return "third tab";

            return super.getPageTitle(position);
        }
    }
}

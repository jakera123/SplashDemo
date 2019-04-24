package com.jakera.SplashDemo.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jakera.SplashDemo.Entities.SplashEntity;
import com.jakera.SplashDemo.Fragement.SplashFirstFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakera on 2019/4/22.
 */

public class SplashPagerAdapter extends FragmentPagerAdapter {

    private List<SplashEntity> splashEntities=new ArrayList<>();

    public SplashPagerAdapter(FragmentManager fm,List<SplashEntity> splashEntities) {
        super(fm);
        this.splashEntities=splashEntities;
    }

    @Override
    public Fragment getItem(int position) {
        return SplashFirstFragment.newInstance(splashEntities.get(position));
    }

    @Override
    public int getCount() {
        return splashEntities.size();
    }
}

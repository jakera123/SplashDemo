package com.jakera.SplashDemo.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jakera.SplashDemo.Adapter.SplashPagerAdapter;
import com.jakera.SplashDemo.Entities.SplashEntity;
import com.jakera.SplashDemo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jakera on 2019/4/22.
 * 启动页
 */

public class SplashActivity extends AppCompatActivity {
    private final static String TAG=SplashActivity.class.getSimpleName();

    private ViewPager viewPager;
    private SplashPagerAdapter adapter;
    private List<SplashEntity> splashEntities=new ArrayList<>();
    private LinearLayout indicatorLL;
    private List<ImageView> indicators;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        viewPager=(ViewPager)findViewById(R.id.splashVP);
        initDatas();
        adapter=new SplashPagerAdapter(getSupportFragmentManager(),splashEntities);
//        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(adapter);
        indicatorLL=findViewById(R.id.LL_Splash_indicator);
        indicators=new ArrayList<>(splashEntities.size());
        for (int i=0;i<splashEntities.size();i++){
            ImageView imageView=new ImageView(this);
            if (i==0){
                imageView.setBackgroundResource(R.drawable.shape_black_circle);
            }else {
                imageView.setBackgroundResource(R.drawable.shape_yellow_circle);
            }
            indicators.add(imageView);
            indicatorLL.addView(imageView);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (int i=0;i<indicators.size();i++){
                    ImageView imageView=indicators.get(i);
                    if (position==i){
                        imageView.setBackgroundResource(R.drawable.shape_black_circle);
                    }else {
                        imageView.setBackgroundResource(R.drawable.shape_yellow_circle);
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 装载数据
     */
    private void initDatas() {
        splashEntities.add(new SplashEntity(R.mipmap.splash_love,"有一种","爱","情",
                "身无彩凤又飞翼","心有灵犀一点通"));
        splashEntities.add(new SplashEntity(R.mipmap.splash_friendship,"有一种","境","界",
                "衣带渐宽终不悔","为伊消得人憔悴"));
        splashEntities.add(new SplashEntity(R.mipmap.splash_miss,"有一个","雨","夜",
                "一任阶前","点滴到天明"));
    }
}

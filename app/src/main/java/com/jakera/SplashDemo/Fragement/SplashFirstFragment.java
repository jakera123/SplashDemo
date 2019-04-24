package com.jakera.SplashDemo.Fragement;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jakera.SplashDemo.Entities.SplashEntity;
import com.jakera.SplashDemo.R;
import com.jakera.SplashDemo.Views.CircleImageView;


/**
 * Created by jakera on 2019/4/22.
 */

public class SplashFirstFragment extends Fragment {
    private static final String TAG=SplashFirstFragment.class.getSimpleName();

    private static final String PARAM_SPLASH="splash";
    private SplashEntity mSplashEntity;
    private CircleImageView circleImageView;
    private TextView firstContentTv;
    private TextView firstCircleTv;
    private TextView secondCircleTv;
    private TextView firstPoemTv;
    private TextView secondPoemTv;

    private boolean isLoading=false;


    public static SplashFirstFragment newInstance(SplashEntity entity){
        SplashFirstFragment fragment=new SplashFirstFragment();
        Bundle args=new Bundle();
        args.putSerializable(PARAM_SPLASH,entity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments()!=null){
            mSplashEntity=(SplashEntity)getArguments().getSerializable(PARAM_SPLASH);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_spalsh_one,container,false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        circleImageView=view.findViewById(R.id.iv_splash_first_circle);
        circleImageView.setImageResource(mSplashEntity.getPicture());
        firstContentTv=view.findViewById(R.id.tv_splash_first_content);
        firstContentTv.setText(mSplashEntity.getFirstContent());
        firstCircleTv=view.findViewById(R.id.tv_splash_first_circle_content);
        firstCircleTv.setText(mSplashEntity.getFirstCircleContent());
        secondCircleTv=view.findViewById(R.id.tv_splash_second_circle_content);
        secondCircleTv.setText(mSplashEntity.getSecondCircleContent());
        firstPoemTv=view.findViewById(R.id.tv_splash_first_poem);
        firstPoemTv.setText(mSplashEntity.getFirstPoem());
        secondPoemTv=view.findViewById(R.id.tv_splash_second_poem);
        secondPoemTv.setText(mSplashEntity.getSecondPoem());

        //防止fragment重建时出现控件看不见问题
        if (!isLoading){
            firstContentTv.setAlpha(0);
            firstCircleTv.setAlpha(0);
            secondCircleTv.setAlpha(0);
            firstPoemTv.setAlpha(0);
            secondPoemTv.setAlpha(0);
        }

    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser&&!isLoading){
            startAnimation();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getUserVisibleHint()){
            if (!isLoading){
                startAnimation();
                isLoading=true;
            }
        }
    }

    private void startAnimation() {
        if (firstContentTv==null){
            return;
        }
        isLoading=true;
        ObjectAnimator animator1=ObjectAnimator.ofFloat(firstContentTv,"alpha",0,1.0f);
        animator1.setDuration(1500)
                .start();
        final ObjectAnimator animator2=ObjectAnimator.ofFloat(firstCircleTv,"alpha",0,1.0f);
        animator2.setDuration(1500);
        final ObjectAnimator animator3=ObjectAnimator.ofFloat(secondCircleTv,"alpha",0,1.0f);
        animator3.setDuration(1500);
        final ObjectAnimator animator4=ObjectAnimator.ofFloat(firstPoemTv,"alpha",0,1.0f);
        animator4.setDuration(1500);
        final ObjectAnimator animator5=ObjectAnimator.ofFloat(secondPoemTv,"alpha",0,1.0f);
        animator5.setDuration(1500);
        animator1.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animator2.start();
                animator3.start();
            }
        });

        animator3.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animator4.start();
            }
        });

        animator4.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                animator5.start();
            }
        });
    }
}

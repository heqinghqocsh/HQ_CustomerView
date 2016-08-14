package com.heqing.hq_customview.fragment;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.heqing.hq_customview.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何清 on 2016/6/10 0010.
 *
 * @description
 */
public class AnimationSpecialEffectFragment extends Fragment implements View.OnClickListener{

    private int[] mMenuRes = {R.id.menu_a,R.id.menu_b,R.id.menu_c,
            R.id.menu_d,R.id.menu_e};
    private List<ImageView> mImageViews = new ArrayList<>();
    private boolean mMenuFlag = true;

    private TextView mTvTimer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.animation_special_effects_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvTimer = (TextView)view.findViewById(R.id.tvTimer);
        mTvTimer.setOnClickListener(this);
        for(int i = 0;i < mMenuRes.length;i++){
            ImageView imageView = (ImageView)view.findViewById(mMenuRes[i]);
            imageView.setOnClickListener(this);
            mImageViews.add(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.menu_a:
                if (mMenuFlag){
                    startAnim();
                }else{
                    closeAnim();
                }
                break;
            case R.id.tvTimer:
                ValueAnimator valueAnimator = ValueAnimator.ofInt(0,59);
                valueAnimator.setInterpolator(new LinearInterpolator());
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        mTvTimer.setText("$ "+animation.getAnimatedValue());
                    }
                });
                valueAnimator.setDuration(60000);
                valueAnimator.start();
                break;
        }
    }

    private void closeAnim(){
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),"alpha",0.5f,1f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),"translationY",200f,0);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),"translationX",200f,0);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),"translationY",-200f,0);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),"translationX",-200f,0);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.playTogether(animator0,animator1,animator2,animator3,animator4);
        animatorSet.start();
        mMenuFlag = true;
    }

    private void startAnim(){
        ObjectAnimator animator0 = ObjectAnimator.ofFloat(mImageViews.get(0),"alpha",1f,0.5f);
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(mImageViews.get(1),"translationY",200f);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(mImageViews.get(2),"translationX",200f);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(mImageViews.get(3),"translationY",-200f);
        ObjectAnimator animator4 = ObjectAnimator.ofFloat(mImageViews.get(4),"translationX",-200f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(500);
        animatorSet.setInterpolator(new BounceInterpolator());
        animatorSet.playTogether(animator0, animator1, animator2, animator3, animator4);
        animatorSet.start();
        mMenuFlag = false;
    }


}

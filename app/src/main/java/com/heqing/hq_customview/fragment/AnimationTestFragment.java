package com.heqing.hq_customview.fragment;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.heqing.hq_customview.R;


/**
 * Created by 何清 on 2016/6/22 0022.
 *
 * @description
 */
public class AnimationTestFragment extends Fragment implements View.OnClickListener{

    private ImageView animation_view;
    private Animation anim;
    private Button[] buttonArr = new Button[6];

    private ImageView layout_anim_img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.animation_test_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        animation_view = (ImageView)view.findViewById(R.id.animation_view);

        buttonArr[0] = (Button)view.findViewById(R.id.translate);
        buttonArr[1] = (Button)view.findViewById(R.id.scale);
        buttonArr[2] = (Button)view.findViewById(R.id.alpha);
        buttonArr[3] = (Button)view.findViewById(R.id.rotate);
        buttonArr[4] = (Button)view.findViewById(R.id.all);
        buttonArr[5] = (Button)view.findViewById(R.id.frame_animation);

        layout_anim_img = (ImageView)view.findViewById(R.id.layout_anim_img);
        for(int i = 0;i < buttonArr.length;i++){
            buttonArr[i].setOnClickListener(this);
        }

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.translate:
                anim = AnimationUtils.loadAnimation(getActivity(),R.anim.translate_anim);
                break;
            case R.id.alpha:
                anim = AnimationUtils.loadAnimation(getActivity(),R.anim.alpha_anim);
                break;
            case R.id.scale:
                anim = AnimationUtils.loadAnimation(getActivity(),R.anim.scale_anim);
                break;
            case R.id.rotate:
                anim = AnimationUtils.loadAnimation(getActivity(),R.anim.rotate_anim);
                break;
            case R.id.all:
                anim = AnimationUtils.loadAnimation(getActivity(),R.anim.view_animation);
                break;
            case R.id.frame_animation:
                animation_view.clearAnimation();
                animation_view.setBackgroundResource(R.drawable.frame_anim);
                AnimationDrawable drawable = (AnimationDrawable)animation_view.getBackground();
                drawable.start();
                break;
        }
        if (layout_anim_img.getVisibility() == View.GONE){
            layout_anim_img.setVisibility(View.VISIBLE);
        }else{
            layout_anim_img.setVisibility(View.GONE);
        }
        animation_view.startAnimation(anim);
    }


    private void test(){
//        ListView listView = (ListView)findViewById(R.id.list);
//        Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha_anim);
//        LayoutAnimationController controller = new LayoutAnimationController(animation);
//        controller.setDelay(0.5f);
//        controller.setOrder(LayoutAnimationController.ORDER_NORMAL);
//        listView.setLayoutAnimation(controller);



    }





}

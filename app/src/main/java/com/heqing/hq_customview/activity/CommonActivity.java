package com.heqing.hq_customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.draw.ChangeImageEffect;
import com.heqing.hq_customview.enum_pkg.FragmentTypeEnum;
import com.heqing.hq_customview.fragment.AnimatedVectorTestFragment;
import com.heqing.hq_customview.fragment.AnimationSpecialEffectFragment;
import com.heqing.hq_customview.fragment.AnimationTestFragment;
import com.heqing.hq_customview.fragment.ChatItemListFragment;
import com.heqing.hq_customview.fragment.CircleProgressFragment;
import com.heqing.hq_customview.fragment.CustomScrollViewFragment;
import com.heqing.hq_customview.fragment.CustomVolumeFragment;
import com.heqing.hq_customview.fragment.DragViewTestFragment;
import com.heqing.hq_customview.fragment.ElasticListFragment;
import com.heqing.hq_customview.fragment.FlagBitmapMeshTest;
import com.heqing.hq_customview.fragment.NotificationTest;
import com.heqing.hq_customview.fragment.RevealLayoutTestFragment;
import com.heqing.hq_customview.fragment.RingMenuFragment;
import com.heqing.hq_customview.fragment.ScratchOffFragment;
import com.heqing.hq_customview.fragment.SlideConflict_1;
import com.heqing.hq_customview.fragment.SlideConflict_2;
import com.heqing.hq_customview.fragment.StickyLayoutTestFragment;
import com.heqing.hq_customview.fragment.SurfaceViewTestFragment;

/**
 * Created by 何清 on 2016/5/28 0028.
 *
 * @description
 */
public class CommonActivity extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity_layout);
        int type = getIntent().getIntExtra("type",1);
        updateUI(type);
    }

    private void updateUI(int type){
        if (type == FragmentTypeEnum.RingMenuFragmetn.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RingMenuFragment()).commit();
        }else if (type == FragmentTypeEnum.CircleProgressFragment.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CircleProgressFragment()).commit();
        }else if (type == FragmentTypeEnum.CustomerVolume.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CustomVolumeFragment()).commit();
        }else if (type == FragmentTypeEnum.CustomScrollView.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new CustomScrollViewFragment()).commit();
        }else if (type == FragmentTypeEnum.ElasticListView.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ElasticListFragment()).commit();
        }else if (type == FragmentTypeEnum.ChatFragment.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ChatItemListFragment()).commit();
        }else if (type == FragmentTypeEnum.DragViewTest.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new DragViewTestFragment()).commit();
        }else if (type == FragmentTypeEnum.ChangeImageEffect.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ChangeImageEffect()).commit();
        }else if (type == FragmentTypeEnum.FlagTest.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new FlagBitmapMeshTest()).commit();
        }else if (type == FragmentTypeEnum.Scratch_off.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new ScratchOffFragment()).commit();
        }else if (type == FragmentTypeEnum.Surface_view.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SurfaceViewTestFragment()).commit();
        }else if (type == FragmentTypeEnum.SVG_test_1.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AnimatedVectorTestFragment()).commit();
        }else if (type == FragmentTypeEnum.special_effects.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AnimationSpecialEffectFragment()).commit();
        }else if (type == FragmentTypeEnum.slide_conflict_1.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SlideConflict_1()).commit();
        }else if (type == FragmentTypeEnum.slide_conflict_2.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new SlideConflict_2()).commit();
        }else if (type == FragmentTypeEnum.reveal_test.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new RevealLayoutTestFragment()).commit();
        }else if (type == FragmentTypeEnum.sticky_layout_test.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new StickyLayoutTestFragment()).commit();
        }else if (type == FragmentTypeEnum.notification.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new NotificationTest()).commit();
        }else if (type == FragmentTypeEnum.animation.ordinal()){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new AnimationTestFragment()).commit();
        }
    }

}

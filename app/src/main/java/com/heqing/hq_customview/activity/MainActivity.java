package com.heqing.hq_customview.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.enum_pkg.FragmentTypeEnum;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClick(View view){
        Intent intent = new Intent(this,CommonActivity.class);
        switch (view.getId()){
            case R.id.ring_menu_view:
                intent.putExtra("type", FragmentTypeEnum.RingMenuFragmetn.ordinal());
                startActivity(intent);
                break;
            case R.id.circle_progress:
                intent.putExtra("type", FragmentTypeEnum.CircleProgressFragment.ordinal());
                startActivity(intent);
                break;
            case R.id.volume_view:
                intent.putExtra("type", FragmentTypeEnum.CustomerVolume.ordinal());
                startActivity(intent);
                break;
            case R.id.custom_scroll_view:
                intent.putExtra("type", FragmentTypeEnum.CustomScrollView.ordinal());
                startActivity(intent);
                break;
            case R.id.elastic_list_view:
                intent.putExtra("type", FragmentTypeEnum.ElasticListView.ordinal());
                startActivity(intent);
                break;
            case R.id.chat_fragment:
                intent.putExtra("type", FragmentTypeEnum.ChatFragment.ordinal());
                startActivity(intent);
                break;
            case R.id.dragview_test:
                intent.putExtra("type", FragmentTypeEnum.DragViewTest.ordinal());
                startActivity(intent);
                break;
            case R.id.draw_test_1:
                intent.putExtra("type", FragmentTypeEnum.ChangeImageEffect.ordinal());
                startActivity(intent);
                break;
            case R.id.draw_test_2:
                intent.putExtra("type", FragmentTypeEnum.FlagTest.ordinal());
                startActivity(intent);
                break;
            case R.id.draw_test_3:
                intent.putExtra("type", FragmentTypeEnum.Scratch_off.ordinal());
                startActivity(intent);
                break;
            case R.id.surface_test_1:
                intent.putExtra("type", FragmentTypeEnum.Surface_view.ordinal());
                startActivity(intent);
                break;
            case R.id.SVG_test_1:
                intent.putExtra("type", FragmentTypeEnum.SVG_test_1.ordinal());
                startActivity(intent);
                break;
            case R.id.special_effects:
                intent.putExtra("type", FragmentTypeEnum.special_effects.ordinal());
                startActivity(intent);
                break;
            case R.id.slide_conflict_1:
                intent.putExtra("type", FragmentTypeEnum.slide_conflict_1.ordinal());
                startActivity(intent);
                break;
            case R.id.slide_conflict_2:
                intent.putExtra("type", FragmentTypeEnum.slide_conflict_2.ordinal());
                startActivity(intent);
                break;
            case R.id.reveal_test:
                intent.putExtra("type", FragmentTypeEnum.reveal_test.ordinal());
                startActivity(intent);
                break;
            case R.id.stick_layout_test:
                intent.putExtra("type", FragmentTypeEnum.sticky_layout_test.ordinal());
                startActivity(intent);
                break;
            case R.id.notification:
                intent.putExtra("type", FragmentTypeEnum.notification.ordinal());
                startActivity(intent);
                break;
            case R.id.animation:
                intent.putExtra("type", FragmentTypeEnum.animation.ordinal());
                startActivity(intent);

                break;
            case R.id.loading:
                intent.putExtra("type", FragmentTypeEnum.mLoading.ordinal());
                startActivity(intent);
                break;
            case R.id.timer_test:
                intent.putExtra("type", FragmentTypeEnum.TimerTest.ordinal());
                startActivity(intent);
                break;
        }
        overridePendingTransition(R.anim.translate_anim, R.anim.alpha_anim);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.translate_anim, R.anim.alpha_anim);
    }
}

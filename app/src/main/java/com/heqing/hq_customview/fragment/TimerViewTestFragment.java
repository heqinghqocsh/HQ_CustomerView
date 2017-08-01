package com.heqing.hq_customview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.customer_view.TimerView;
import com.heqing.hq_customview.enum_pkg.Model;

/**
 * Created by HeQing on 2016/9/6 0006.
 */
public class TimerViewTestFragment extends Fragment{

    TimerView mTimerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.timer_test_layout,null);
        initView(rootView);
        return rootView;
    }

    private void initView(View view){
        mTimerView = (TimerView)view.findViewById(R.id.timer_view);
        mTimerView.setStartTime(1,30,10);
        mTimerView.setModel(Model.Timer);
        mTimerView.start();
    }




}

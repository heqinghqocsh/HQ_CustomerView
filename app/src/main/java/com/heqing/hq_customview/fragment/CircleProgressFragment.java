package com.heqing.hq_customview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heqing.hq_customview.R;

/**
 * Created by 何清 on 2016/6/4 0004.
 *
 * @description
 */
public class CircleProgressFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.circle_progress_fragment,null);
    }
}

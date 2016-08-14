package com.heqing.hq_customview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heqing.hq_customview.R;

/**
 * Created by 何清 on 2016/6/9 0009.
 *
 * @description
 */
public class SurfaceViewTestFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.surface_view_test_laout,null);
    }
}

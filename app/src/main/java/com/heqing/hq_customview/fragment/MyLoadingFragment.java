package com.heqing.hq_customview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heqing.hq_customview.R;

/**
 * Created by HeQing on 2016/8/14 0014.
 */
public class MyLoadingFragment extends Fragment{



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.loading_fragment_layout,null);
        return rootView;
    }






}

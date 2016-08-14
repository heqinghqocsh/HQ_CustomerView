package com.heqing.hq_customview.fragment;

import android.graphics.drawable.Animatable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.heqing.hq_customview.R;

/**
 * Created by 何清 on 2016/6/10 0010.
 *
 * @description
 */
public class AnimatedVectorTestFragment extends Fragment{

    private ImageView imageView;
    private ImageView imageView2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vector_test_layout,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageView = (ImageView)view.findViewById(R.id.vector_image);
        imageView2 = (ImageView)view.findViewById(R.id.vector_image_2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Animatable) imageView.getDrawable()).start();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Animatable) imageView2.getDrawable()).start();
            }
        });

    }
}

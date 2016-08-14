package com.heqing.hq_customview.draw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.heqing.hq_customview.R;

/**
 * Created by 何清 on 2016/6/7 0007.
 *
 * @description
 */
public class ChangeImageEffect extends Fragment implements SeekBar.OnSeekBarChangeListener{

    private static int MAX_VALUE = 255;
    private static int MID_VALUE = 127;
    private ImageView mImageView;
    private SeekBar mSeekBarHue,mSeekBarSaturation,mSeekBarLum;
    private float mHue,mSaturation,mLum;
    private Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.change_image_effect_layout,null);
        mImageView = (ImageView)view.findViewById(R.id.imageview);
        mSeekBarHue = (SeekBar)view.findViewById(R.id.seekbar_hue);
        mSeekBarSaturation = (SeekBar)view.findViewById(R.id.seekbar_saturation);
        mSeekBarLum = (SeekBar)view.findViewById(R.id.seekbar_lum);

        bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.a);

        mSeekBarHue.setOnSeekBarChangeListener(this);
        mSeekBarSaturation.setOnSeekBarChangeListener(this);
        mSeekBarLum.setOnSeekBarChangeListener(this);

        mSeekBarHue.setMax(MAX_VALUE);
        mSeekBarLum.setMax(MAX_VALUE);
        mSeekBarSaturation.setMax(MAX_VALUE);

        mSeekBarHue.setProgress(MID_VALUE);
        mSeekBarLum.setProgress(MID_VALUE);
        mSeekBarSaturation.setProgress(MID_VALUE);

        mImageView.setImageBitmap(bitmap);
        return view;
    }


    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        switch (seekBar.getId()){
            case R.id.seekbar_hue:
                mHue = (progress - MID_VALUE)*1.0f / MID_VALUE * 180;
                break;
            case R.id.seekbar_lum:
                mLum = progress * 1.0f / MID_VALUE;
                break;
            case R.id.seekbar_saturation:
                mSaturation = progress * 1.0f / MID_VALUE;
                break;
        }
        mImageView.setImageBitmap(ImageHelper.handleImageEffect(bitmap,
                mHue,mSaturation,mLum));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}

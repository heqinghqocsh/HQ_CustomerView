package com.heqing.hq_customview.fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.customer_view.ElasticListView;

/**
 * Created by 何清 on 2016/6/4 0004.
 *
 * @description
 */
public class ElasticListFragment extends Fragment{

    private ElasticListView mElasticListView;
    private Toolbar mToolbar;
    private int mTouchSlop;
    private float mFirstY;
    private float mCurrentY;
    private int direction;
    private ObjectAnimator mAnimator;
    private boolean mShow = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.elastic_list_view_fragment,null);
        mElasticListView = (ElasticListView)view.findViewById(R.id.elastic_listview);
        mToolbar = (Toolbar)view.findViewById(R.id.toolbar);
        mTouchSlop = ViewConfiguration.get(getActivity()).getScaledTouchSlop();
        initAdapter();
        return view;
    }

    private void initAdapter(){
        String[] array = new String[50];
        for(int i = 0;i < array.length;i++){
            array[i] = "第"+i+"个";
        }
        mElasticListView.setAdapter(new ArrayAdapter<String>(getActivity(),R.layout.elastic_list_item,
                R.id.show_text,array));
        mElasticListView.setOnTouchListener(touchListener);
    }

    View.OnTouchListener touchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    mFirstY = event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    mCurrentY = event.getY();
                    if (mCurrentY - mFirstY > mTouchSlop){
                        direction = 0;//down
                    }else if(mFirstY - mCurrentY > mTouchSlop){
                        direction = 1;//up
                    }
                    if (direction == 1){
                        if (mShow){
                            toolbarAnim(1);
                            mShow = !mShow;
                        }
                    }else if(direction == 0){
                        if (!mShow){
                            toolbarAnim(0);
                            mShow = !mShow;
                        }
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    break;
            }
            return false;
        }
    };

    private void toolbarAnim(int flag){
        if (mAnimator != null && mAnimator.isRunning()){
            mAnimator.cancel();
        }
        if (flag == 0){
            mAnimator = ObjectAnimator.ofFloat(mToolbar
                    ,"translationY",mToolbar.getTranslationY(),0);
            Log.i("DEBUG",mToolbar.getTranslationY()+"");
        }else{
            mAnimator = ObjectAnimator.ofFloat(mToolbar,"translationY"
                    ,mToolbar.getTranslationY(),-mToolbar.getHeight());
            Log.i("DEBUG",mToolbar.getTranslationY()+"::"+-mToolbar.getHeight());
        }
        mAnimator.start();
    }





}

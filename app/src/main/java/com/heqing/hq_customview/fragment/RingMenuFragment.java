package com.heqing.hq_customview.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.utils.MyUtils;

/**
 * Created by 何清 on 2016/5/28 0028.
 *
 * @description  环形旋转菜单
 */
public class RingMenuFragment extends Fragment implements View.OnClickListener{

    private ImageView mIconMenu;
    private ImageView mIconHome;

    private RelativeLayout mLevel1;
    private RelativeLayout mLevel2;
    private RelativeLayout mLevel3;

    private boolean isLevel3Visible = true;
    private boolean isLevel2Visible = true;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.ring_menu_layout,null);

        mLevel1 = (RelativeLayout)rootView.findViewById(R.id.level1);
        mLevel2 = (RelativeLayout)rootView.findViewById(R.id.level2);
        mLevel3 = (RelativeLayout)rootView.findViewById(R.id.level3);

        mIconHome = (ImageView)rootView.findViewById(R.id.icon_home);
        mIconMenu = (ImageView)rootView.findViewById(R.id.icon_menu);
        mIconHome.setOnClickListener(this);
        mIconMenu.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.icon_menu:
                if (isLevel3Visible){
                    MyUtils.startAnimOut(mLevel3,0);
                }else{
                    MyUtils.startAnimIn(mLevel3);
                }
                isLevel3Visible = !isLevel3Visible;
                break;
            case R.id.icon_home:
                if (isLevel2Visible){
                    MyUtils.startAnimOut(mLevel2,0);
                    if (isLevel3Visible){
                        MyUtils.startAnimOut(mLevel3,100);
                        isLevel3Visible = false;
                    }
                }else{
                    MyUtils.startAnimIn(mLevel2);
                }
                isLevel2Visible = !isLevel2Visible;
                break;
        }
    }
}

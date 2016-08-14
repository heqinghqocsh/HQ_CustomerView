package com.heqing.hq_customview.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.customer_view.HorizontalScrollViewEx;
import com.heqing.hq_customview.customer_view.HorizontalScrollViewEx2;
import com.heqing.hq_customview.customer_view.ListViewEx;
import com.heqing.hq_customview.utils.MyUtils;

import java.util.ArrayList;

/**
 * Created by 何清 on 2016/6/17 0017.
 *
 * @description 解决滑动冲突1
 */
public class SlideConflict_2 extends Fragment {
    private static final String TAG = "SlideConflict_2";

    private HorizontalScrollViewEx2 mListContainer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.slide_conflict_2_layout, null);
        initView(rootView);
        return rootView;
    }

    private void initView(View rootView) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        mListContainer = (HorizontalScrollViewEx2) rootView.findViewById(R.id.slide_conflict_2_container);
        final int screenWidth = MyUtils.getScreenMetrics(getActivity()).widthPixels;
        final int screenHeight = MyUtils.getScreenMetrics(getActivity()).heightPixels;
        ViewGroup layout = null;
        TextView textView = null;
        for (int i = 0; i < 5; i++) {
            layout = (ViewGroup) inflater.inflate(R.layout.content_layout2
                    , mListContainer, false);
            layout.getLayoutParams().width = screenWidth;
            textView = (TextView) layout.findViewById(R.id.title);
            textView.setText("第 " + (i + 1) + " 页");
            layout.setBackgroundColor(Color.rgb(255 / (i + 1), 255 / (i + 1), 0));
            createList(layout);
            mListContainer.addView(layout);
        }
    }

    private void createList(ViewGroup layout){
        ListViewEx listView = (ListViewEx)layout.findViewById(R.id.list);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0;i < 100;i++){
            datas.add("第 " + (i + 1) + " 项");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity()
                ,R.layout.content_list_item_layout,R.id.item,datas);
        listView.setAdapter(adapter);
        listView.setHorizontalScrollViewEx2(mListContainer);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"点击 "+position,Toast.LENGTH_SHORT).show();
            }
        });
    }


}

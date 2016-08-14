package com.heqing.hq_customview.fragment;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.adapter.ChatItemListViewAdapter;
import com.heqing.hq_customview.customer_view.ChatItemListViewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何清 on 2016/6/5 0005.
 *
 * @description
 */
public class ChatItemListFragment extends Fragment{

    private ListView mChatListView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.chat_item_fragment,null);
        mChatListView = (ListView)view.findViewById(R.id.listview_chat);
        initData();
        return view;
    }

    private void initData(){
        ChatItemListViewBean bean1 = new ChatItemListViewBean();
        bean1.setType(0);
        bean1.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.a));
        bean1.setText("Hello how are you!");

        ChatItemListViewBean bean2 = new ChatItemListViewBean();
        bean2.setType(1);
        bean2.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.a));
        bean2.setText("Hello how are you!");

        ChatItemListViewBean bean3 = new ChatItemListViewBean();
        bean3.setType(0);
        bean3.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.a));
        bean3.setText("Hello how are you!");

        ChatItemListViewBean bean4 = new ChatItemListViewBean();
        bean4.setType(1);
        bean4.setIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.a));
        bean4.setText("Hello how are you!");

        List<ChatItemListViewBean> data = new ArrayList<>();
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        data.add(bean1);
        data.add(bean2);
        data.add(bean3);
        data.add(bean4);
        data.add(bean1);
        data.add(bean1);
        mChatListView.setAdapter(new ChatItemListViewAdapter(getActivity(),data));
    }



}

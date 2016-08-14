package com.heqing.hq_customview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.customer_view.ChatItemListViewBean;

import java.util.List;

/**
 * Created by 何清 on 2016/6/5 0005.
 *
 * @description
 */
public class ChatItemListViewAdapter extends BaseAdapter{

    private List<ChatItemListViewBean> mData;
    private LayoutInflater mInflater;

    public ChatItemListViewAdapter(Context context,List<ChatItemListViewBean> data){
        mInflater = LayoutInflater.from(context);
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return mData.get(position).getType();
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            if (getItemViewType(position) == 0){
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.chat_item_in,null);
                viewHolder.icon = (ImageView)convertView.findViewById(R.id.icon_in);
                viewHolder.msg = (TextView)convertView.findViewById(R.id.in_msg);
            }else{
                viewHolder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.chat_item_out,null);
                viewHolder.icon = (ImageView)convertView.findViewById(R.id.icon_out);
                viewHolder.msg = (TextView)convertView.findViewById(R.id.out_msg);
            }
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.icon.setImageBitmap(mData.get(position).getIcon());
        viewHolder.msg.setText(mData.get(position).getText());
        return convertView;
    }

    public final class ViewHolder{
        ImageView icon;
        TextView msg;
    }
}

package com.heqing.hq_customview.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.heqing.hq_customview.R;
import com.heqing.hq_customview.customer_view.PinnedHeaderExpandableListView;
import com.heqing.hq_customview.customer_view.StickyLayout;
import com.heqing.hq_customview.model.Group;
import com.heqing.hq_customview.model.People;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 何清 on 2016/6/18 0018.
 *
 * @description
 */
public class StickyLayoutTestFragment extends Fragment
        implements PinnedHeaderExpandableListView.OnHeaderUpdateListener,
        ExpandableListView.OnChildClickListener,
        ExpandableListView.OnGroupClickListener,
        StickyLayout.OnGiveUpTouchEventListener{

    private PinnedHeaderExpandableListView expandableListView;
    private StickyLayout stickyLayout;
    private ArrayList<Group> groupList;
    private ArrayList<List<People>> peopleList;

    private MyExpandableListAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.sticky_layout,null);
        return rootView;
    }

    @Override
    public void onViewCreated(View rootView, @Nullable Bundle savedInstanceState) {
        expandableListView = (PinnedHeaderExpandableListView)rootView.findViewById(R.id.expandablelist);
        stickyLayout = (StickyLayout)rootView.findViewById(R.id.sticky_layout);
        initData();

        adapter = new MyExpandableListAdapter(getActivity());
        expandableListView.setAdapter(adapter);

        for (int i = 0,count = expandableListView.getCount();i < count;i++){
            expandableListView.expandGroup(i);
        }
        expandableListView.setOnHeaderUpdateListener(this);
        expandableListView.setOnChildClickListener(this);
        expandableListView.setOnGroupClickListener(this);
        stickyLayout.setOnGiveUpTouchEventListener(this);
    }

    private void initData(){
        groupList = new ArrayList<>();
        Group group = null;
        for(int i = 0;i < 10;i++){
            group = new Group("group--"+i);
            groupList.add(group);
        }
        peopleList = new ArrayList<>();
        ArrayList<People> tmp;
        int count = 0;
        People people;
        for (int i = 0;i < groupList.size();i++){
            tmp = new ArrayList<>();
            count = 2*(i+1);
            for(int j = 0;j < count;j++){
                people = new People("hh--"+j,"十堰--"+j,j+1);
                tmp.add(people);
            }
            peopleList.add(tmp);
        }
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        Toast.makeText(getContext()
                ,peopleList.get(groupPosition).get(childPosition).getName()
                ,Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean giveUpTouchEvent(MotionEvent event) {
        if (expandableListView.getFirstVisiblePosition() == 0){
            View view = expandableListView.getChildAt(0);
            if (view != null && view.getTop() >= 0){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        return false;
    }

    @Override
    public View getPinnedHeader() {
        View headerView = (ViewGroup)getActivity()
                .getLayoutInflater().inflate(R.layout.group,null);
        headerView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        return headerView;
    }

    @Override
    public void updatePinnedHeader(View headerView, int firstVisibleGroupPos) {
        Group firstVisibleGroup = (Group)adapter.getGroup(firstVisibleGroupPos);
        TextView textView = (TextView)headerView.findViewById(R.id.group);
        textView.setText(firstVisibleGroup.getTitle());
    }

    class MyExpandableListAdapter extends BaseExpandableListAdapter{
        private Context context;
        private LayoutInflater inflater;

        public MyExpandableListAdapter(Context context) {
            this.context = context;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getGroupCount() {
            return groupList.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return peopleList.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groupList.get(groupPosition);
        }


        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return peopleList.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupHolder groupHolder = null;
            if (convertView == null){
                groupHolder = new GroupHolder();
                convertView = inflater.inflate(R.layout.group,null);
                groupHolder.textView = (TextView)convertView.findViewById(R.id.group);
                groupHolder.imageView = (ImageView)convertView.findViewById(R.id.imageview);
                convertView.setTag(groupHolder);
            }else{
                groupHolder = (GroupHolder)convertView.getTag();
            }
            groupHolder.textView.setText(
                    ((Group)(getGroup(groupPosition))).getTitle());
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildHolder childHolder = null;
            if (convertView == null){
                childHolder = new ChildHolder();
                convertView = inflater.inflate(R.layout.child,null);
                childHolder.textName = (TextView)convertView.findViewById(R.id.name);
                childHolder.textAge = (TextView)convertView.findViewById(R.id.age);
                childHolder.textAddress = (TextView)convertView.findViewById(R.id.address);
                childHolder.imageView = (ImageView)convertView.findViewById(R.id.image);
                convertView.setTag(childHolder);
            }else{
                childHolder = (ChildHolder)convertView.getTag();
            }
            People people = (People)getChild(groupPosition,childPosition);
            childHolder.textName.setText(people.getName());
            childHolder.textAge.setText(people.getAge()+"");
            childHolder.textAddress.setText(people.getAddress());
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

    class GroupHolder{
        TextView textView;
        ImageView imageView;
    }

    class ChildHolder{
        TextView textName;
        TextView textAge;
        TextView textAddress;
        ImageView imageView;
    }
}

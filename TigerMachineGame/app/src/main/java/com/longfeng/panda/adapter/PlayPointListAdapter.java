package com.longfeng.panda.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;

import com.longfeng.panda.R;

import java.util.ArrayList;

/**
 * Created by WuJingCheng
 * on 2018/2/13.
 */
public class PlayPointListAdapter extends BaseAdapter{
    private ArrayList<String> data = new ArrayList<>();
    public PlayPointListAdapter() {
        data.add("");data.add("");data.add("");data.add("");data.add("");
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_start_lv_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Animation animation = new TranslateAnimation(-1000, Animation.RELATIVE_TO_SELF, 0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(true);//设置为true，动画转化结束后被应用
        convertView.startAnimation(animation);//开始动画
        return convertView;
    }
    private class ViewHolder{
        public ViewHolder(View view) {
        }
    }
}

package com.longfeng.panda.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.longfeng.panda.R;
import com.longfeng.panda.bean.LoginBean;

import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */

public class HomeGridAdapter extends BaseAdapter{
    List<LoginBean.DataBean.RateTypeListBean> data;
    private int width;
    public HomeGridAdapter(List<LoginBean.DataBean.RateTypeListBean> data, int width) {
        this.data = data;
        this.width = width;
    }

    public int getCount() {
        return data.size();
    }

    @Override
    public LoginBean.DataBean.RateTypeListBean getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_grid_item,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LoginBean.DataBean.RateTypeListBean rateTypeListBean = getItem(position);
        viewHolder.mTvName.setText(rateTypeListBean.getRtName());
       LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) viewHolder.mImgBg.getLayoutParams();
       layoutParams.height = (width-20)/4;
        viewHolder.mImgBg.setLayoutParams(layoutParams);
        return convertView;
    }
    private class ViewHolder {
        private TextView mTvName;
        private ImageView mImgBg;
        public ViewHolder(View view) {
            mImgBg = (ImageView) view.findViewById(R.id.img_home_item);
            mTvName = (TextView) view.findViewById(R.id.tv_home_item);
        }
    }
}

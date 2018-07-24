package com.longfeng.panda.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.longfeng.panda.R;
import com.longfeng.panda.bean.RoomSeatBean;
import com.longfeng.panda.view.CountdownTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WuJingCheng
 * on 2018/2/8.
 */
public class HouseAdapter extends BaseAdapter{
    private CountdownTextView.OnTimeClearListner onTimeClearListner;
    private List<RoomSeatBean.DataBean.MachineListBean> data;
    public HouseAdapter(ArrayList<RoomSeatBean.DataBean.MachineListBean> data,CountdownTextView.OnTimeClearListner onTimeClearListner) {
        this.data = data;
        this.onTimeClearListner = onTimeClearListner;
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    public void setData( List<RoomSeatBean.DataBean.MachineListBean> list){
        data.clear();
        data.addAll(list);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view==null){
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lay_house_item,null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        RoomSeatBean.DataBean.MachineListBean machineListBean = data.get(i);
        int status = machineListBean.getStatus();
        viewHolder.mTvTime.stop();
        if(status==0){//无人
            viewHolder.mImgSeat.setBackgroundResource(R.mipmap.seat_no);
            viewHolder.mTvTime.setVisibility(View.INVISIBLE);
            viewHolder.mTvName.setVisibility(View.INVISIBLE);
        }else if(status==2){//在线
            viewHolder.mImgSeat.setBackgroundResource(R.mipmap.seat_man);
            viewHolder.mTvTime.setVisibility(View.INVISIBLE);
            viewHolder.mTvName.setVisibility(View.VISIBLE);
            String name = machineListBean.getMachineOfUserVo().getUName();
            viewHolder.mTvName.setText(name==null?"未知":name);
        }else {//留机
            viewHolder.mImgSeat.setBackgroundResource(R.mipmap.seat_girl);
            viewHolder.mTvTime.setVisibility(View.VISIBLE);
            long time = machineListBean.getMachineOfUserVo().getKeepTime();
            viewHolder.mTvTime.init(null,time,onTimeClearListner);
            viewHolder.mTvTime.start(i);
            viewHolder.mTvName.setVisibility(View.VISIBLE);
            String name = machineListBean.getMachineOfUserVo().getUName();
            viewHolder.mTvName.setText(name==null?"未知":name);
        }
//        viewHolder.mTvSeatNum.setText(machineListBean.getMId()+"");
        viewHolder.mTvSeatNum.setText(i+1+"");
        return view;
    }
    private class ViewHolder{
        private TextView mTvSeatNum;
        private TextView mTvName;
        private ImageView mImgSeat;
        private CountdownTextView mTvTime;
        public ViewHolder(View view) {
            mImgSeat = (ImageView) view.findViewById(R.id.img_seat);
            mTvSeatNum = (TextView) view.findViewById(R.id.tv_seatnum);
            mTvName = (TextView) view.findViewById(R.id.tv_house_name);
            mTvTime = (CountdownTextView) view.findViewById(R.id.tv_house_time);
        }
    }
}

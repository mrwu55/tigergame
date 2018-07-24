package com.longfeng.panda.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.longfeng.panda.R;
import com.longfeng.panda.bean.PlayBean;
import com.longfeng.panda.bean.ResultBean;
import com.longfeng.panda.thread.ThreadHold;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WuJingCheng
 * on 2018/2/9.
 */
public class PlayAdapter extends BaseAdapter{
    private List<PlayBean.DataBean.RateListBean> data;
    private ResultBean.DataBean.BetRecordBean betRecordBean;
    private int bet =1;
    private int rtId =0;
    private boolean isClear = false;
    private boolean isBig = false;
    private OnScoreClearListner onScoreClearListner;
    private  ArrayList<TextView> listBig = new ArrayList<>();
    private String holdTitle = "";
    private  ThreadHold threadHold;
    private TextView mTvTilteHold;
    int  titleCorlor;
    int  nameCorlor ;
    int colorRed;
    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 14:
                    if(!"".equals(holdTitle)){
                        mTvTilteHold.setTextColor( Color.TRANSPARENT);
                    }
                    break;
                case 15:
                    if(!"".equals(holdTitle)){
                        mTvTilteHold.setTextColor(colorRed);
                    }
                    break;
            }
        }
    };
    public PlayAdapter(List<PlayBean.DataBean.RateListBean> data,
                       OnScoreClearListner onScoreClearListner,Context context) {
        this.data = data;
        this.onScoreClearListner = onScoreClearListner;
          titleCorlor =context.getResources().getColor(R.color.c83b8e9);
          nameCorlor = context.getResources().getColor(R.color.c70bbb49);
        colorRed = context.getResources().getColor(R.color.e6231d);
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
    public void setData(ResultBean.DataBean.BetRecordBean betRecordBean,boolean isBig){
        this.betRecordBean = betRecordBean;
        this.isBig = isBig;
        if(!"".equals(holdTitle)){
            threadHold.stop();
            holdTitle = "";
            mTvTilteHold.setTextColor(titleCorlor);
        }
        if(betRecordBean==null){
            this.isClear = false;
            this.isBig = false;
            this.bet = 1;
        }
            this.rtId = 0;
        notifyDataSetChanged();
    }
    public void setBet(int bet){
        this.bet = bet;
        notifyDataSetChanged();
    }
    public void setRtId(int rtId,String holdTitle){
        this.holdTitle = holdTitle;
        this.rtId = rtId;
        notifyDataSetChanged();
    }
    public void setIsClear(boolean flag){
        this.isClear = flag;
        listBig.clear();
        notifyDataSetChanged();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        Context context = parent.getContext();
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.lay_play_lv_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(position!=parent.getChildCount()){
            return convertView;
        }
        PlayBean.DataBean.RateListBean rateListBean = data.get(data.size()-position-1);
        List<PlayBean.DataBean.RateListBean.RateVosBean> rateVosBeans = rateListBean.getRateVos();
        String title = rateListBean.getCbnEnName();
        String nameA = (rateVosBeans.get(2).getRateValue())*bet + "";
        String nameB = (rateVosBeans.get(1).getRateValue())*bet + "";
        String nameC = (rateVosBeans.get(0).getRateValue())*bet + "";
        if(rtId!=0){
            switch (rtId){
                case 3:
                    viewHolder.mTvPointA.setTextColor(colorRed);
                    break;
                case 2:
                    viewHolder.mTvPointB.setTextColor(colorRed);
                    break;
                case 1:
                    viewHolder.mTvPointC.setTextColor(colorRed);
                    break;
            }
        }else {
            viewHolder.mTvTitle.setTextColor(titleCorlor);
            viewHolder.mTvPointA.setTextColor(nameCorlor);
            viewHolder.mTvPointB.setTextColor(nameCorlor);
            viewHolder.mTvPointC.setTextColor(nameCorlor);
        }
        if(!"".equals(holdTitle)){
            if(holdTitle.equals(viewHolder.mTvTitle.getText().toString())){
                mTvTilteHold = viewHolder.mTvTitle;
                threadHold = new ThreadHold(mHandler);
                new Thread(threadHold).start();
            }
        }
        TextView mTvRed = null;
        boolean isClearData = false;
        boolean isClearLuckyData = false;
        int rId =0;
            if (betRecordBean != null) {
                 String titleLuky = betRecordBean.getCbn();
                 rId = betRecordBean.getRt();
                mTvRed = viewHolder.listTextView.get(rId-1);
                viewHolder.mTvTitle.setTextColor(colorRed);
                mTvRed.setTextColor(colorRed);
                    if(!title.equals(titleLuky)){
                        switch (titleLuky){
                            case "5.K":
                                if(!("4.K".equals(title)||"3.K".equals(title))){
                                    isClearData = true;
                                    mTvRed = null;
                                }else {
                                    isClearLuckyData = true;
                                }
                                break;
                            case "4.K":
                                if(!"3.K".equals(title)){
                                    isClearData = true;
                                    mTvRed = null;
                                }else {
                                    isClearLuckyData = true;
                                }
                                break;
                            case "R.S":
                                if(!("F.L".equals(title)||
                                        "S.T".equals(title))){
                                    isClearData = true;
                                    mTvRed = null;
                                }else {
                                    isClearLuckyData = true;
                                }
                                break;
                            case "S.F":
                                if(!("F.L".equals(title)|| "S.T".equals(title))){
                                    isClearData = true;
                                    mTvRed = null;
                                }else {
                                    isClearLuckyData = true;
                                }
                                break;
                                default:
                                    isClearData = true;
                                    mTvRed = null;
                                    break;
                        }
                    }else {
                        isClearLuckyData = true;
                    }
            }
            if(isClearData){
                viewHolder.listTextView.get(rId-1).setTextColor(nameCorlor);
                nameA = "0";
                nameB = "0";
                nameC = "0";
                viewHolder.mTvTitle.setTextColor(titleCorlor);
            }
            if(isClearLuckyData){
                switch (rId){
                    case 3:
                        nameB = "0";
                        nameC = "0";
                        break;
                    case 2:
                        nameA = "0";
                        nameC = "0";
                        break;
                    case 1:
                        nameA = "0";
                        nameB = "0";
                        break;
                }
            }
        viewHolder.mTvTitle.setText(title);
        viewHolder.mTvPointA.setText(nameA);
        viewHolder.mTvPointB.setText(nameB);
        viewHolder.mTvPointC.setText(nameC);
        if(isClear){
            if(mTvRed!=null){
                listBig.add(mTvRed);
            }
            if(position==9){
                isClear = false;
                onScoreClearListner.onScoreClearViews(listBig,isBig);
            }
        }
        return convertView;
    }
    private class ViewHolder{
        private TextView mTvTitle,mTvPointA,mTvPointB,mTvPointC;
        private ArrayList<TextView> listTextView = new ArrayList<>();
        public ViewHolder(View view) {
            mTvTitle = (TextView) view.findViewById(R.id.tv_point_title);
            mTvPointA = (TextView) view.findViewById(R.id.tv_point_a);
            mTvPointB = (TextView) view.findViewById(R.id.tv_point_b);
            mTvPointC = (TextView) view.findViewById(R.id.tv_point_c);
            listTextView.add(mTvPointC);
            listTextView.add(mTvPointB);
            listTextView.add(mTvPointA);
        }
    }
    public interface OnScoreClearListner{
        void onScoreClearViews(ArrayList<TextView> listBig,boolean isBig);
    }
}

package com.blyy.game.tigermachinegame.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.activity.App;
import com.blyy.game.tigermachinegame.adapter.HouseAdapter;
import com.blyy.game.tigermachinegame.bean.PlayBean;
import com.blyy.game.tigermachinegame.bean.RoomSeatBean;
import com.blyy.game.tigermachinegame.util.OkHttpUtils;
import com.blyy.game.tigermachinegame.util.ToastUtil;
import com.blyy.game.tigermachinegame.view.RegistDialog;

import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;

/**
 * Created by WuJingCheng on 2018/5/25.
 */

public class ChooseSeatFragment extends BaseFragment implements
        AdapterView.OnItemClickListener,View.OnClickListener{
    private GridView mGridView;
    private Button mBtnBack;
    private TextView mTvRoom,mTvName,mTvMoney;
    private RegistDialog registDialog;
    private HouseAdapter adapter;
    private List<RoomSeatBean.DataBean.MachineListBean> data;
    private String rtId = null;
    private boolean isStop = false;
    private String gameStatus;
    private boolean isClick = false;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0://请求所有座位
                    isStop = false;
                    RoomSeatBean roomSeatBean = (RoomSeatBean) msg.obj;
                    if (roomSeatBean == null) return;
                    int status = roomSeatBean.getStatus();
                    if (status == 1) {
                        data = roomSeatBean.getData().getMachineList();
                        adapter.setData(data);
                        return;
                    }
                    ToastUtil.toast(getContext(),roomSeatBean.getMsg());
                    if(status==3){
                        setBackPosition(0);
                    }
                    break;
                case 1://点击座位
                    PlayBean playBean = (PlayBean) msg.obj;
                    if(playBean==null) return;
                    isClick = false;
                    int erroCode = playBean.getStatus();
                    if(erroCode==1){
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("playBean",playBean);
                        showFragment(bundle,3);
                    }else if(erroCode==2){//有留机
                        try {
                            String title = playBean.getData().getMessage();
                            gameStatus = playBean.getData().getGameStatus();
                            setChooseDialog(title);
                        }catch (Exception e){
                            ToastUtil.toast(getContext(),"数据错误");
                        }
                    }else {
                        ToastUtil.toast(getContext(),playBean.getMsg());
                        if(erroCode==3){
                            setBackPosition(0);
                        }
                    }
                    break;
                case 2:
                    PlayBean joinBean = (PlayBean) msg.obj;
                    if(joinBean==null) return;
                    if(joinBean.getStatus()==1){
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("playBean",joinBean);
                        showFragment(bundle,3);
                    }else {
                        ToastUtil.toast(getContext(),joinBean.getMsg());
                        if(joinBean.getStatus()==3){
                            setBackPosition(0);
                        }
                    }
                    break;
            }
        }
    };

    public static ChooseSeatFragment newInstance(Bundle bundle) {
        ChooseSeatFragment fragment = new ChooseSeatFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected int setView() {
        return R.layout.activity_choose_house;
    }

    @Override
    protected void init(View view) {
        mBtnBack = (Button) view.findViewById(R.id.btn_choose_back);
        mTvName = (TextView) view.findViewById(R.id.tv_choose_name);
        mTvRoom = (TextView) view.findViewById(R.id.tv_choose_room);
        mTvMoney = (TextView) view.findViewById(R.id.tv_choose_money);
        String room;
        String name;
        String money;
        try {
            Bundle bundle = getArguments();
            if(bundle!=null){
                room = bundle.getString("roomName");
                name = bundle.getString("useName");
                money = bundle.getString("money");
                rtId = bundle.getString("rtId");
                mTvName.setText(name);
                mTvRoom.setText(room);
                mTvMoney.setText("当前余额："+money);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        mBtnBack.setOnClickListener(this);
        mGridView = (GridView) view.findViewById(R.id.house_gridView);
        adapter = new HouseAdapter(new ArrayList<RoomSeatBean.DataBean.MachineListBean>());
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(this);
        if(rtId!=null) {
            OkHttpUtils.getData(getActivity(), Constans.GETSEAT, new FormBody.Builder().
                    add("rtId", rtId).build(), RoomSeatBean.class, handler, 0);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(!isClick){
            App.getApp().playBtn();
            isClick = true;
            String mId = data.get(position).getMId()+"";
            OkHttpUtils.getData(getActivity(), Constans.STARTGAME,new FormBody.Builder().add("mId",mId).build(), PlayBean.class,handler,1);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            if(Constans.gold!=null){
                mTvMoney.setText("当前余额："+Constans.gold);
            }
                OkHttpUtils.getData(getActivity(), Constans.GETSEAT, new FormBody.Builder().
                        add("rtId", rtId).build(), RoomSeatBean.class, handler, 0);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_choose_back:
                App.getApp().playBtn();
                setBackPosition(2);
                break;
            case R.id.btn_exit_sure:
                registDialog.dismiss();
                OkHttpUtils.getData(getActivity(), Constans.JOINLIVE,
                        new FormBody.Builder().add("gameStatus",gameStatus).build(),
                        PlayBean.class,handler,2);
                break;
            case R.id.btn_exit_cancel:
                registDialog.dismiss();
                break;
        }
    }

    @Override
    public boolean onBackPressed() {
        setBackPosition(2);
        return true;
    }

    private void setChooseDialog(String msg){
        if(registDialog==null){
            registDialog = new RegistDialog(getContext());
        }
        registDialog.show();
        Window window = registDialog.getWindow() ;
        window.setContentView(R.layout.exit_tips);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.re_dialog_exit);
        Button buttonSure = (Button) window.findViewById(R.id.btn_exit_sure);
        Button buttonCancel = (Button) window.findViewById(R.id.btn_exit_cancel);
        TextView tvTitle = (TextView) window.findViewById(R.id.tv_join_title);
        tvTitle.setText(msg);
        buttonSure.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        Display display =getActivity().getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();              //使用这种方式更改了dialog的框高
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();                     //使用这种方式更改了dialog的框宽
        window.setAttributes(params);
    }
}

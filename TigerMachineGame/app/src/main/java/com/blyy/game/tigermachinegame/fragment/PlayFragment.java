package com.blyy.game.tigermachinegame.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.activity.App;
import com.blyy.game.tigermachinegame.adapter.PlayAdapter;
import com.blyy.game.tigermachinegame.bean.BigSmallBean;
import com.blyy.game.tigermachinegame.bean.EndBean;
import com.blyy.game.tigermachinegame.bean.ExitBean;
import com.blyy.game.tigermachinegame.bean.PlayBean;
import com.blyy.game.tigermachinegame.bean.ResultBean;
import com.blyy.game.tigermachinegame.bean.StartBean;
import com.blyy.game.tigermachinegame.bean.ThanTimeBean;
import com.blyy.game.tigermachinegame.bean.UpScoreBean;
import com.blyy.game.tigermachinegame.thread.ThreadBS;
import com.blyy.game.tigermachinegame.thread.ThreadHold;
import com.blyy.game.tigermachinegame.util.OkHttpUtils;
import com.blyy.game.tigermachinegame.util.PlayGameNetWorkUtil;
import com.blyy.game.tigermachinegame.util.ToastUtil;
import com.blyy.game.tigermachinegame.view.RegistDialog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import pl.droidsonroids.gif.GifImageView;

/**
 * Created by WuJingCheng on 2018/5/25.
 */

public class PlayFragment extends BaseFragment implements
        View.OnClickListener,
        View.OnLongClickListener, View.OnTouchListener ,PlayAdapter.OnScoreClearListner{
    private TextView mTvCredit, mTvHold, mTvMachineName, mTvMachineGold, mTvBet;
    private ThreadHold threadHold;
    private ThreadBS threadBS;
    private PlayBean playBean;
    private Button mBtnAddBet,mBtnOn,mBtnDown,mBtnBegain,mBtnKeepMachine;
    int soundAdd,soundWin,
            soundLoss,soundOpen,soundSmallBig,soundBsSuccess,soundBsGetAll;
    int soundDo,soundRe,soundMi,soundFa,soundSo;
    private SoundPool soundPool;
    private boolean OnClick;
    private int deletteBet;
    private int interval;
    private TextView  mTvNumA, mTvNumB, mTvNumC, mTvNumD;
    private ListView mListPoint;
    private LinearLayout mLlBrand;
    private boolean isFirstLogin;
    private ImageView mImgA, mImgB, mImgC, mImgD, mImgE;
    private ImageView mHoldA, mHoldB, mHoldC, mHoldD, mHoldE;
    private boolean isFirstBegain = true;
    private List<StartBean.DataBean.OnePokerListBean> onePokerListBean;
    private boolean holdA, holdB, holdC, holdD, holdE;
    private Button mBtnBack,mBtnRecord;
    private PlayAdapter playAdapter;
    private LinearLayout mLlBs;
    private ImageView mImgBsA,mImgBsB,mImgBsC,mImgBsD,mImgBsE,mImgBsF,mImgBsNo;
    private int brandWidth;
    private View viewA,viewB;
    private boolean isCompare;
    private ThanTimeBean thanTimeBean;
    private GifImageView gifA,gifB,gifC,gifD,gifE,gifStart,jtA,jtB,jtC;
    private TextView mTvGifA,mTvGifB,mTvGifC,mTvGifD,mTvGifE,mTvGifF;
    private  int betIntegral;
    private RegistDialog exitDialog;
    private int betCount = 1;
    private boolean addScore = true;
    private int bets,betsLast;
    private boolean isFist = true;
    private  int getAllId = -1,winId=-1,successId = -1,soundgetId = -1;
    private List<Integer> holdPokerIndex;
    private TextView mTvTipBig,mTvTipSamll;
    private int colorNormal;
    private int colorChange;
    private int colorDouble;
    private int colorGetS;
    private int getIntegral;
    private ArrayList<Integer> holdIndex = new ArrayList<>();
    private String mId;
    private MediaPlayer mediaPlayer;
    private TextView mTvClearScore;
    private boolean isDouble = false;
    private int clearScore;
    //得分时赢的分数
    private int scoreGet;
    private String bigTitle;
    private boolean isBig = false;
    private TextView mTvBbS;
    private TextView mTvClearA,mTvClearB,mTvClearC;
    private int clearAScore,clearBScore,clearCScore;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            try {
                switch (msg.what) {
                    case 0://开始
                        StartBean startBean = (StartBean) msg.obj;
                        if (startBean == null) return;
                        int code = startBean.getStatus();
                        if (code == 1) {
                            mBtnBack.setEnabled(false);
                            mBtnRecord.setEnabled(false);
                            int rtId = startBean.getData().getRtId();
                            playAdapter.setRtId(rtId,startBean.getData().getHoldCbn());
                            mTvCredit.setText(interval-bets+"");
                            onePokerListBean = startBean.getData().getOnePokerList();
                            holdPokerIndex = startBean.getData().getHoldPokerIndex();
                            if (onePokerListBean != null && onePokerListBean.size() > 4) {
                                StartBean.DataBean.OnePokerListBean onePokerListBeanA = onePokerListBean.get(0);
                                StartBean.DataBean.OnePokerListBean onePokerListBeanB = onePokerListBean.get(1);
                                StartBean.DataBean.OnePokerListBean onePokerListBeanC = onePokerListBean.get(2);
                                StartBean.DataBean.OnePokerListBean onePokerListBeanD = onePokerListBean.get(3);
                                StartBean.DataBean.OnePokerListBean onePokerListBeanE = onePokerListBean.get(4);
                                final String typA = onePokerListBeanA.getPointNum() + onePokerListBeanA.getCtId();
                                final String typB = onePokerListBeanB.getPointNum() + onePokerListBeanB.getCtId();
                                final String typC = onePokerListBeanC.getPointNum() + onePokerListBeanC.getCtId();
                                final String typD = onePokerListBeanD.getPointNum() + onePokerListBeanD.getCtId();
                                final String typE = onePokerListBeanE.getPointNum() + onePokerListBeanE.getCtId();
                                soundPool.play(soundOpen, 1.0f, 1.0f, 999, 0, 1);
                                setData(mImgA, typA,100);
                                setData(mImgB, typB,200);
                                setData(mImgC, typC,300);
                                setData(mImgD, typD,400);
                                setData(mImgE, typE,500);
                                setBrandCilckBle(true);
                                mTvHold.setText("PUSH HOLD");
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        setHold();
                                        mBtnBegain.setEnabled(true);
                                    }
                                },800);
                            }
                        } else {
                            String errorMessage = startBean.getMsg() == null ? "数据错误！" : startBean.getMsg();
                            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                            if(code==3){
                                setBackPosition(0);
                                return;
                            }
                            isFirstBegain = true;
                            mBtnBegain.setEnabled(true);
                            mBtnKeepMachine.setEnabled(true);
                            mBtnOn.setEnabled(true);
                            mBtnDown.setEnabled(true);
                            mBtnAddBet.setEnabled(true);
                        }
                        break;
                    case 1://上分
                        UpScoreBean upScoreBean = (UpScoreBean) msg.obj;
                        if (upScoreBean == null) return;
                        int status = upScoreBean.getStatus();
                        mBtnOn.setEnabled(true);
                        mBtnBegain.setEnabled(true);
                        if (status == 1) {
                            interval = upScoreBean.getData().getBetRecord().getIntegral();
                            int gold = upScoreBean.getData().getUser().getUGold();
                            String bet = mTvBet.getText().toString();
                            int bets = 0;
                            if(bet!=null){
                                bets = Integer.parseInt(bet);
                            }
                            mTvCredit.setText(interval-bets + "");
                            mTvMachineGold.setText("金币：" + gold);
                        } else {
                            String errorMessage = upScoreBean.getMsg() == null ? "下分失败！" : upScoreBean.getMsg();
                            Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
                            if(status==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 2://比倍
                        thanTimeBean = (ThanTimeBean) msg.obj;
                        if(thanTimeBean==null) return;
                        int thantimesCode = thanTimeBean.getStatus();
                        threadHold.stop();
                        mTvHold.setVisibility(View.INVISIBLE);
                        if(thantimesCode==1){
                            if(betCount==1) {
                                gifA.setBackgroundResource(R.mipmap.bet_bg);
                                gifB.setBackgroundResource(R.mipmap.bet_bg);
                                gifC.setBackgroundResource(R.mipmap.bet_bg);
                                gifD.setBackgroundResource(R.mipmap.bet_bg);
                                gifE.setBackgroundResource(R.mipmap.bet_bg);
                                jtA.setBackgroundResource(R.mipmap.play_b_right);
                                jtB.setBackgroundResource(R.mipmap.play_b_right);
                                jtC.setBackgroundResource(R.mipmap.play_b_right);
                                mTvBbS = mTvGifB;
                                mTvGifC.setTextColor(getResources().getColor(R.color.black));
                                mTvGifD.setTextColor(getResources().getColor(R.color.black));
                                mTvGifE.setTextColor(getResources().getColor(R.color.black));
                                mTvGifF.setTextColor(getResources().getColor(R.color.black));
                                List<ThanTimeBean.DataBean.RateTypeListBean> rateTypeListBeen = thanTimeBean.getData().getRateTypeList();
                                int rateA = Integer.parseInt(rateTypeListBeen.get(0).getBili());
                                int rateB = Integer.parseInt(rateTypeListBeen.get(1).getBili());
                                int rateC = Integer.parseInt(rateTypeListBeen.get(2).getBili());
                                int rateD = Integer.parseInt(rateTypeListBeen.get(3).getBili());
                                int rateE = Integer.parseInt(rateTypeListBeen.get(4).getBili());
                                int rateF = Integer.parseInt(rateTypeListBeen.get(5).getBili());
                                mTvGifA.setText(betIntegral * rateA + "");
                                mTvGifB.setText(betIntegral * rateB + "");
                                mTvGifC.setText(betIntegral * rateC + "");
                                mTvGifD.setText(betIntegral * rateD + "");
                                mTvGifE.setText(betIntegral * rateE + "");
                                mTvGifF.setText(betIntegral * rateF + "");
                                threadBS = new ThreadBS(handler);
                                new Thread(threadBS).start();
                            }
                            //比大小
                            initBigOrSmall();
                        }else {
                            mBtnAddBet.setEnabled(true);
                            mBtnBegain.setEnabled(true);
                            Toast.makeText(getContext(), thanTimeBean.getMsg(), Toast.LENGTH_SHORT).show();
                            if(thantimesCode==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 3://下分
                        UpScoreBean downScoreBean = (UpScoreBean) msg.obj;
                        if (downScoreBean == null) return;
                        int error = downScoreBean.getStatus();
                        if (error == 1) {
                            interval = downScoreBean.getData().getBetRecord().getIntegral();
                            int gold = downScoreBean.getData().getUser().getUGold();
                            mTvCredit.setText(interval + "");
                            mTvMachineGold.setText("金币：" + gold);
                            playAdapter.setBet(1);
                            mBtnAddBet.setEnabled(true);
                            mTvBet.setText("0");
                        } else {
                            String errorMessage = downScoreBean.getMsg() == null ? "下分失败！" : downScoreBean.getMsg();
                            ToastUtil.toast(getContext(),errorMessage);
                            if(error==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 4://结果
                        ResultBean resultBean = (ResultBean) msg.obj;
                        if(resultBean==null) return;
                        int erroCode = resultBean.getStatus();
                        if(erroCode==1){
                            interval = resultBean.getData().getBetRecord().getIntegral();
                            int dataStatus = resultBean.getData().getStatus();
                            ResultBean.DataBean.MachineBean machineBean = resultBean.getData().getMachine();
                            List<ResultBean.DataBean.TwoPokerListBean> twoPokerListBean = resultBean.getData().getTwoPokerList();
                            holdA = false;
                            holdB = false;
                            holdC = false;
                            holdD = false;
                            holdE  = false;
                            if(holdIndex.size()>0){
                                for (Integer i:holdIndex){
                                    ResultBean.DataBean.TwoPokerListBean twoPokerListBean1 = twoPokerListBean.get(i);
                                    String pId = twoPokerListBean1.getPointNum()+twoPokerListBean1.getCtId();
                                    ImageView mImgBrand = null;
                                    switch (i){
                                        case 0:
                                            mImgBrand = mImgA;
                                            break;
                                        case 1:
                                            mImgBrand = mImgB;
                                            break;
                                        case 2:
                                            mImgBrand = mImgC;
                                            break;
                                        case 3:
                                            mImgBrand = mImgD;
                                            break;
                                        case 4:
                                            mImgBrand = mImgE;
                                            break;
                                    }
                                    setData(mImgBrand, pId,0);
                                }
                            }
                            String numA = machineBean.getTotalOf5k() + "";
                            String numB = machineBean.getTotalOfRs() + "";
                            String numC = machineBean.getTotalOfSf() + "";
                            String numD = machineBean.getTotalOf4k() + "";
                            mTvNumA.setText(numA);
                            mTvNumB.setText(numB);
                            mTvNumC.setText(numC);
                            mTvNumD.setText(numD);
                            if(dataStatus==1){
                                getIntegral = resultBean.getData().getBetRecord().getGetIntegral();
                                betIntegral = resultBean.getData().getBetRecord().getGetIntegral();
                                bigTitle =resultBean.getData().getBetRecord().getCbn();
                                switch (bigTitle){
                                    case "5.K":
                                    case "4.K":
                                    case "R.S":
                                    case "S.F":
                                        if(mediaPlayer==null){
                                            mediaPlayer = App.getApp().getMediaPlayer();
                                        }
                                        isBig = true;
                                        isCompare = true;
                                        playAdapter.setData(resultBean.getData().getBetRecord(),true);
                                        PlayGameNetWorkUtil.getData(getActivity(), Constans.GETSCORE, new FormBody.Builder().build(),
                                                EndBean.class, handler, 6);
                                        mediaPlayer.start();//开始播放
                                        return;
                                    default:
                                        winId = soundPool.play(soundWin, 1.0f, 1.0f, 999, -1, 1);
                                        break;
                                }
                                playAdapter.setData(resultBean.getData().getBetRecord(),false);
                                mBtnAddBet.setText("比倍");
                                mBtnBegain.setText("得分");
                                colorNormal = colorDouble;
                                colorChange = colorGetS;
                                isCompare = true;
                                mBtnAddBet.setEnabled(true);
                                mBtnOn.setEnabled(false);
                                mBtnDown.setEnabled(false);
                                mBtnBegain.setEnabled(true);
                            }else {
                                mTvHold.setVisibility(View.INVISIBLE);
                                isFirstBegain = true;
                                mBtnBack.setEnabled(true);
                                mBtnRecord.setEnabled(true);
                                soundPool.play(soundLoss, 1.0f, 1.0f, 999, 0, 1);
                                playAdapter.setData(null,false);
                                betsLast = Integer.parseInt(mTvBet.getText().toString());
                                mTvBet.setText("0");
                                mTvCredit.setText(resultBean.getData().getBetRecord().getIntegral()+"");
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        mTvHold.setText("PUSH BET");
                                        mTvHold.setVisibility(View.VISIBLE);
                                        reSetBrand();
                                    }
                                },1500);
                            }
                        }else {
                            String errorMessage = resultBean.getMsg() == null ? "数据错误！" : resultBean.getMsg();
                            ToastUtil.toast(getContext(),errorMessage);
                            if(erroCode==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 5://比大小返回结果
                        BigSmallBean bigSmallBean = (BigSmallBean) msg.obj;
                        if(bigSmallBean==null) return;
//                        threadBS.stop();
                        mTvTipSamll.setVisibility(View.INVISIBLE);
                        mTvTipBig.setVisibility(View.INVISIBLE);
                        if(bigSmallBean.getStatus()==1){
                            String type = bigSmallBean.getData().getPoker().getPointNum()+bigSmallBean.getData().getPoker().getCtId();
                            setData(mImgBsNo,type,0);
                            if(bigSmallBean.getData().getStatus()==1){
                                getIntegral = bigSmallBean.getData().getBetRecord().getGetIntegral();
                                successId =  soundPool.play(soundBsSuccess, 1.0f, 1.0f, 999, 0, 1);
                                mBtnAddBet.setEnabled(true);
                                mBtnBegain.setEnabled(true);
                                mBtnOn.setEnabled(false);
                                mBtnDown.setEnabled(false);
                                betCount++;
                                switch (betCount){
                                    case 2:
                                        mTvBbS = mTvGifC;
                                        jtA.setBackgroundResource(R.drawable.bibeidongtu);
                                        gifA.setBackgroundResource(R.drawable.play_gif);
                                        mTvGifB.setTextColor(getResources().getColor(R.color.e6231d));
                                        break;
                                    case 3:
                                        mTvBbS = mTvGifD;
                                        gifB.setBackgroundResource(R.drawable.play_gif);
                                        mTvGifC.setTextColor(getResources().getColor(R.color.e6231d));
                                        break;
                                    case 4:
                                        mTvBbS = mTvGifE;
                                        jtB.setBackgroundResource(R.drawable.bibeidongtu);
                                        gifC.setBackgroundResource(R.drawable.play_gif);
                                        mTvGifD.setTextColor(getResources().getColor(R.color.e6231d));
                                        break;
                                    case 5: mTvBbS = mTvGifF;

                                        jtC.setBackgroundResource(R.drawable.bibeidongtu);
                                        gifD.setBackgroundResource(R.drawable.play_gif);
                                        mTvGifE.setTextColor(getResources().getColor(R.color.e6231d));
                                        break;
                                    case 6:
                                        gifE.setBackgroundResource(R.drawable.play_gif);
                                        mTvGifF.setTextColor(getResources().getColor(R.color.e6231d));
                                        break;
                                }
                                if(betCount>5){//得分
                                    mBtnAddBet.setEnabled(false);
                                    mBtnBegain.setEnabled(false);
                                    PlayGameNetWorkUtil.getData(getActivity(), Constans.GETSCORE, new FormBody.Builder().build(),
                                            EndBean.class, handler, 6);
                                }
                            }else {
                                betCount=1;
                                soundPool.play(soundLoss, 1.0f, 1.0f, 999, 0, 1);
                                interval = bigSmallBean.getData().getBetRecord().getIntegral();
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        //重新开始游戏
                                        initStartGame();
                                    }
                                },2000);

                            }
                        }else {
                            ToastUtil.toast(getContext(),bigSmallBean.getMsg());
                            if(bigSmallBean.getStatus()==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 6://得分
                        EndBean endBean = (EndBean) msg.obj;
                        if(endBean==null) return;
                        threadHold.stop();
                        threadBS.stop();
                        mTvTipBig.setVisibility(View.INVISIBLE);
                        mTvTipSamll.setVisibility(View.INVISIBLE);
                        mTvHold.setVisibility(View.INVISIBLE);
                        if(endBean.getStatus()==1){
                            scoreGet = endBean.getData().getBetRecord().getIntegral();
                            Log.e("得分",scoreGet+"");
                            EndBean.DataBean.BetRecordBean.UsersVoBean.MachineVoBean machineVoBean = endBean.getData().getBetRecord().getUsersVo().getMachineVo();
                            String numA = machineVoBean.getTotalOf5k() + "";
                            String numB = machineVoBean.getTotalOfRs() + "";
                            String numC = machineVoBean.getTotalOfSf() + "";
                            String numD = machineVoBean.getTotalOf4k() + "";
                            mTvNumA.setText(numA);
                            mTvNumB.setText(numB);
                            mTvNumC.setText(numC);
                            mTvNumD.setText(numD);
                            addScore = true;
                            if(!isDouble){
                                playAdapter.setIsClear(true);
                                return;
                            }
                            getAllId = soundPool.play(soundBsGetAll, 1.0f, 1.0f, 999, -1, 1);
                            getScore();
                        }else {
                            ToastUtil.toast(getContext(),endBean.getMsg());
                            if(endBean.getStatus()==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 7://退出
                        ExitBean exitBean = (ExitBean) msg.obj;
                        if(exitBean==null) return;
                        if(exitBean.getStatus()==1){
                            Constans.gold = exitBean.getData().getuGold()+"";
                            setBackPosition(3);
                        }else {
                            ToastUtil.toast(getContext(),exitBean.getMsg());
                            if(exitBean.getStatus()==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 8://留机
                        BigSmallBean baseBean = (BigSmallBean) msg.obj;
                        if(baseBean.getStatus()==1){
                            setBackPosition(3);
                        }else {
                            ToastUtil.toast(getContext(),baseBean.getMsg());
                            if(baseBean.getStatus()==3){
                                setBackPosition(0);
                            }
                        }
                        break;
                    case 11:
                        mTvCredit.setText(deletteBet + "");
                        mTvBet.setText(interval - deletteBet + "");
                        playAdapter.setBet(interval - deletteBet);
                        break;
                    case 12:
                        mTvCredit.setText(deletteBet + "");
                        int addScores = interval - deletteBet;
                        mTvBet.setText(addScores+ "");
                        playAdapter.setBet(addScores==0?1:addScores);
                        ToastUtil.toast(getContext(),"分数不足,清先上分！");
                        break;
                    case 13:
                        mTvCredit.setText(interval + "");
                        if(isDouble){
                            clearScore(getIntegral--);
                            return;
                        }
                        mTvClearScore.setText(clearScore--+"");
                        break;
                    case 14://hold闪烁文字颜色
                        if(colorNormal==colorDouble){
                            mTvHold.setText("DOUBLE");
                        }
                        mTvHold.setTextColor(colorNormal);
                        break;
                    case 15://hold闪烁文字颜色
                        if(colorChange==colorGetS){
                            mTvHold.setText("GET SCORE");
                        }
                        mTvHold.setTextColor(colorChange);
                        break;
                    case 16://押分长按大于500
                        mBtnAddBet.setEnabled(false);
                         ToastUtil.toast(getContext(),"上分数不能大于500!");
                        break;
                    case 17://比倍闪烁
                        mTvBbS.setTextColor(getResources().getColor(R.color.black));
                        mTvTipBig.setTextColor(Color.TRANSPARENT);
                        mTvTipSamll.setTextColor(getResources().getColor(R.color.small));
                        break;
                    case 18://比倍闪烁
                        mTvBbS.setTextColor(getResources().getColor(R.color.e6231d));
                        mTvTipSamll.setTextColor(Color.TRANSPARENT);
                        mTvTipBig.setTextColor(getResources().getColor(R.color.big));
                        break;
                    case 19://比倍得分
                        if(isDouble){
                            clearScore(0);
                        }else {
                            mTvClearScore.setText("0");
                        }
                            getResetScore();
                        break;
                    case 20:
                        mTvClearScore.setText("0");
                        mTvClearA.setText("0");
                        mTvClearB.setText("0");
                        if(mTvClearC!=null){
                            mTvClearC.setText("0");
                        }
                        getResetScore();
                        break;
                    case 21://中大奖加分
                        mTvClearScore.setText(clearScore<=0?"0":clearScore--+"");
                        mTvClearA.setText(clearAScore<=0?"0":clearAScore--+"");
                        mTvClearB.setText(clearBScore<=0?"0":clearBScore--+"");
                        if(mTvClearC==null) return;
                        mTvClearC.setText(clearCScore<=0?"0":clearCScore--+"");
                        break;
                    case 617://网络错误
                        int typeCode = msg.arg1;
                        switch (typeCode){
                            case 1:
                                mBtnOn.setEnabled(true);
                                mBtnBegain.setEnabled(true);
                                break;
                            case 2://比倍接口
                                mBtnAddBet.setEnabled(true);
                                mBtnBegain.setEnabled(true);
                                break;
                            case 5://大小选择接口
                                mBtnOn.setEnabled(true);
                                mBtnDown.setEnabled(true);
                                break;
                            case 6://得分接口
                                mBtnBegain.setEnabled(true);
                                if(isBig){
                                    mBtnBegain.setText("得分");
                                    return;
                                }
                                mBtnAddBet.setEnabled(true);
                                break;
                            case 0://开始游戏第一次接口
                                isFirstBegain = true;
                                mBtnBegain.setEnabled(true);
                                mBtnKeepMachine.setEnabled(true);
                                mBtnOn.setEnabled(true);
                                mBtnDown.setEnabled(true);
                                mBtnAddBet.setEnabled(true);
                                break;
                            case 4:
                                mBtnBegain.setEnabled(true);
                                break;
                        }
                        break;
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    };

    public static PlayFragment newInstance(Bundle bundle) {
        PlayFragment fragment = new PlayFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        initVoic();
    }
    private void initVoic(){
        soundPool = App.getApp().getSoundPool();
        new Thread(new Runnable() {
            @Override
            public void run() {
                soundAdd = soundPool.load(getContext(), R.raw.add, 1);
                soundWin = soundPool.load(getContext(), R.raw.win, 1);
                soundLoss = soundPool.load(getContext(), R.raw.loss, 1);
                soundOpen = soundPool.load(getContext(), R.raw.open_brand, 1);
                soundSmallBig = soundPool.load(getContext(), R.raw.small_big, 1);
                soundBsSuccess = soundPool.load(getContext(), R.raw.success, 1);
                soundBsGetAll = soundPool.load(getContext(), R.raw.addall, 1);
                soundDo = soundPool.load(getContext(), R.raw.dos, 1);
                soundRe = soundPool.load(getContext(), R.raw.re, 1);
                soundMi = soundPool.load(getContext(), R.raw.mi, 1);
                soundFa = soundPool.load(getContext(), R.raw.fa, 1);
                soundSo = soundPool.load(getContext(), R.raw.so, 1);
            }
        }).start();
    }
    @Override
    protected int setView() {
        return R.layout.activity_play;
    }

    @Override
    protected void init(View view) {
        colorNormal = Color.TRANSPARENT;
        colorChange = getResources().getColor(R.color.f2eb34);
        colorDouble = getResources().getColor(R.color.p_double);
        colorGetS = getResources().getColor(R.color.getscore);
        viewA = view.findViewById(R.id.lay_lay_a);
        viewB = view.findViewById(R.id.lay_lay_b);
        jtA = view.findViewById(R.id.img_bb_jta);
        jtB = view.findViewById(R.id.img_bb_jta);
        jtC = view.findViewById(R.id.img_bb_jta);
        mTvTipBig = (TextView) view.findViewById(R.id.tv_play_big);
        mTvTipSamll = (TextView) view.findViewById(R.id.tv_play_small);
        gifStart = (GifImageView) view.findViewById(R.id.img_play_startbg);
        mLlBrand = (LinearLayout) view.findViewById(R.id.ll_brand);
        mTvNumA = (TextView) view.findViewById(R.id.tv_a_macode_a);
        mTvNumB = (TextView) view.findViewById(R.id.tv_a_macode_b);
        mTvNumC = (TextView) view.findViewById(R.id.tv_a_macode_c);
        mTvNumD = (TextView) view.findViewById(R.id.tv_a_macode_d);
        mTvHold = (TextView) view.findViewById(R.id.tv_a_hold);
        mImgA = (ImageView) view.findViewById(R.id.img_brand_a);
        mImgB = (ImageView) view.findViewById(R.id.img_brand_b);
        mImgC = (ImageView) view.findViewById(R.id.img_brand_c);
        mImgD = (ImageView) view.findViewById(R.id.img_brand_d);
        mImgE = (ImageView) view.findViewById(R.id.img_brand_e);
        mHoldA = (ImageView) view.findViewById(R.id.img_hold_a);
        mHoldB = (ImageView) view.findViewById(R.id.img_hold_b);
        mHoldC = (ImageView) view.findViewById(R.id.img_hold_c);
        mHoldD = (ImageView) view.findViewById(R.id.img_hold_d);
        mHoldE = (ImageView) view.findViewById(R.id.img_hold_e);
        mLlBs = (LinearLayout) view.findViewById(R.id.ll_big_small);
        mImgBsNo = (ImageView) view.findViewById(R.id.img_bigsmall_no);
        mImgBsA = (ImageView) view.findViewById(R.id.img_bigsamll_a);
        mImgBsB = (ImageView) view.findViewById(R.id.img_bigsamll_b);
        mImgBsC = (ImageView) view.findViewById(R.id.img_bigsamll_c);
        mImgBsD = (ImageView) view.findViewById(R.id.img_bigsamll_d);
        mImgBsE = (ImageView) view.findViewById(R.id.img_bigsamll_e);
        mImgBsF = (ImageView) view.findViewById(R.id.img_bigsamll_f);
        gifA = (GifImageView) view.findViewById(R.id.gif_a);
        gifB = (GifImageView) view.findViewById(R.id.gif_b);
        gifC = (GifImageView) view.findViewById(R.id.gif_c);
        gifD = (GifImageView) view.findViewById(R.id.gif_d);
        gifE = (GifImageView) view.findViewById(R.id.gif_e);
        mTvGifA = (TextView) view.findViewById(R.id.tv_bet_one);
        mTvGifB = (TextView) view.findViewById(R.id.tv_bet_two);
        mTvGifC = (TextView) view.findViewById(R.id.tv_bet_five);
        mTvGifD = (TextView) view.findViewById(R.id.tv_bet_fift);
        mTvGifE = (TextView) view.findViewById(R.id.tv_bet_twty);
        mTvGifF = (TextView) view.findViewById(R.id.tv_bet_thun);
        mImgA.setOnClickListener(this);
        mImgB.setOnClickListener(this);
        mImgC.setOnClickListener(this);
        mImgD.setOnClickListener(this);
        mImgE.setOnClickListener(this);
        setBrandCilckBle(false);
        mTvCredit = (TextView) view.findViewById(R.id.tv_a_interval);
        mTvMachineName = (TextView) view.findViewById(R.id.tv_a_machine_name);
        mTvMachineGold = (TextView) view.findViewById(R.id.tv_a_machine_gold);
        mTvBet = (TextView) view.findViewById(R.id.tv_a_bet);
        mBtnAddBet = view.findViewById(R.id.btn_a_addbet);
        mBtnKeepMachine =  view.findViewById(R.id.btn_a_keepmachine);
        mBtnOn =  view.findViewById(R.id.btn_a_on);
        mBtnDown =  view.findViewById(R.id.btn_a_down);
        mBtnBegain =  view.findViewById(R.id.btn_a_begain);
        mListPoint = (ListView) view.findViewById(R.id.lv_play_point);
        mBtnBack = (Button) view.findViewById(R.id.btn_play_back);
        mBtnRecord = (Button) view.findViewById(R.id.btn_play_record);
        mBtnAddBet.setOnClickListener(this);
        mBtnKeepMachine.setOnClickListener(this);
        mBtnOn.setOnClickListener(this);
        mBtnDown.setOnClickListener(this);
        mBtnBack.setOnClickListener(this);
        mBtnRecord.setOnClickListener(this);
        mBtnBegain.setOnClickListener(this);
        mBtnAddBet.setOnLongClickListener(this);
        mBtnAddBet.setOnTouchListener(this);
        threadHold = new ThreadHold(handler);
        threadBS = new ThreadBS(handler);
        new Thread(threadHold).start();
        Bundle bundle = getArguments();
        playBean = (PlayBean) bundle.getSerializable("playBean");
        if (playBean != null && playBean.getData() != null && playBean.getData().getRateList() != null) {
            try {
                List<PlayBean.DataBean.RateListBean> rateListBeen = playBean.getData().getRateList();
                playAdapter = new PlayAdapter(rateListBeen,this,getContext());
                mListPoint.setAdapter(playAdapter);
                interval = playBean.getData().getIntegral();
                mId = playBean.getData().getMachineVo().getMId()+"";
                PlayBean.DataBean.MachineVoBean  machineVoBean =  playBean.getData().getMachineVo();
                String machineName = machineVoBean.getMCode();
                String gold = playBean.getData().getUGold() + "";
                String numA = machineVoBean.getTotalOf5k() + "";
                String numB = machineVoBean.getTotalOfRs() + "";
                String numC = machineVoBean.getTotalOfSf() + "";
                String numD = machineVoBean.getTotalOf4k() + "";
                mTvNumA.setText(numA);
                mTvNumB.setText(numB);
                mTvNumC.setText(numC);
                mTvNumD.setText(numD);
                mTvCredit.setText(interval + "");
                mTvMachineName.setText(machineName);
                mTvMachineGold.setText("金币：" + gold);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        ViewTreeObserver observer = view.getViewTreeObserver();
        observer.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setBrandLayoutParams();
            }
        });
    }
    private void setData(final ImageView view, final String type, final long delayed) {
        int bg = App.getApp().getBrandSoruce(type);
        if (bg != -1) {
            if(delayed==0){
                view.setBackgroundResource(bg);
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.back_scale);
                view.startAnimation(animation);
                return;
            }
            final int finalBg = bg;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.setBackgroundResource(finalBg);
                    Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.back_scale);
                    view.startAnimation(animation);
                }
            },delayed);

        }
    }
    private void setHold(){
        if(holdPokerIndex==null) return;
        for (int i=0;i<holdPokerIndex.size();i++){
            int code = holdPokerIndex.get(i);
            switch (code){
                case 0:
                    mHoldA.setVisibility(View.VISIBLE);
                    holdA = true;
                    break;
                case 1:
                    mHoldB.setVisibility(View.VISIBLE);
                    holdB = true;
                    break;
                case 2:
                    mHoldC.setVisibility(View.VISIBLE);
                    holdC = true;
                    break;
                case 3:
                    mHoldD.setVisibility(View.VISIBLE);
                    holdD = true;
                    break;
                case 4:
                    mHoldE.setVisibility(View.VISIBLE);
                    holdE = true;
                    break;
            }
        }
    }
    //比大小初始化
    private void initBigOrSmall(){
        isDouble = true;
        soundPool.play(soundSmallBig, 1.0f, 1.0f, 999, 0, 1);
        mBtnAddBet.setEnabled(false);
        mBtnOn.setEnabled(true);
        mBtnDown.setEnabled(true);
        mBtnBegain.setEnabled(true);
        viewA.setVisibility(View.INVISIBLE);
        mLlBrand.clearAnimation();
        mLlBrand.setVisibility(View.INVISIBLE);
        viewB.setVisibility(View.VISIBLE);
        mLlBs.setVisibility(View.VISIBLE);
        mBtnOn.setText("大");
        mBtnDown.setText("小");
        mTvTipSamll.setVisibility(View.VISIBLE);
        mTvTipBig.setVisibility(View.VISIBLE);
        int magin = brandWidth / 2 ;
        LinearLayout.LayoutParams linearParams = (LinearLayout.LayoutParams) mImgBsNo.getLayoutParams();
        linearParams.width = brandWidth;
        mImgBsNo.setLayoutParams(linearParams);
        RelativeLayout.LayoutParams layoutParamsA = (RelativeLayout.LayoutParams) mImgBsA.getLayoutParams();
        layoutParamsA.width = brandWidth;
        mImgBsA.setLayoutParams(layoutParamsA);
        RelativeLayout.LayoutParams layoutParamsB = (RelativeLayout.LayoutParams) mImgBsB.getLayoutParams();
        layoutParamsB.width = brandWidth;
        layoutParamsB.setMargins(magin, 0, 0, 0);
        mImgBsB.setLayoutParams(layoutParamsB);

        RelativeLayout.LayoutParams layoutParamsC = (RelativeLayout.LayoutParams) mImgBsC.getLayoutParams();
        layoutParamsC.width = brandWidth;
        layoutParamsC.setMargins(magin * 2, 0, 0, 0);
        mImgBsC.setLayoutParams(layoutParamsC);

        RelativeLayout.LayoutParams layoutParamsD = (RelativeLayout.LayoutParams) mImgBsD.getLayoutParams();
        layoutParamsD.width = brandWidth;
        layoutParamsD.setMargins(magin * 3, 0, 0, 0);
        mImgBsD.setLayoutParams(layoutParamsD);

        RelativeLayout.LayoutParams layoutParamsE = (RelativeLayout.LayoutParams) mImgBsE.getLayoutParams();
        layoutParamsE.width = brandWidth;
        layoutParamsE.setMargins(magin * 4, 0, 0, 0);
        mImgBsE.setLayoutParams(layoutParamsE);

        RelativeLayout.LayoutParams layoutParamsF = (RelativeLayout.LayoutParams) mImgBsF.getLayoutParams();
        layoutParamsF.width = brandWidth;
        layoutParamsF.setMargins(magin * 5, 0, 0, 0);
        mImgBsF.setLayoutParams(layoutParamsF);
        List<ThanTimeBean.DataBean.PokerListBean> pokerListBeen = thanTimeBean.getData().getPokerList();
        ThanTimeBean.DataBean.PokerListBean pokerListBeanA = pokerListBeen.get(0);
        ThanTimeBean.DataBean.PokerListBean pokerListBeanB = pokerListBeen.get(1);
        ThanTimeBean.DataBean.PokerListBean pokerListBeanC = pokerListBeen.get(2);
        ThanTimeBean.DataBean.PokerListBean pokerListBeanD = pokerListBeen.get(3);
        ThanTimeBean.DataBean.PokerListBean pokerListBeanE = pokerListBeen.get(4);
        ThanTimeBean.DataBean.PokerListBean pokerListBeanF = pokerListBeen.get(5);
        String typeA = pokerListBeanA.getPointNum()+pokerListBeanA.getCtId();
        String typeB = pokerListBeanB.getPointNum()+pokerListBeanB.getCtId();
        String typeC = pokerListBeanC.getPointNum()+pokerListBeanC.getCtId();
        String typeD = pokerListBeanD.getPointNum()+pokerListBeanD.getCtId();
        String typeE = pokerListBeanE.getPointNum()+pokerListBeanE.getCtId();
        String typeF = pokerListBeanF.getPointNum()+pokerListBeanF.getCtId();
        setData(mImgBsA,typeA,0); setData(mImgBsB,typeB,0);
        setData(mImgBsC,typeC,0); setData(mImgBsD,typeD,0);
        setData(mImgBsE,typeE,0); setData(mImgBsF,typeF,0);
    }
    //重新开始游戏初始化
    private void initStartGame(){
        betCount=1;
        isDouble = false;
        isFirstBegain = true;
        mBtnBack.setEnabled(true);
        mBtnRecord.setEnabled(true);
        int nowBet = Integer.parseInt(mTvBet.getText().toString());
        betsLast = nowBet==0?betsLast:nowBet;
        mTvBet.setText("0");
        mTvHold.setText("PUSH BET");
        colorNormal = Color.TRANSPARENT;
        colorChange =getResources().getColor(R.color.f2eb34);
        mTvHold.setVisibility(View.VISIBLE);
        threadBS.stop();
        mTvTipSamll.setVisibility(View.INVISIBLE);
        mTvTipBig.setVisibility(View.INVISIBLE);
        threadHold = new ThreadHold(handler);
        new Thread(threadHold).start();
        viewA.setVisibility(View.VISIBLE);
        mLlBrand.clearAnimation();
        mLlBrand.setVisibility(View.VISIBLE);
        viewB.setVisibility(View.INVISIBLE);
        mLlBs.setVisibility(View.INVISIBLE);
        mBtnDown.setText("下分");
        mBtnOn.setText("上分");
        mBtnAddBet.setText("押倍");
        mBtnBegain.setText("开始");
        reSetBrand();
        setBrandCilckBle(false);
        playAdapter.setData(null,false);
        isCompare = false;
    }
    private void reSetBrand(){
        mBtnOn .setEnabled(true);
        mBtnDown.setEnabled(true);
        mBtnBegain.setEnabled(true);
        mBtnKeepMachine.setEnabled(true);
        mBtnAddBet.setEnabled(true);
        mImgA.setBackgroundResource(R.mipmap.play_no_p);
        mImgB.setBackgroundResource(R.mipmap.play_no_p);
        mImgC.setBackgroundResource(R.mipmap.play_no_p);
        mImgD.setBackgroundResource(R.mipmap.play_no_p);
        mImgE.setBackgroundResource(R.mipmap.play_no_p);
    }
    private void setBrandCilckBle(boolean flag) {
        if(!flag){
            holdA = false;
            holdB = false;
            holdC = false;
            holdD =false;
            holdE = false;
        }
        mImgA.setClickable(flag);
        mImgB.setClickable(flag);
        mImgC.setClickable(flag);
        mImgD.setClickable(flag);
        mImgE.setClickable(flag);
    }
    @Override
    public void onResume() {
        super.onResume();
        if (isFirstLogin) return;
        gifStart.setBackgroundResource(R.drawable.start_gif);
//        App.getApp().getMediaPlayer().start();
        App.getApp().playInit();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_exit_sure:
                exitDialog.dismiss();
                soundPool.autoPause();
                OkHttpUtils.getData(getActivity(), Constans.EXIT, new FormBody.Builder().build(),
                        ExitBean.class, handler, 7);
                break;
            case R.id.btn_exit_cancel:
                exitDialog.dismiss();
                break;
            case R.id.btn_a_addbet:
                if(isCompare){//比倍
                    soundPool.stop(winId);
                    soundPool.stop(successId);
                    mBtnAddBet.setEnabled(false);
                    mBtnBegain.setEnabled(false);
                    App.getApp().playBtn();
                    mImgBsNo.setBackgroundResource(R.mipmap.play_no_p);
                    PlayGameNetWorkUtil.getData(getActivity(), Constans.THAN_TIMES, new FormBody.Builder().build(),
                            ThanTimeBean.class, handler, 2);
                    return;
                }

                soundPool.play(soundAdd, 1.0f, 1.0f, 999, 0, 1);
                int credit = Integer.parseInt(mTvCredit.getText().toString());
                int betsAdd = Integer.parseInt(mTvBet.getText().toString());
                if (credit>0) {
                    int bet =0;
                    if(betsAdd==0){
                        if(credit<100){
                            ToastUtil.toast(getContext(),"分数不足，请先上分！");
                            return;
                        }
                        bet = 100;
                    }else {
                        bet = betsAdd + 1;
                    }
                    if(bet>500){
                        ToastUtil.toast(getContext(),"押分数不能大于500!");
                        mBtnAddBet.setEnabled(false);
                        return;
                    }
                    mTvCredit.setText(interval - bet + "");
                    mTvBet.setText(bet + "");
                    playAdapter.setBet(bet);
                } else {
                    ToastUtil.toast(getContext(),"分数不足，请先上分！");
                }
                break;
            case R.id.btn_a_keepmachine://留机
                PlayGameNetWorkUtil.getData(getActivity(), Constans.KEEPGAME, new FormBody.Builder().build(),
                        BigSmallBean.class, handler, 8);
                break;
            case R.id.btn_a_on://上分
                App.getApp().playBtn();
                if(isCompare){//大
                    mBtnBegain.setEnabled(false);
                    getBigorSmall("1");
                    return;
                }
                if(!isFirstLogin){
                    isFirstLogin = true;
                    startAnimBrand();
                }
                mBtnOn.setEnabled(false);
                mBtnBegain.setEnabled(false);
                PlayGameNetWorkUtil.getData(getActivity(), Constans.UPODOWN, new FormBody.Builder().add("type", "1").build(),
                        UpScoreBean.class, handler, 1);
                break;
            case R.id.btn_a_down://下分
                App.getApp().playBtn();
                if(isCompare){//小
                    mBtnBegain.setEnabled(false);
                    getBigorSmall("0");
                    return;
                }
                if(interval<100){
                    ToastUtil.toast(getContext(),"分数不足100无法下分！");
                    return;
                }
                PlayGameNetWorkUtil.getData(getActivity(), Constans.UPODOWN, new FormBody.Builder().add("type", "0").build(),
                        UpScoreBean.class, handler, 3);
                break;
            case R.id.btn_a_begain://开始
                if(isCompare){//得分
                    soundPool.autoPause();
                    mBtnAddBet.setEnabled(false);
                    mBtnOn.setEnabled(false);
                    mBtnDown.setEnabled(false);
                    mBtnBegain.setEnabled(false);
                    PlayGameNetWorkUtil.getData(getActivity(), Constans.GETSCORE, new FormBody.Builder().build(),
                            EndBean.class, handler, 6);
                    return;
                }
                if (isFirstBegain) {
                    bets = Integer.parseInt(mTvBet.getText().toString());
                    if(bets<=0){
                        if(betsLast==0&&interval>=100){
                            betsLast=100;
                        }
                        if(interval<100||interval-betsLast<0){
                            ToastUtil.toast(getContext(),"请先押分！");
                            return;
                        }
                        bets = betsLast;
                        playAdapter.setBet(bets);
                        mTvCredit.setText(interval-bets+"");
                        mTvBet.setText(bets+"");
                    }
                    mBtnBegain.setEnabled(false);
                    mBtnKeepMachine.setEnabled(false);
                    mBtnOn.setEnabled(false);
                    mBtnDown.setEnabled(false);
                    mBtnAddBet.setEnabled(false);
                    if(isFirstLogin){
                        startGame();
                        return;
                    }
                    isFirstLogin = true;
                    startAnimBrand();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startGame();
                        }
                    },1000);
                    return;
                }
                //第二次 开始
                startGameT();
                break;
            case R.id.img_brand_a:
                soundPool.play(soundDo, 1.0f, 1.0f, 999, 0, 1);
                if (holdA) {
                    mHoldA.setVisibility(View.INVISIBLE);
                } else {
                    mHoldA.setVisibility(View.VISIBLE);
                }
                holdA = !holdA;
                break;
            case R.id.img_brand_b:
                soundPool.play(soundRe, 1.0f, 1.0f, 999, 0, 1);
                if (holdB) {
                    mHoldB.setVisibility(View.INVISIBLE);
                } else {
                    mHoldB.setVisibility(View.VISIBLE);
                }
                holdB = !holdB;
                break;
            case R.id.img_brand_c:
                soundPool.play(soundMi, 1.0f, 1.0f, 999, 0, 1);
                if (holdC) {
                    mHoldC.setVisibility(View.INVISIBLE);
                } else {
                    mHoldC.setVisibility(View.VISIBLE);
                }
                holdC = !holdC;
                break;
            case R.id.img_brand_d:
                soundPool.play(soundFa, 1.0f, 1.0f, 999, 0, 1);
                if (holdD) {
                    mHoldD.setVisibility(View.INVISIBLE);
                } else {
                    mHoldD.setVisibility(View.VISIBLE);
                }
                holdD = !holdD;
                break;
            case R.id.img_brand_e:
                soundPool.play(soundSo, 1.0f, 1.0f, 999, 0, 1);
                if (holdE) {
                    mHoldE.setVisibility(View.INVISIBLE);
                } else {
                    mHoldE.setVisibility(View.VISIBLE);
                }
                holdE = !holdE;
                break;
            case R.id.btn_play_back:
                App.getApp().playBtn();
                if(interval>0){
                    setExitDialog();
                    return;
                }
                soundPool.autoPause();
                OkHttpUtils.getData(getActivity(), Constans.EXIT, new FormBody.Builder().build(),
                        ExitBean.class, handler, 7);
                break;
            case R.id.btn_play_record:
                App.getApp().playBtn();
                Bundle bundle = new Bundle();
                bundle.putString("mId",mId);
                showFragment(bundle,4);
                break;
        }
    }
    private void startAnimBrand(){
        Animation animation = new TranslateAnimation(-1000, Animation.RELATIVE_TO_SELF, 0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(true);//设置为true，动画转化结束后被应用
        gifStart.setVisibility(View.INVISIBLE);
        mLlBrand.setVisibility(View.VISIBLE);
        mLlBrand.startAnimation(animation);//开始动画
    }
    private void startGame(){
        isFirstBegain = false;
        PlayGameNetWorkUtil.getData(getActivity(), Constans.PLAYONE, new FormBody.Builder().
                        add("combiNum", "1").add("beTotal", bets + "").build(),
                StartBean.class, handler, 0);
    }
    /**
     * 第二次开始游戏
     * @return
     */
    private void startGameT(){
        mImgA.setClickable(false);
        mImgB.setClickable(false);
        mImgC.setClickable(false);
        mImgD.setClickable(false);
        mImgE.setClickable(false);
        mBtnBegain.setEnabled(false);
        String index = "";
        holdIndex.clear();
        if(holdA){
            index+="0,";
            mHoldA.setVisibility(View.INVISIBLE);
        }else {
            mImgA.setBackgroundResource(R.mipmap.play_no_p);
            holdIndex.add(0);
        }
        if(holdB){
            index+="1,";
            mHoldB.setVisibility(View.INVISIBLE);
        }else {
            mImgB.setBackgroundResource(R.mipmap.play_no_p);
            holdIndex.add(1);
        }
        if(holdC){
            index+="2,";
            mHoldC.setVisibility(View.INVISIBLE);
        }else {
            mImgC.setBackgroundResource(R.mipmap.play_no_p);
            holdIndex.add(2);
        }
        if(holdD){
            index+="3,";
            mHoldD.setVisibility(View.INVISIBLE);
        }else {
            mImgD.setBackgroundResource(R.mipmap.play_no_p);
            holdIndex.add(3);
        }
        if(holdE){
            index+="4,";
            mHoldE.setVisibility(View.INVISIBLE);
        }else {
            mImgE.setBackgroundResource(R.mipmap.play_no_p);
            holdIndex.add(4);
        }
        if(index.length()>0){
            index = index.substring(0,index.length()-1);
        }
        PlayGameNetWorkUtil.getData(getActivity(), Constans.PLAYTWO,
                new FormBody.Builder().add("pidList",index)
                        .build(), ResultBean.class, handler, 4);
    }
    private void getBigorSmall(String type){
        try {
            mBtnOn.setEnabled(false);
            mBtnDown.setEnabled(false);
            PlayGameNetWorkUtil.getData(getActivity(),
                    Constans.SURETHANTIMES, new FormBody.Builder().
                            add("betType",type).build(),
                    BigSmallBean.class, handler, 5);
        }catch (Exception e){
            ToastUtil.toast(getContext(),"数据错误");
            e.printStackTrace();
        }
    }
    private void setBrandLayoutParams(){
        if(isFist){
            isFist = false;
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) mImgA.getLayoutParams();
            RelativeLayout.LayoutParams paramsHold = (RelativeLayout.LayoutParams) mHoldA.getLayoutParams();
            brandWidth = mImgA.getMeasuredHeight();
            layoutParams.width = brandWidth;
            paramsHold.width = brandWidth-40;
            paramsHold.height = (int) ((brandWidth-40)/2.3);
            mHoldA.setLayoutParams(paramsHold);
            mHoldB.setLayoutParams(paramsHold);
            mHoldC.setLayoutParams(paramsHold);
            mHoldD.setLayoutParams(paramsHold);
            mHoldE.setLayoutParams(paramsHold);
            mImgA.setLayoutParams(layoutParams);
            mImgB.setLayoutParams(layoutParams);
            mImgC.setLayoutParams(layoutParams);
            mImgD.setLayoutParams(layoutParams);
            mImgE.setLayoutParams(layoutParams);
        }
    }
    @Override
    public boolean onLongClick(View v) {
        OnClick = true;
        getAllId = soundPool.play(soundBsGetAll, 1.0f, 1.0f, 999, -1, 1);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (OnClick) {
                    int credit = Integer.parseInt(mTvCredit.getText().toString());
                    int bets = interval-credit;
                    if(bets>=500){
                        handler.sendEmptyMessage(16);
                        soundPool.stop(getAllId);
                        OnClick = false;
                        return;
                    }
                    if (credit < 1) {
                        deletteBet = 0;
                        handler.sendEmptyMessage(12);
                        soundPool.stop(getAllId);
                        OnClick = false;
                        return;
                    }
                    if(bets==0&&credit>=100){
                        deletteBet = credit-100;
                    }else {
                        deletteBet = credit - 1;
                    }
                    try {
                        Thread.sleep(30);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(11);
                }
            }
        });
        t.start();
        return true;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (v.getId() == R.id.btn_a_addbet) {
            if (event.getAction() == MotionEvent.ACTION_UP) {
                if(OnClick){
                    OnClick = false;
                    soundPool.stop(getAllId);
                }
            }
        }
        return false;
    }
    private void getScore(){
        final int scoreBefore = interval;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (addScore){
                    interval++;
                    if(interval>=scoreGet||(interval-scoreBefore)>=2000){
                        soundPool.stop(getAllId);
                        interval = scoreGet;
                        addScore = false;
                        //得分后初始化游戏
                        handler.sendEmptyMessage(19);
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(13);
                }

            }
        }).start();
    }
    private void getScoreBig(){
        final int scoreBefore = interval;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (addScore){
                    interval++;
                    if(interval>=scoreGet||(interval-scoreBefore)>=2000){
                        interval = scoreGet;
                        addScore = false;
                        //得分后初始化游戏
                        handler.sendEmptyMessage(20);
                        break;
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.sendEmptyMessage(21);
                }

            }
        }).start();
    }
    private void setExitDialog(){
        if(exitDialog==null){
            exitDialog = new RegistDialog(getContext());
        }
        exitDialog.show();
        Window window = exitDialog.getWindow() ;
        window.setContentView(R.layout.exit_tips);
        RelativeLayout relayout = (RelativeLayout) window.findViewById(R.id.re_dialog_exit);
        Button buttonSure = (Button) window.findViewById(R.id.btn_exit_sure);
        Button buttonCancel = (Button) window.findViewById(R.id.btn_exit_cancel);
        TextView textView = (TextView) window.findViewById(R.id.tv_join_title);
        textView.setText("如果退出机子上的剩余分数将清零!");
        buttonSure.setOnClickListener(this);
        buttonCancel.setOnClickListener(this);
        Display display =getActivity().getWindowManager().getDefaultDisplay();
        int minHeight = display.getHeight();
        relayout.setMinimumHeight(minHeight);
        WindowManager.LayoutParams params = window.getAttributes() ;
        params.width = display.getWidth();
        window.setAttributes(params);
    }
    private void clearScore(int score){
        switch (betCount){
            case 1:
                mTvGifA.setText(score+"");
                break;
            case 2:
                mTvGifB.setText(score+"");
                break;
            case 3:
                mTvGifC.setText(score+"");
                break;
            case 4:
                mTvGifD.setText(score+"");
                break;
            case 5:
                mTvGifE.setText(score+"");
                break;
            case 6:
                mTvGifF.setText(score+"");
                break;
        }
    }

    /**
     * 中奖回调
     * @param listBig
     */
    @Override
    public void onScoreClearViews(ArrayList<TextView> listBig,boolean isBig) {
            if(isBig){
                switch (bigTitle){
                    case "5.K":
                        mTvClearScore = mTvNumA;
                        break;
                    case "R.S":
                        mTvClearScore = mTvNumB;
                        break;
                    case "S.F":
                        mTvClearScore = mTvNumC;
                        break;
                    case "4.K":
                        mTvClearScore = mTvNumD;
                        break;
                }
                this.isBig = false;
                clearScore = Integer.parseInt(mTvClearScore.getText().toString());
                mTvClearA = listBig.get(0);
                clearAScore = Integer.parseInt(mTvClearA.getText().toString());
                mTvClearB = listBig.get(1);
                clearBScore = Integer.parseInt(mTvClearB.getText().toString());
                mTvClearC = null;
                if(listBig.size()>2){
                    mTvClearC =listBig.get(2);
                    clearCScore = Integer.parseInt(mTvClearC.getText().toString());
                }
                getScoreBig();
            }else {
                mTvClearScore = listBig.get(0);
                clearScore = Integer.parseInt(mTvClearScore.getText().toString());
                getAllId = soundPool.play(soundBsGetAll, 1.0f, 1.0f, 999, -1, 1);
                getScore();
            }
    }
    private void getResetScore(){
        try {
        mTvCredit.setText(interval + "");
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //重新开始游戏
                initStartGame();
            }
        },1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public boolean onBackPressed() {
        if(interval>0){
            setExitDialog();
            return true;
        }
        soundPool.autoPause();
        OkHttpUtils.getData(getActivity(), Constans.EXIT, new FormBody.Builder().build(),
                ExitBean.class, handler, 7);
        return true;
    }
}

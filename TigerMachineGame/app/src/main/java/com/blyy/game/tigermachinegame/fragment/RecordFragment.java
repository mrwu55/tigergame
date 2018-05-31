package com.blyy.game.tigermachinegame.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.blyy.game.tigermachinegame.Constans;
import com.blyy.game.tigermachinegame.R;
import com.blyy.game.tigermachinegame.bean.RecordBean;
import com.blyy.game.tigermachinegame.util.PlayGameNetWorkUtil;
import com.blyy.game.tigermachinegame.util.ToastUtil;

import okhttp3.FormBody;

/**
 * Created by WuJingCheng on 2018/5/30.
 */

public class RecordFragment extends BaseFragment implements View.OnClickListener{
    private View viewA,viewB,viewC;
    private TextView mTvReNoteA,mTvReNoteB,mTvReNoteC;
    private TextView mTvA5k,mTvARs,mTvASf,mTvA4k;
    private TextView mTvP5k,mTvPRs,mTvPSf,mTvP4k;
    private TextView mTvBIn,mTvBout;
    private TextView mTvCp5k,mTvCm5k,mTvCpRs,
            mTvCmRs,mTvCpSf,mTvCmSf,mTvCpfk,mTvCmfk,
            mTvCmFh,mTvCmFl,mTvCmSt,mTvCmTk,mTvCmTp,mTvCmOp,mTvCmNo,mTvCmTotal;
    private TextView mTvCk,mTvCrs,mTvCsf,mTvCtk;
    private TextView mTvDoubleTotal,mTvDoubleWinS, mTvDoubleWinN,
            mTvDoubleLossN,mTvSuperFen,mTvSuperN,mTvBTotalN,mTvBTotalW;
    private TextView mTvBAll,mTvBWin;
    private TextView mTvNoteBIn,mTvNoteBOut,mTvNoteBBalance;
    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    RecordBean recordBean = (RecordBean) msg.obj;
                    if(recordBean==null) return;
                    int status = recordBean.getStatus();
                    if(status==1 ){
                        RecordBean.DataBean dataBean = recordBean.getData();
                        RecordBean.DataBean.MachineAnaVoBean machinePlayRecordBean = dataBean.getMachineAnaVo();
                        RecordBean.DataBean.UserPlayRecordBean userPlayRecordBean = dataBean.getUserPlayRecord();
                        RecordBean.DataBean.UserNowRecordBean userNowRecordBean = dataBean.getUserNowRecord();
                        String inScore = machinePlayRecordBean.getTotalIntegralIn();
                        String outScore = machinePlayRecordBean.getTotalIntegralOut();
                        String kNum =  machinePlayRecordBean.getAmtOf5K();
                        String rsNum =  machinePlayRecordBean.getAmtOfRS();
                        String sfNum = machinePlayRecordBean.getAmtOfSF();
                        String fkNum = machinePlayRecordBean.getAmtOf4K();
                        String fhNum = machinePlayRecordBean.getAmtOfFH();
                        String flNum = machinePlayRecordBean.getAmtOfFL();
                        String stNum = machinePlayRecordBean.getAmtOfST();
                        String tkNum = machinePlayRecordBean.getAmtOf3K();
                        String tpNum = machinePlayRecordBean.getAmtOf2P();
                        String opNum = machinePlayRecordBean.getAmtOf1P();
                        String noNum = machinePlayRecordBean.getAmtOf0P();
                        String totalNum = machinePlayRecordBean.getTotalOfPlay();
                        String uKnum = userPlayRecordBean.getAmtOf5K();
                        String uRsnum =userPlayRecordBean.getAmtOfRS();
                        String uSfnum = userPlayRecordBean.getAmtOfSF();
                        String uTknum = userPlayRecordBean.getAmtOf4K();
                        mTvReNoteA.setText(inScore);
                        mTvReNoteB.setText(outScore);
                        mTvNoteBIn.setText(userNowRecordBean.getNowIn());
                        mTvNoteBOut.setText(userNowRecordBean.getNowOut());
                        mTvNoteBBalance.setText(userNowRecordBean.getNowBlan());
                        mTvBIn.setText(inScore);mTvBout.setText(outScore);
                        mTvBTotalN.setText(totalNum);
                        mTvBTotalW.setText(machinePlayRecordBean.getTotalOfWin());
                        mTvReNoteC.setText(machinePlayRecordBean.getTotalIntegralBlan());
                        mTvA5k.setText(kNum);
                        mTvBAll.setText(machinePlayRecordBean.getAllIntegral());
                        mTvBWin.setText(machinePlayRecordBean.getAllWinIntegral());
                        mTvARs.setText(rsNum);mTvASf.setText(sfNum);
                        mTvA4k.setText(fkNum);mTvCp5k.setText(kNum);
                        mTvCm5k.setText(kNum);mTvCpRs.setText(rsNum);
                        mTvCmRs.setText(rsNum);mTvCpSf.setText(sfNum);
                        mTvCmSf.setText(sfNum);mTvCpfk.setText(fkNum);
                        mTvCmfk.setText(fkNum);mTvCmFh.setText(fhNum);
                        mTvCmFl.setText(flNum);mTvCmSt.setText(stNum);
                        mTvCmTk.setText(tkNum);mTvCmTp.setText(tpNum);
                        mTvCmOp.setText(opNum);mTvCmNo.setText(noNum);
                        mTvDoubleTotal.setText(machinePlayRecordBean.getThanTimeOfFen());
                        mTvDoubleWinS.setText(machinePlayRecordBean.getThanTimeOfWinFen());
                        mTvDoubleWinN.setText(machinePlayRecordBean.getTotalOfThanTimeWin());
                        mTvDoubleLossN.setText(machinePlayRecordBean.getTotalOfThanTimeFie());
                        mTvSuperFen.setText(machinePlayRecordBean.getSuperJiangOfFen());
                        mTvSuperN.setText(machinePlayRecordBean.getTotalOfWinSuper());
                        mTvCmTotal.setText(totalNum);
                        mTvP5k.setText(uKnum);mTvPRs.setText(uRsnum);
                        mTvPSf.setText(uSfnum);mTvP4k.setText(uTknum);
                        mTvCk.setText(uKnum);mTvCrs.setText(uRsnum);
                        mTvCsf.setText(uSfnum);mTvCtk.setText(uTknum);
                    }else {
                        ToastUtil.toast(getContext(),recordBean.getMsg());
                        setBackPosition(0);
                    }
                    break;
            }
        }
    };
    @Override
    protected int setView() {
        return R.layout.activity_record;
    }
    public static RecordFragment newInstance(Bundle bundle) {
        RecordFragment fragment = new RecordFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    protected void init(View view) {
        viewA = view.findViewById(R.id.lay_record_a);
        viewB = view.findViewById(R.id.lay_record_b);
        viewC = view.findViewById(R.id.lay_record_c);
        viewA.setOnClickListener(this);
        viewB.setOnClickListener(this);
        viewC.setOnClickListener(this);
        mTvReNoteA = (TextView) view.findViewById(R.id.tv_re_notea);
        mTvReNoteB = (TextView) view.findViewById(R.id.tv_re_noteb);
        mTvReNoteC = (TextView) view.findViewById(R.id.tv_re_notec);
        mTvNoteBIn = view.findViewById(R.id.tv_noteb_in);
        mTvNoteBOut = view.findViewById(R.id.tv_noteb_out);
        mTvNoteBBalance = view.findViewById(R.id.tv_noteb_balance);
        mTvA5k = (TextView) view.findViewById(R.id.tv_laya_k);
        mTvARs = (TextView) view.findViewById(R.id.tv_laya_rs);
        mTvASf = (TextView) view.findViewById(R.id.tv_laya_sf);
        mTvA4k = (TextView) view.findViewById(R.id.tv_laya_fk);
        mTvP5k = (TextView) view.findViewById(R.id.tv_layap_k);
        mTvPRs = (TextView) view.findViewById(R.id.tv_layap_rs);
        mTvPSf = (TextView) view.findViewById(R.id.tv_layap_sf);
        mTvP4k = (TextView) view.findViewById(R.id.tv_layap_fk);
        mTvBIn = (TextView) view.findViewById(R.id.tv_record_pb);
        mTvBout = (TextView) view.findViewById(R.id.tv_win_tb);
        mTvBTotalN  = view.findViewById(R.id.tv_win_pna);
        mTvBTotalW = view.findViewById(R.id.tv_win_na);
        mTvBAll = view.findViewById(R.id.tv_record_pa);
        mTvBWin = view.findViewById(R.id.tv_win_ta);
        mTvCp5k = (TextView) view.findViewById(R.id.tv_cp_k);
        mTvCm5k = (TextView) view.findViewById(R.id.tv_cm_k);
        mTvCpRs = (TextView) view.findViewById(R.id.tv_cp_rs);
        mTvCmRs = (TextView) view.findViewById(R.id.tv_cm_rs);
        mTvCpSf = (TextView) view.findViewById(R.id.tv_cp_sf);
        mTvCmSf = (TextView) view.findViewById(R.id.tv_cm_sf);
        mTvCpfk = (TextView) view.findViewById(R.id.tv_cp_fk);
        mTvCmfk = (TextView) view.findViewById(R.id.tv_cm_fk);
        mTvCmFh = (TextView) view.findViewById(R.id.tv_cm_fh);
        mTvCmFl = (TextView) view.findViewById(R.id.tv_cm_fl);
        mTvCmSt = (TextView) view.findViewById(R.id.tv_cm_st);
        mTvCmTk = (TextView) view.findViewById(R.id.tv_cm_tk);
        mTvCmTp = (TextView) view.findViewById(R.id.tv_cm_tp);
        mTvCmOp = (TextView) view.findViewById(R.id.tv_cm_op);
        mTvCmNo = (TextView) view.findViewById(R.id.tv_cm_no);
        mTvCmTotal = (TextView) view.findViewById(R.id.tv_cm_total);
        mTvCk = (TextView) view.findViewById(R.id.tv_c_pk);
        mTvCrs = (TextView) view.findViewById(R.id.tv_c_rs);
        mTvCsf = (TextView) view.findViewById(R.id.tv_c_sf);
        mTvCtk = (TextView) view.findViewById(R.id.tv_c_tk);
        mTvDoubleTotal = view.findViewById(R.id.tv_double_sca);
        mTvDoubleWinS = view.findViewById(R.id.tv_double_wa);
        mTvDoubleWinN = view.findViewById(R.id.tv_double_wna);
        mTvDoubleLossN = view.findViewById(R.id.tv_double_wnb);
        mTvSuperFen = view.findViewById(R.id.tv_double_scb);
        mTvSuperN = view.findViewById(R.id.tv_double_wb);
        Bundle bundle = getArguments();
        String mId = bundle.getString("mId");
        PlayGameNetWorkUtil.getData(getActivity(), Constans.RECORD, new FormBody.Builder().add("mId",mId).build(),
                RecordBean.class, handler, 0);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lay_record_a:
                viewA.setVisibility(View.INVISIBLE);
                viewB.setVisibility(View.VISIBLE);
                break;
            case R.id.lay_record_b:
                viewB.setVisibility(View.INVISIBLE);
                viewC.setVisibility(View.VISIBLE);
                break;
            case R.id.lay_record_c:
                setBackPosition(4);
                break;
        }
    }

    @Override
    public boolean onBackPressed() {
        return true;
    }
}

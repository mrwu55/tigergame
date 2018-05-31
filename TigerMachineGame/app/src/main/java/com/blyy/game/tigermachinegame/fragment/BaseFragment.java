package com.blyy.game.tigermachinegame.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/**
 * Created by WuJingCheng on 2018/5/24.
 */

public abstract class BaseFragment extends Fragment implements FragmentBackHandler{
    private OnBackClickListner onBackClickListner;
    protected abstract int setView();
    protected abstract void init(View view);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onBackClickListner = (OnBackClickListner) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(setView(), container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
    }
    public void setBackPosition(int position){
        onBackClickListner.onBackClick(position);
    }
    public void showFragment(Bundle bundle,int position){
        onBackClickListner.onFragmentShow(bundle,position);
    }
    @Override
    public boolean onBackPressed() {
        return BackHandlerHelper.handleBackPress(this);
    }
    public interface OnBackClickListner{
        void onBackClick(int position);
        void onFragmentShow(Bundle bundle,int postion);
    }

    @Override
    public void onDestroy() {
        Log.e("fragmentDestroy","onDestroy");
        super.onDestroy();
    }
}

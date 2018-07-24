package com.longfeng.panda.bean;

/**
 * Created by WuJingCheng on 2018/5/3.
 */

public class RecordBean {


    /**
     * status : 1
     * msg : 获取成功
     * data : {"userNowRecord":{"nowIn":0,"nowOut":0,"nowBlan":0},"machineAnaVo":{"maId":31,"mCode":"SF031","totalIntegralIn":3000,"totalIntegralOut":0,"totalIntegralBlan":0,"allIntegral":0,"allWinIntegral":0,"totalOfPlay":795,"amtOf0P":491,"amtOf1P":185,"amtOf2P":41,"amtOf3K":44,"amtOfST":6,"amtOfFL":15,"amtOfFH":3,"amtOf4K":8,"amtOfSF":0,"amtOfRS":2,"amtOf5K":0,"totalOfWin":5,"thanTimeOfFen":5600,"thanTimeOfWinFen":3900,"totalOfThanTimeWin":9,"totalOfThanTimeFie":11,"superJiangOfFen":2732,"totalOfWinSuper":10},"userPlayRecord":{"amtOf4K":5,"amtOfSF":0,"amtOfRS":2,"amtOf5K":0}}
     */

    private int status;
    private String msg;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * userNowRecord : {"nowIn":0,"nowOut":0,"nowBlan":0}
         * machineAnaVo : {"maId":31,"mCode":"SF031","totalIntegralIn":3000,"totalIntegralOut":0,"totalIntegralBlan":0,"allIntegral":0,"allWinIntegral":0,"totalOfPlay":795,"amtOf0P":491,"amtOf1P":185,"amtOf2P":41,"amtOf3K":44,"amtOfST":6,"amtOfFL":15,"amtOfFH":3,"amtOf4K":8,"amtOfSF":0,"amtOfRS":2,"amtOf5K":0,"totalOfWin":5,"thanTimeOfFen":5600,"thanTimeOfWinFen":3900,"totalOfThanTimeWin":9,"totalOfThanTimeFie":11,"superJiangOfFen":2732,"totalOfWinSuper":10}
         * userPlayRecord : {"amtOf4K":5,"amtOfSF":0,"amtOfRS":2,"amtOf5K":0}
         */

        private UserNowRecordBean userNowRecord;
        private MachineAnaVoBean machineAnaVo;
        private UserPlayRecordBean userPlayRecord;

        public UserNowRecordBean getUserNowRecord() {
            return userNowRecord;
        }

        public void setUserNowRecord(UserNowRecordBean userNowRecord) {
            this.userNowRecord = userNowRecord;
        }

        public MachineAnaVoBean getMachineAnaVo() {
            return machineAnaVo;
        }

        public void setMachineAnaVo(MachineAnaVoBean machineAnaVo) {
            this.machineAnaVo = machineAnaVo;
        }

        public UserPlayRecordBean getUserPlayRecord() {
            return userPlayRecord;
        }

        public void setUserPlayRecord(UserPlayRecordBean userPlayRecord) {
            this.userPlayRecord = userPlayRecord;
        }

        public static class UserNowRecordBean {
            /**
             * nowIn : 0
             * nowOut : 0
             * nowBlan : 0
             */

            private String nowIn;
            private String nowOut;
            private String nowBlan;

            public String getNowIn() {
                return nowIn;
            }

            public void setNowIn(String nowIn) {
                this.nowIn = nowIn;
            }

            public String getNowOut() {
                return nowOut;
            }

            public void setNowOut(String nowOut) {
                this.nowOut = nowOut;
            }

            public String getNowBlan() {
                return nowBlan;
            }

            public void setNowBlan(String nowBlan) {
                this.nowBlan = nowBlan;
            }
        }

        public static class MachineAnaVoBean {
            /**
             * maId : 31
             * mCode : SF031
             * totalIntegralIn : 3000
             * totalIntegralOut : 0
             * totalIntegralBlan : 0
             * allIntegral : 0
             * allWinIntegral : 0
             * totalOfPlay : 795
             * amtOf0P : 491
             * amtOf1P : 185
             * amtOf2P : 41
             * amtOf3K : 44
             * amtOfST : 6
             * amtOfFL : 15
             * amtOfFH : 3
             * amtOf4K : 8
             * amtOfSF : 0
             * amtOfRS : 2
             * amtOf5K : 0
             * totalOfWin : 5
             * thanTimeOfFen : 5600
             * thanTimeOfWinFen : 3900
             * totalOfThanTimeWin : 9
             * totalOfThanTimeFie : 11
             * superJiangOfFen : 2732
             * totalOfWinSuper : 10
             */

            private int maId;
            private String mCode;
            private String totalIntegralIn;
            private String totalIntegralOut;
            private String totalIntegralBlan;
            private String allIntegral;
            private String allWinIntegral;
            private String totalOfPlay;
            private String amtOf0P;
            private String amtOf1P;
            private String amtOf2P;
            private String amtOf3K;
            private String amtOfST;
            private String amtOfFL;
            private String amtOfFH;
            private String amtOf4K;
            private String amtOfSF;
            private String amtOfRS;
            private String amtOf5K;
            private String totalOfWin;
            private String thanTimeOfFen;
            private String thanTimeOfWinFen;
            private String totalOfThanTimeWin;
            private String totalOfThanTimeFie;
            private String superJiangOfFen;
            private String totalOfWinSuper;

            public int getMaId() {
                return maId;
            }

            public void setMaId(int maId) {
                this.maId = maId;
            }

            public String getMCode() {
                return mCode;
            }

            public void setMCode(String mCode) {
                this.mCode = mCode;
            }

            public String getTotalIntegralIn() {
                return totalIntegralIn;
            }

            public void setTotalIntegralIn(String totalIntegralIn) {
                this.totalIntegralIn = totalIntegralIn;
            }

            public String getTotalIntegralOut() {
                return totalIntegralOut;
            }

            public void setTotalIntegralOut(String totalIntegralOut) {
                this.totalIntegralOut = totalIntegralOut;
            }

            public String getTotalIntegralBlan() {
                return totalIntegralBlan;
            }

            public void setTotalIntegralBlan(String totalIntegralBlan) {
                this.totalIntegralBlan = totalIntegralBlan;
            }

            public String getAllIntegral() {
                return allIntegral;
            }

            public void setAllIntegral(String allIntegral) {
                this.allIntegral = allIntegral;
            }

            public String getAllWinIntegral() {
                return allWinIntegral;
            }

            public void setAllWinIntegral(String allWinIntegral) {
                this.allWinIntegral = allWinIntegral;
            }

            public String getTotalOfPlay() {
                return totalOfPlay;
            }

            public void setTotalOfPlay(String totalOfPlay) {
                this.totalOfPlay = totalOfPlay;
            }

            public String getAmtOf0P() {
                return amtOf0P;
            }

            public void setAmtOf0P(String amtOf0P) {
                this.amtOf0P = amtOf0P;
            }

            public String getAmtOf1P() {
                return amtOf1P;
            }

            public void setAmtOf1P(String amtOf1P) {
                this.amtOf1P = amtOf1P;
            }

            public String getAmtOf2P() {
                return amtOf2P;
            }

            public void setAmtOf2P(String amtOf2P) {
                this.amtOf2P = amtOf2P;
            }

            public String getAmtOf3K() {
                return amtOf3K;
            }

            public void setAmtOf3K(String amtOf3K) {
                this.amtOf3K = amtOf3K;
            }

            public String getAmtOfST() {
                return amtOfST;
            }

            public void setAmtOfST(String amtOfST) {
                this.amtOfST = amtOfST;
            }

            public String getAmtOfFL() {
                return amtOfFL;
            }

            public void setAmtOfFL(String amtOfFL) {
                this.amtOfFL = amtOfFL;
            }

            public String getAmtOfFH() {
                return amtOfFH;
            }

            public void setAmtOfFH(String amtOfFH) {
                this.amtOfFH = amtOfFH;
            }

            public String getAmtOf4K() {
                return amtOf4K;
            }

            public void setAmtOf4K(String amtOf4K) {
                this.amtOf4K = amtOf4K;
            }

            public String getAmtOfSF() {
                return amtOfSF;
            }

            public void setAmtOfSF(String amtOfSF) {
                this.amtOfSF = amtOfSF;
            }

            public String getAmtOfRS() {
                return amtOfRS;
            }

            public void setAmtOfRS(String amtOfRS) {
                this.amtOfRS = amtOfRS;
            }

            public String getAmtOf5K() {
                return amtOf5K;
            }

            public void setAmtOf5K(String amtOf5K) {
                this.amtOf5K = amtOf5K;
            }

            public String getTotalOfWin() {
                return totalOfWin;
            }

            public void setTotalOfWin(String totalOfWin) {
                this.totalOfWin = totalOfWin;
            }

            public String getThanTimeOfFen() {
                return thanTimeOfFen;
            }

            public void setThanTimeOfFen(String thanTimeOfFen) {
                this.thanTimeOfFen = thanTimeOfFen;
            }

            public String getThanTimeOfWinFen() {
                return thanTimeOfWinFen;
            }

            public void setThanTimeOfWinFen(String thanTimeOfWinFen) {
                this.thanTimeOfWinFen = thanTimeOfWinFen;
            }

            public String getTotalOfThanTimeWin() {
                return totalOfThanTimeWin;
            }

            public void setTotalOfThanTimeWin(String totalOfThanTimeWin) {
                this.totalOfThanTimeWin = totalOfThanTimeWin;
            }

            public String getTotalOfThanTimeFie() {
                return totalOfThanTimeFie;
            }

            public void setTotalOfThanTimeFie(String totalOfThanTimeFie) {
                this.totalOfThanTimeFie = totalOfThanTimeFie;
            }

            public String getSuperJiangOfFen() {
                return superJiangOfFen;
            }

            public void setSuperJiangOfFen(String superJiangOfFen) {
                this.superJiangOfFen = superJiangOfFen;
            }

            public String getTotalOfWinSuper() {
                return totalOfWinSuper;
            }

            public void setTotalOfWinSuper(String totalOfWinSuper) {
                this.totalOfWinSuper = totalOfWinSuper;
            }
        }

        public static class UserPlayRecordBean {
            /**
             * amtOf4K : 5
             * amtOfSF : 0
             * amtOfRS : 2
             * amtOf5K : 0
             */

            private String amtOf4K;
            private String amtOfSF;
            private String amtOfRS;
            private String amtOf5K;

            public String getAmtOf4K() {
                return amtOf4K;
            }

            public void setAmtOf4K(String amtOf4K) {
                this.amtOf4K = amtOf4K;
            }

            public String getAmtOfSF() {
                return amtOfSF;
            }

            public void setAmtOfSF(String amtOfSF) {
                this.amtOfSF = amtOfSF;
            }

            public String getAmtOfRS() {
                return amtOfRS;
            }

            public void setAmtOfRS(String amtOfRS) {
                this.amtOfRS = amtOfRS;
            }

            public String getAmtOf5K() {
                return amtOf5K;
            }

            public void setAmtOf5K(String amtOf5K) {
                this.amtOf5K = amtOf5K;
            }
        }
    }
}

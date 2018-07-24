package com.longfeng.panda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */

public class PlayBean implements Serializable{

    /**
     * status : 1
     * msg : success
     * data : {"rateList":[{"cbnId":1,"cbnName":"一对","cbnEnName":"1.P","rateVos":[{"rId":1,"rateValue":1},{"rId":2,"rateValue":1},{"rId":3,"rateValue":1}]},{"cbnId":2,"cbnName":"二对","cbnEnName":"2.P","rateVos":[{"rId":4,"rateValue":2},{"rId":5,"rateValue":2},{"rId":6,"rateValue":2}]},{"cbnId":3,"cbnName":"三条","cbnEnName":"3.K","rateVos":[{"rId":7,"rateValue":3},{"rId":8,"rateValue":3},{"rId":9,"rateValue":3}]},{"cbnId":4,"cbnName":"顺子","cbnEnName":"S.T","rateVos":[{"rId":10,"rateValue":4},{"rId":11,"rateValue":5},{"rId":12,"rateValue":6}]},{"cbnId":5,"cbnName":"同花","cbnEnName":"F.L","rateVos":[{"rId":13,"rateValue":6},{"rId":14,"rateValue":7},{"rId":15,"rateValue":8}]},{"cbnId":6,"cbnName":"葫芦","cbnEnName":"F.H","rateVos":[{"rId":16,"rateValue":8},{"rId":17,"rateValue":10},{"rId":18,"rateValue":12}]},{"cbnId":7,"cbnName":"四条","cbnEnName":"4.K","rateVos":[{"rId":19,"rateValue":40},{"rId":20,"rateValue":50},{"rId":21,"rateValue":60}]},{"cbnId":8,"cbnName":"同花顺","cbnEnName":"S.F","rateVos":[{"rId":22,"rateValue":100},{"rId":23,"rateValue":120},{"rId":24,"rateValue":140}]},{"cbnId":9,"cbnName":"同花大顺","cbnEnName":"R.S","rateVos":[{"rId":25,"rateValue":150},{"rId":26,"rateValue":200},{"rId":27,"rateValue":250}]},{"cbnId":10,"cbnName":"五条","cbnEnName":"5.K","rateVos":[{"rId":28,"rateValue":300},{"rId":29,"rateValue":400},{"rId":30,"rateValue":500}]}],"uGold":685114,"machineVo":{"mId":2,"mCode":"SF002","totalOf5k":77,"totalOfRs":1,"totalOfSf":182,"totalOf4k":80},"integral":0}
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

    public static class DataBean implements Serializable{
        /**
         * rateList : [{"cbnId":1,"cbnName":"一对","cbnEnName":"1.P","rateVos":[{"rId":1,"rateValue":1},{"rId":2,"rateValue":1},{"rId":3,"rateValue":1}]},{"cbnId":2,"cbnName":"二对","cbnEnName":"2.P","rateVos":[{"rId":4,"rateValue":2},{"rId":5,"rateValue":2},{"rId":6,"rateValue":2}]},{"cbnId":3,"cbnName":"三条","cbnEnName":"3.K","rateVos":[{"rId":7,"rateValue":3},{"rId":8,"rateValue":3},{"rId":9,"rateValue":3}]},{"cbnId":4,"cbnName":"顺子","cbnEnName":"S.T","rateVos":[{"rId":10,"rateValue":4},{"rId":11,"rateValue":5},{"rId":12,"rateValue":6}]},{"cbnId":5,"cbnName":"同花","cbnEnName":"F.L","rateVos":[{"rId":13,"rateValue":6},{"rId":14,"rateValue":7},{"rId":15,"rateValue":8}]},{"cbnId":6,"cbnName":"葫芦","cbnEnName":"F.H","rateVos":[{"rId":16,"rateValue":8},{"rId":17,"rateValue":10},{"rId":18,"rateValue":12}]},{"cbnId":7,"cbnName":"四条","cbnEnName":"4.K","rateVos":[{"rId":19,"rateValue":40},{"rId":20,"rateValue":50},{"rId":21,"rateValue":60}]},{"cbnId":8,"cbnName":"同花顺","cbnEnName":"S.F","rateVos":[{"rId":22,"rateValue":100},{"rId":23,"rateValue":120},{"rId":24,"rateValue":140}]},{"cbnId":9,"cbnName":"同花大顺","cbnEnName":"R.S","rateVos":[{"rId":25,"rateValue":150},{"rId":26,"rateValue":200},{"rId":27,"rateValue":250}]},{"cbnId":10,"cbnName":"五条","cbnEnName":"5.K","rateVos":[{"rId":28,"rateValue":300},{"rId":29,"rateValue":400},{"rId":30,"rateValue":500}]}]
         * uGold : 685114
         * machineVo : {"mId":2,"mCode":"SF002","totalOf5k":77,"totalOfRs":1,"totalOfSf":182,"totalOf4k":80}
         * integral : 0
         */

        private int uGold;
        private MachineVoBean machineVo;
        private int integral;
        private List<RateListBean> rateList;
        private String message;
        private String gameStatus;

        public int getUGold() {
            return uGold;
        }

        public void setUGold(int uGold) {
            this.uGold = uGold;
        }

        public MachineVoBean getMachineVo() {
            return machineVo;
        }

        public void setMachineVo(MachineVoBean machineVo) {
            this.machineVo = machineVo;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public List<RateListBean> getRateList() {
            return rateList;
        }

        public void setRateList(List<RateListBean> rateList) {
            this.rateList = rateList;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getGameStatus() {
            return gameStatus;
        }

        public void setGameStatus(String gameStatus) {
            this.gameStatus = gameStatus;
        }

        public static class MachineVoBean implements Serializable{
            /**
             * mId : 2
             * mCode : SF002
             * totalOf5k : 77
             * totalOfRs : 1
             * totalOfSf : 182
             * totalOf4k : 80
             */

            private int mId;
            private String mCode;
            private int totalOf5k;
            private int totalOfRs;
            private int totalOfSf;
            private int totalOf4k;

            public int getMId() {
                return mId;
            }

            public void setMId(int mId) {
                this.mId = mId;
            }

            public String getMCode() {
                return mCode;
            }

            public void setMCode(String mCode) {
                this.mCode = mCode;
            }

            public int getTotalOf5k() {
                return totalOf5k;
            }

            public void setTotalOf5k(int totalOf5k) {
                this.totalOf5k = totalOf5k;
            }

            public int getTotalOfRs() {
                return totalOfRs;
            }

            public void setTotalOfRs(int totalOfRs) {
                this.totalOfRs = totalOfRs;
            }

            public int getTotalOfSf() {
                return totalOfSf;
            }

            public void setTotalOfSf(int totalOfSf) {
                this.totalOfSf = totalOfSf;
            }

            public int getTotalOf4k() {
                return totalOf4k;
            }

            public void setTotalOf4k(int totalOf4k) {
                this.totalOf4k = totalOf4k;
            }
        }

        public static class RateListBean implements Serializable{
            /**
             * cbnId : 1
             * cbnName : 一对
             * cbnEnName : 1.P
             * rateVos : [{"rId":1,"rateValue":1},{"rId":2,"rateValue":1},{"rId":3,"rateValue":1}]
             */

            private int cbnId;
            private String cbnName;
            private String cbnEnName;
            private List<RateVosBean> rateVos;

            public int getCbnId() {
                return cbnId;
            }

            public void setCbnId(int cbnId) {
                this.cbnId = cbnId;
            }

            public String getCbnName() {
                return cbnName;
            }

            public void setCbnName(String cbnName) {
                this.cbnName = cbnName;
            }

            public String getCbnEnName() {
                return cbnEnName;
            }

            public void setCbnEnName(String cbnEnName) {
                this.cbnEnName = cbnEnName;
            }

            public List<RateVosBean> getRateVos() {
                return rateVos;
            }

            public void setRateVos(List<RateVosBean> rateVos) {
                this.rateVos = rateVos;
            }

            public static class RateVosBean implements Serializable{
                /**
                 * rId : 1
                 * rateValue : 1
                 */

                private int rId;
                private int rateValue;

                public int getRId() {
                    return rId;
                }

                public void setRId(int rId) {
                    this.rId = rId;
                }

                public int getRateValue() {
                    return rateValue;
                }

                public void setRateValue(int rateValue) {
                    this.rateValue = rateValue;
                }
            }
        }
    }
}

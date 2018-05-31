package com.blyy.game.tigermachinegame.bean;

import java.util.List;

/**
 * Created by WuJingCheng
 * on 2018/2/17.
 */
public class StartBean {

    /**
     * status : 1
     * msg : success
     * data : {"twoPokerList":[{"pId":40,"point":"A","pointNum":1,"ctId":4},{"pId":2,"point":"2","pointNum":2,"ctId":1},{"pId":13,"point":"K","pointNum":13,"ctId":1},{"pId":5,"point":"5","pointNum":5,"ctId":1},{"pId":12,"point":"Q","pointNum":12,"ctId":1}],"rtId":3,"holdPokerIndex":null,"onePokerList":[{"pId":34,"point":"8","pointNum":8,"ctId":3},{"pId":36,"point":"10","pointNum":10,"ctId":3},{"pId":14,"point":"A","pointNum":1,"ctId":2},{"pId":22,"point":"9","pointNum":9,"ctId":2},{"pId":33,"point":"7","pointNum":7,"ctId":3}]}
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
         * twoPokerList : [{"pId":40,"point":"A","pointNum":1,"ctId":4},{"pId":2,"point":"2","pointNum":2,"ctId":1},{"pId":13,"point":"K","pointNum":13,"ctId":1},{"pId":5,"point":"5","pointNum":5,"ctId":1},{"pId":12,"point":"Q","pointNum":12,"ctId":1}]
         * rtId : 3
         * holdPokerIndex : null
         * onePokerList : [{"pId":34,"point":"8","pointNum":8,"ctId":3},{"pId":36,"point":"10","pointNum":10,"ctId":3},{"pId":14,"point":"A","pointNum":1,"ctId":2},{"pId":22,"point":"9","pointNum":9,"ctId":2},{"pId":33,"point":"7","pointNum":7,"ctId":3}]
         */

        private int rtId;
        private String holdCbn;
        private List<Integer> holdPokerIndex;
        private List<TwoPokerListBean> twoPokerList;
        private List<OnePokerListBean> onePokerList;
        public int getRtId() {
            return rtId;
        }

        public void setRtId(int rtId) {
            this.rtId = rtId;
        }

        public List<Integer> getHoldPokerIndex() {
            return holdPokerIndex;
        }

        public void setHoldPokerIndex(List<Integer> holdPokerIndex) {
            this.holdPokerIndex = holdPokerIndex;
        }

        public List<TwoPokerListBean> getTwoPokerList() {
            return twoPokerList;
        }

        public void setTwoPokerList(List<TwoPokerListBean> twoPokerList) {
            this.twoPokerList = twoPokerList;
        }

        public List<OnePokerListBean> getOnePokerList() {
            return onePokerList;
        }

        public void setOnePokerList(List<OnePokerListBean> onePokerList) {
            this.onePokerList = onePokerList;
        }

        public String getHoldCbn() {
            return holdCbn;
        }

        public void setHoldCbn(String holdCbn) {
            this.holdCbn = holdCbn;
        }


        public static class TwoPokerListBean {
            /**
             * pId : 40
             * point : A
             * pointNum : 1
             * ctId : 4
             */

            private int pId;
            private String point;
            private String pointNum;
            private int ctId;

            public int getPId() {
                return pId;
            }

            public void setPId(int pId) {
                this.pId = pId;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getPointNum() {
                return pointNum;
            }

            public void setPointNum(String pointNum) {
                this.pointNum = pointNum;
            }

            public int getCtId() {
                return ctId;
            }

            public void setCtId(int ctId) {
                this.ctId = ctId;
            }
        }

        public static class OnePokerListBean {
            /**
             * pId : 34
             * point : 8
             * pointNum : 8
             * ctId : 3
             */

            private int pId;
            private String point;
            private String pointNum;
            private int ctId;

            public int getPId() {
                return pId;
            }

            public void setPId(int pId) {
                this.pId = pId;
            }

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getPointNum() {
                return pointNum;
            }

            public void setPointNum(String pointNum) {
                this.pointNum = pointNum;
            }

            public int getCtId() {
                return ctId;
            }

            public void setCtId(int ctId) {
                this.ctId = ctId;
            }
        }
    }
}

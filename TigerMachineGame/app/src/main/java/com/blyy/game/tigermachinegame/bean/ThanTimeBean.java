package com.blyy.game.tigermachinegame.bean;

import java.util.List;

/**
 * Created by WuJingCheng
 * on 2018/2/19.
 */
public class ThanTimeBean {

    /**
     * status : 1
     * msg : success
     * data : {"rateTypeList":[{"rtId":1,"rtName":"1F","bili":"1"},{"rtId":2,"rtName":"2F","bili":"2"},{"rtId":3,"rtName":"5F","bili":"5"},{"rtId":4,"rtName":"10F","bili":"10"},{"rtId":5,"rtName":"20F","bili":"20"},{"rtId":6,"rtName":"50F","bili":"50"}],"pokerList":[{"pId":1,"point":"A","pointNum":1,"ctId":1,"colorType":"红桃"},{"pId":20,"point":"7","pointNum":7,"ctId":2,"colorType":"黑桃"},{"pId":49,"point":"10","pointNum":10,"ctId":4,"colorType":"方块"},{"pId":30,"point":"4","pointNum":4,"ctId":3,"colorType":"梅花"},{"pId":14,"point":"A","pointNum":1,"ctId":2,"colorType":"黑桃"},{"pId":15,"point":"2","pointNum":2,"ctId":2,"colorType":"黑桃"}],"betRecord":{"uId":1,"integral":800,"betRt":2,"thanTimeRt":1,"getIntegral":100,"pushBetStatus":0,"bet":100,"usersVo":{"uId":1,"uName":"admin","uGold":685722,"uIntegral":0,"userStatus":1,"machineVo":{"mId":32,"mCode":"SF032","playTotal":0,"rId":2,"rName":"2F","bili":"2","status":2,"totalOf5k":4,"totalOfRs":4,"totalOfSf":4,"totalOf4k":4,"machineOfUserVo":{"uId":0,"uName":null,"keepTimeDate":null,"keepTime":0,"keepType":0}}},"rateId":0,"cbn":"1.P","rt":3,"superIntegral":0,"theGamePoker":"3,4"}}
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
         * rateTypeList : [{"rtId":1,"rtName":"1F","bili":"1"},{"rtId":2,"rtName":"2F","bili":"2"},{"rtId":3,"rtName":"5F","bili":"5"},{"rtId":4,"rtName":"10F","bili":"10"},{"rtId":5,"rtName":"20F","bili":"20"},{"rtId":6,"rtName":"50F","bili":"50"}]
         * pokerList : [{"pId":1,"point":"A","pointNum":1,"ctId":1,"colorType":"红桃"},{"pId":20,"point":"7","pointNum":7,"ctId":2,"colorType":"黑桃"},{"pId":49,"point":"10","pointNum":10,"ctId":4,"colorType":"方块"},{"pId":30,"point":"4","pointNum":4,"ctId":3,"colorType":"梅花"},{"pId":14,"point":"A","pointNum":1,"ctId":2,"colorType":"黑桃"},{"pId":15,"point":"2","pointNum":2,"ctId":2,"colorType":"黑桃"}]
         * betRecord : {"uId":1,"integral":800,"betRt":2,"thanTimeRt":1,"getIntegral":100,"pushBetStatus":0,"bet":100,"usersVo":{"uId":1,"uName":"admin","uGold":685722,"uIntegral":0,"userStatus":1,"machineVo":{"mId":32,"mCode":"SF032","playTotal":0,"rId":2,"rName":"2F","bili":"2","status":2,"totalOf5k":4,"totalOfRs":4,"totalOfSf":4,"totalOf4k":4,"machineOfUserVo":{"uId":0,"uName":null,"keepTimeDate":null,"keepTime":0,"keepType":0}}},"rateId":0,"cbn":"1.P","rt":3,"superIntegral":0,"theGamePoker":"3,4"}
         */

        private BetRecordBean betRecord;
        private List<RateTypeListBean> rateTypeList;
        private List<PokerListBean> pokerList;

        public BetRecordBean getBetRecord() {
            return betRecord;
        }

        public void setBetRecord(BetRecordBean betRecord) {
            this.betRecord = betRecord;
        }

        public List<RateTypeListBean> getRateTypeList() {
            return rateTypeList;
        }

        public void setRateTypeList(List<RateTypeListBean> rateTypeList) {
            this.rateTypeList = rateTypeList;
        }

        public List<PokerListBean> getPokerList() {
            return pokerList;
        }

        public void setPokerList(List<PokerListBean> pokerList) {
            this.pokerList = pokerList;
        }

        public static class BetRecordBean {
            /**
             * uId : 1
             * integral : 800
             * betRt : 2
             * thanTimeRt : 1
             * getIntegral : 100
             * pushBetStatus : 0
             * bet : 100
             * usersVo : {"uId":1,"uName":"admin","uGold":685722,"uIntegral":0,"userStatus":1,"machineVo":{"mId":32,"mCode":"SF032","playTotal":0,"rId":2,"rName":"2F","bili":"2","status":2,"totalOf5k":4,"totalOfRs":4,"totalOfSf":4,"totalOf4k":4,"machineOfUserVo":{"uId":0,"uName":null,"keepTimeDate":null,"keepTime":0,"keepType":0}}}
             * rateId : 0
             * cbn : 1.P
             * rt : 3
             * superIntegral : 0
             * theGamePoker : 3,4
             */

            private int uId;
            private int integral;
            private int betRt;
            private int thanTimeRt;
            private int getIntegral;
            private int pushBetStatus;
            private int bet;
            private UsersVoBean usersVo;
            private int rateId;
            private String cbn;
            private int rt;
            private int superIntegral;
            private String theGamePoker;

            public int getUId() {
                return uId;
            }

            public void setUId(int uId) {
                this.uId = uId;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getBetRt() {
                return betRt;
            }

            public void setBetRt(int betRt) {
                this.betRt = betRt;
            }

            public int getThanTimeRt() {
                return thanTimeRt;
            }

            public void setThanTimeRt(int thanTimeRt) {
                this.thanTimeRt = thanTimeRt;
            }

            public int getGetIntegral() {
                return getIntegral;
            }

            public void setGetIntegral(int getIntegral) {
                this.getIntegral = getIntegral;
            }

            public int getPushBetStatus() {
                return pushBetStatus;
            }

            public void setPushBetStatus(int pushBetStatus) {
                this.pushBetStatus = pushBetStatus;
            }

            public int getBet() {
                return bet;
            }

            public void setBet(int bet) {
                this.bet = bet;
            }

            public UsersVoBean getUsersVo() {
                return usersVo;
            }

            public void setUsersVo(UsersVoBean usersVo) {
                this.usersVo = usersVo;
            }

            public int getRateId() {
                return rateId;
            }

            public void setRateId(int rateId) {
                this.rateId = rateId;
            }

            public String getCbn() {
                return cbn;
            }

            public void setCbn(String cbn) {
                this.cbn = cbn;
            }

            public int getRt() {
                return rt;
            }

            public void setRt(int rt) {
                this.rt = rt;
            }

            public int getSuperIntegral() {
                return superIntegral;
            }

            public void setSuperIntegral(int superIntegral) {
                this.superIntegral = superIntegral;
            }

            public String getTheGamePoker() {
                return theGamePoker;
            }

            public void setTheGamePoker(String theGamePoker) {
                this.theGamePoker = theGamePoker;
            }

            public static class UsersVoBean {
                /**
                 * uId : 1
                 * uName : admin
                 * uGold : 685722
                 * uIntegral : 0
                 * userStatus : 1
                 * machineVo : {"mId":32,"mCode":"SF032","playTotal":0,"rId":2,"rName":"2F","bili":"2","status":2,"totalOf5k":4,"totalOfRs":4,"totalOfSf":4,"totalOf4k":4,"machineOfUserVo":{"uId":0,"uName":null,"keepTimeDate":null,"keepTime":0,"keepType":0}}
                 */

                private int uId;
                private String uName;
                private int uGold;
                private int uIntegral;
                private int userStatus;
                private MachineVoBean machineVo;

                public int getUId() {
                    return uId;
                }

                public void setUId(int uId) {
                    this.uId = uId;
                }

                public String getUName() {
                    return uName;
                }

                public void setUName(String uName) {
                    this.uName = uName;
                }

                public int getUGold() {
                    return uGold;
                }

                public void setUGold(int uGold) {
                    this.uGold = uGold;
                }

                public int getUIntegral() {
                    return uIntegral;
                }

                public void setUIntegral(int uIntegral) {
                    this.uIntegral = uIntegral;
                }

                public int getUserStatus() {
                    return userStatus;
                }

                public void setUserStatus(int userStatus) {
                    this.userStatus = userStatus;
                }

                public MachineVoBean getMachineVo() {
                    return machineVo;
                }

                public void setMachineVo(MachineVoBean machineVo) {
                    this.machineVo = machineVo;
                }

                public static class MachineVoBean {
                    /**
                     * mId : 32
                     * mCode : SF032
                     * playTotal : 0
                     * rId : 2
                     * rName : 2F
                     * bili : 2
                     * status : 2
                     * totalOf5k : 4
                     * totalOfRs : 4
                     * totalOfSf : 4
                     * totalOf4k : 4
                     * machineOfUserVo : {"uId":0,"uName":null,"keepTimeDate":null,"keepTime":0,"keepType":0}
                     */

                    private int mId;
                    private String mCode;
                    private int playTotal;
                    private int rId;
                    private String rName;
                    private String bili;
                    private int status;
                    private int totalOf5k;
                    private int totalOfRs;
                    private int totalOfSf;
                    private int totalOf4k;
                    private MachineOfUserVoBean machineOfUserVo;

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

                    public int getPlayTotal() {
                        return playTotal;
                    }

                    public void setPlayTotal(int playTotal) {
                        this.playTotal = playTotal;
                    }

                    public int getRId() {
                        return rId;
                    }

                    public void setRId(int rId) {
                        this.rId = rId;
                    }

                    public String getRName() {
                        return rName;
                    }

                    public void setRName(String rName) {
                        this.rName = rName;
                    }

                    public String getBili() {
                        return bili;
                    }

                    public void setBili(String bili) {
                        this.bili = bili;
                    }

                    public int getStatus() {
                        return status;
                    }

                    public void setStatus(int status) {
                        this.status = status;
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

                    public MachineOfUserVoBean getMachineOfUserVo() {
                        return machineOfUserVo;
                    }

                    public void setMachineOfUserVo(MachineOfUserVoBean machineOfUserVo) {
                        this.machineOfUserVo = machineOfUserVo;
                    }

                    public static class MachineOfUserVoBean {
                        /**
                         * uId : 0
                         * uName : null
                         * keepTimeDate : null
                         * keepTime : 0
                         * keepType : 0
                         */

                        private int uId;
                        private Object uName;
                        private Object keepTimeDate;
                        private int keepTime;
                        private int keepType;

                        public int getUId() {
                            return uId;
                        }

                        public void setUId(int uId) {
                            this.uId = uId;
                        }

                        public Object getUName() {
                            return uName;
                        }

                        public void setUName(Object uName) {
                            this.uName = uName;
                        }

                        public Object getKeepTimeDate() {
                            return keepTimeDate;
                        }

                        public void setKeepTimeDate(Object keepTimeDate) {
                            this.keepTimeDate = keepTimeDate;
                        }

                        public int getKeepTime() {
                            return keepTime;
                        }

                        public void setKeepTime(int keepTime) {
                            this.keepTime = keepTime;
                        }

                        public int getKeepType() {
                            return keepType;
                        }

                        public void setKeepType(int keepType) {
                            this.keepType = keepType;
                        }
                    }
                }
            }
        }

        public static class RateTypeListBean {
            /**
             * rtId : 1
             * rtName : 1F
             * bili : 1
             */

            private int rtId;
            private String rtName;
            private String bili;

            public int getRtId() {
                return rtId;
            }

            public void setRtId(int rtId) {
                this.rtId = rtId;
            }

            public String getRtName() {
                return rtName;
            }

            public void setRtName(String rtName) {
                this.rtName = rtName;
            }

            public String getBili() {
                return bili;
            }

            public void setBili(String bili) {
                this.bili = bili;
            }
        }

        public static class PokerListBean {
            /**
             * pId : 1
             * point : A
             * pointNum : 1
             * ctId : 1
             * colorType : 红桃
             */

            private int pId;
            private String point;
            private String pointNum;
            private int ctId;
            private String colorType;

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

            public String getColorType() {
                return colorType;
            }

            public void setColorType(String colorType) {
                this.colorType = colorType;
            }
        }
    }
}

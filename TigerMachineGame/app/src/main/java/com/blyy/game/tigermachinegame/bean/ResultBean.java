package com.blyy.game.tigermachinegame.bean;

import java.util.List;

/**
 * Created by WuJingCheng
 * on 2018/2/18.
 */
public class ResultBean {

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

        private String message;
        private int status;
        private MachineBean machine;
        private BetRecordBean betRecord;
        private List<TwoPokerListBean> twoPokerList;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public MachineBean getMachine() {
            return machine;
        }

        public void setMachine(MachineBean machine) {
            this.machine = machine;
        }

        public BetRecordBean getBetRecord() {
            return betRecord;
        }

        public void setBetRecord(BetRecordBean betRecord) {
            this.betRecord = betRecord;
        }

        public List<TwoPokerListBean> getTwoPokerList() {
            return twoPokerList;
        }

        public void setTwoPokerList(List<TwoPokerListBean> twoPokerList) {
            this.twoPokerList = twoPokerList;
        }

        public static class MachineBean {
            /**
             * mId : 32
             * mCode : SF032
             * playTotal : 0
             * rId : 2
             * rName : 2F
             * bili : 20
             * status : 2
             * totalOf5k : 0
             * totalOfRs : 0
             * totalOfSf : 0
             * totalOf4k : 0
             * machineOfUserVo : {"uId":1,"uName":"admin","keepTimeDate":null,"keepTime":0,"keepType":2}
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
                 * uId : 1
                 * uName : admin
                 * keepTimeDate : null
                 * keepTime : 0
                 * keepType : 2
                 */

                private int uId;
                private String uName;
                private Object keepTimeDate;
                private int keepTime;
                private int keepType;

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

        public static class BetRecordBean {
            /**
             * uId : 1
             * integral : 800
             * betRt : 2
             * thanTimeRt : 1
             * getIntegral : -100
             * pushBetStatus : 1
             * bet : 0
             * usersVo : {"uId":1,"uName":"admin","uGold":683202,"uIntegral":0,"userStatus":1,"machineVo":{"mId":32,"mCode":"SF032","playTotal":0,"rId":2,"rName":"2F","bili":"20","status":2,"totalOf5k":0,"totalOfRs":0,"totalOfSf":0,"totalOf4k":0,"machineOfUserVo":{"uId":1,"uName":"admin","keepTimeDate":null,"keepTime":0,"keepType":2}}}
             * rateId : 0
             * cbn :
             * rt : 0
             * superIntegral : 0
             * theGamePoker : 0,3
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
                 * uGold : 683202
                 * uIntegral : 0
                 * userStatus : 1
                 * machineVo : {"mId":32,"mCode":"SF032","playTotal":0,"rId":2,"rName":"2F","bili":"20","status":2,"totalOf5k":0,"totalOfRs":0,"totalOfSf":0,"totalOf4k":0,"machineOfUserVo":{"uId":1,"uName":"admin","keepTimeDate":null,"keepTime":0,"keepType":2}}
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
                     * bili : 20
                     * status : 2
                     * totalOf5k : 0
                     * totalOfRs : 0
                     * totalOfSf : 0
                     * totalOf4k : 0
                     * machineOfUserVo : {"uId":1,"uName":"admin","keepTimeDate":null,"keepTime":0,"keepType":2}
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
                    private MachineOfUserVoBeanX machineOfUserVo;

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

                    public MachineOfUserVoBeanX getMachineOfUserVo() {
                        return machineOfUserVo;
                    }

                    public void setMachineOfUserVo(MachineOfUserVoBeanX machineOfUserVo) {
                        this.machineOfUserVo = machineOfUserVo;
                    }

                    public static class MachineOfUserVoBeanX {
                        /**
                         * uId : 1
                         * uName : admin
                         * keepTimeDate : null
                         * keepTime : 0
                         * keepType : 2
                         */

                        private int uId;
                        private String uName;
                        private Object keepTimeDate;
                        private int keepTime;
                        private int keepType;

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

        public static class TwoPokerListBean {
            /**
             * pId : 25
             * point : Q
             * pointNum : 12
             * ctId : 2
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

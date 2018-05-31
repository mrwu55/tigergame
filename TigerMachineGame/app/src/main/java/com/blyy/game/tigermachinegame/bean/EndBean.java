package com.blyy.game.tigermachinegame.bean;

/**
 * Created by WuJingCheng
 * on 2018/2/19.
 */
public class EndBean {

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
        private BetRecordBean betRecord;

        public BetRecordBean getBetRecord() {
            return betRecord;
        }

        public void setBetRecord(BetRecordBean betRecord) {
            this.betRecord = betRecord;
        }

        public static class BetRecordBean {

            private int uId;
            private int integral;
            private int betIntegral;
            private int getIntegral;
            private int pushBetStatus;
            private int bet;
            private UsersVoBean usersVo;
            private int rateId;
            private String cbn;
            private int rt;

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

            public int getBetIntegral() {
                return betIntegral;
            }

            public void setBetIntegral(int betIntegral) {
                this.betIntegral = betIntegral;
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

            public static class UsersVoBean {

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

                    private int mId;
                    private String mCode;
                    private int playTotal;
                    private int rtId;
                    private String rtName;
                    private String bili;
                    private int status;
                    private int totalOf5k;
                    private int totalOfRs;
                    private int totalOfSf;
                    private int totalOf4k;
                    private Object machineOfUserVo;

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

                    public Object getMachineOfUserVo() {
                        return machineOfUserVo;
                    }

                    public void setMachineOfUserVo(Object machineOfUserVo) {
                        this.machineOfUserVo = machineOfUserVo;
                    }
                }
            }
        }
    }
}

package com.longfeng.panda.bean;

import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */

public class RegistBean {

    /**
     * status : 1
     * msg : 注册成功，请联系管理员激活账号
     * data : {"message":"success","users":{"uId":7,"uName":"nnnnnn","uPass":"12345","uSex":null,"uGold":0,"uIntegral":0,"invitationCode":null,"uBinvitationCode":"0001","userStatus":0,"uRegisterTime":1518339775526,"gdp001":"nnnnnn","gdp002":1518339775526,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":""},"rateTypeList":[{"rtId":1,"rtName":"1F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":2,"rtName":"2F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":3,"rtName":"5F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":4,"rtName":"10F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":5,"rtName":"20F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":6,"rtName":"50F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":7,"rtName":"100F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null}]}
     */

    private int status;
    private String msg;
    /**
     * message : success
     * users : {"uId":7,"uName":"nnnnnn","uPass":"12345","uSex":null,"uGold":0,"uIntegral":0,"invitationCode":null,"uBinvitationCode":"0001","userStatus":0,"uRegisterTime":1518339775526,"gdp001":"nnnnnn","gdp002":1518339775526,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":""}
     * rateTypeList : [{"rtId":1,"rtName":"1F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":2,"rtName":"2F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":3,"rtName":"5F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":4,"rtName":"10F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":5,"rtName":"20F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":6,"rtName":"50F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":7,"rtName":"100F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null}]
     */

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
        /**
         * uId : 7
         * uName : nnnnnn
         * uPass : 12345
         * uSex : null
         * uGold : 0
         * uIntegral : 0
         * invitationCode : null
         * uBinvitationCode : 0001
         * userStatus : 0
         * uRegisterTime : 1518339775526
         * gdp001 : nnnnnn
         * gdp002 : 1518339775526
         * gdp003 : null
         * gdp004 : null
         * gdp005 : 1
         * gdp006 :
         */

        private UsersBean users;
        /**
         * rtId : 1
         * rtName : 1F
         * bili : null
         * gdp001 : null
         * gdp002 : null
         * gdp003 : null
         * gdp004 : null
         * gdp005 : 1
         * gdp006 : null
         */

        private List<RateTypeListBean> rateTypeList;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public UsersBean getUsers() {
            return users;
        }

        public void setUsers(UsersBean users) {
            this.users = users;
        }

        public List<RateTypeListBean> getRateTypeList() {
            return rateTypeList;
        }

        public void setRateTypeList(List<RateTypeListBean> rateTypeList) {
            this.rateTypeList = rateTypeList;
        }

        public static class UsersBean {
            private int uId;
            private String uName;
            private String uPass;
            private Object uSex;
            private int uGold;
            private int uIntegral;
            private Object invitationCode;
            private String uBinvitationCode;
            private int userStatus;
            private long uRegisterTime;
            private String gdp001;
            private long gdp002;
            private Object gdp003;
            private Object gdp004;
            private int gdp005;
            private String gdp006;

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

            public String getUPass() {
                return uPass;
            }

            public void setUPass(String uPass) {
                this.uPass = uPass;
            }

            public Object getUSex() {
                return uSex;
            }

            public void setUSex(Object uSex) {
                this.uSex = uSex;
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

            public Object getInvitationCode() {
                return invitationCode;
            }

            public void setInvitationCode(Object invitationCode) {
                this.invitationCode = invitationCode;
            }

            public String getUBinvitationCode() {
                return uBinvitationCode;
            }

            public void setUBinvitationCode(String uBinvitationCode) {
                this.uBinvitationCode = uBinvitationCode;
            }

            public int getUserStatus() {
                return userStatus;
            }

            public void setUserStatus(int userStatus) {
                this.userStatus = userStatus;
            }

            public long getURegisterTime() {
                return uRegisterTime;
            }

            public void setURegisterTime(long uRegisterTime) {
                this.uRegisterTime = uRegisterTime;
            }

            public String getGdp001() {
                return gdp001;
            }

            public void setGdp001(String gdp001) {
                this.gdp001 = gdp001;
            }

            public long getGdp002() {
                return gdp002;
            }

            public void setGdp002(long gdp002) {
                this.gdp002 = gdp002;
            }

            public Object getGdp003() {
                return gdp003;
            }

            public void setGdp003(Object gdp003) {
                this.gdp003 = gdp003;
            }

            public Object getGdp004() {
                return gdp004;
            }

            public void setGdp004(Object gdp004) {
                this.gdp004 = gdp004;
            }

            public int getGdp005() {
                return gdp005;
            }

            public void setGdp005(int gdp005) {
                this.gdp005 = gdp005;
            }

            public String getGdp006() {
                return gdp006;
            }

            public void setGdp006(String gdp006) {
                this.gdp006 = gdp006;
            }
        }

        public static class RateTypeListBean {
            private int rtId;
            private String rtName;
            private Object bili;
            private Object gdp001;
            private Object gdp002;
            private Object gdp003;
            private Object gdp004;
            private int gdp005;
            private Object gdp006;

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

            public Object getBili() {
                return bili;
            }

            public void setBili(Object bili) {
                this.bili = bili;
            }

            public Object getGdp001() {
                return gdp001;
            }

            public void setGdp001(Object gdp001) {
                this.gdp001 = gdp001;
            }

            public Object getGdp002() {
                return gdp002;
            }

            public void setGdp002(Object gdp002) {
                this.gdp002 = gdp002;
            }

            public Object getGdp003() {
                return gdp003;
            }

            public void setGdp003(Object gdp003) {
                this.gdp003 = gdp003;
            }

            public Object getGdp004() {
                return gdp004;
            }

            public void setGdp004(Object gdp004) {
                this.gdp004 = gdp004;
            }

            public int getGdp005() {
                return gdp005;
            }

            public void setGdp005(int gdp005) {
                this.gdp005 = gdp005;
            }

            public Object getGdp006() {
                return gdp006;
            }

            public void setGdp006(Object gdp006) {
                this.gdp006 = gdp006;
            }
        }
    }
}

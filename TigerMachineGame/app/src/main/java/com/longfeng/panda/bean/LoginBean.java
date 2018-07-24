package com.longfeng.panda.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/2/11.
 */

public class LoginBean implements Serializable{

    /**
     * status : 1
     * msg : 登录成功！
     * data : {"message":"success","users":{"uId":1,"uName":"admin","uGold":2114,"uIntegral":0,"userStatus":1,"machineVo":null},"rateTypeList":[{"rtId":1,"rtName":"1F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":2,"rtName":"2F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":3,"rtName":"5F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null}]}
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
         * message : success
         * users : {"uId":1,"uName":"admin","uGold":2114,"uIntegral":0,"userStatus":1,"machineVo":null}
         * rateTypeList : [{"rtId":1,"rtName":"1F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":2,"rtName":"2F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null},{"rtId":3,"rtName":"5F","bili":null,"gdp001":null,"gdp002":null,"gdp003":null,"gdp004":null,"gdp005":1,"gdp006":null}]
         */

        private String message;
        private UsersBean users;
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
        public static class UsersBean implements Serializable{
            /**
             * uId : 1
             * uName : admin
             * uGold : 2114
             * uIntegral : 0
             * userStatus : 1
             * machineVo : null
             */

            private int uId;
            private String uName;
            private int uGold;
            private int uIntegral;
            private int userStatus;
            private Object machineVo;

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

            public Object getMachineVo() {
                return machineVo;
            }

            public void setMachineVo(Object machineVo) {
                this.machineVo = machineVo;
            }
        }

        public static class RateTypeListBean implements Serializable{
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

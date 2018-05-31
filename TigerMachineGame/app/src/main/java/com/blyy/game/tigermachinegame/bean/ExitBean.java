package com.blyy.game.tigermachinegame.bean;

/**
 * Created by WuJingCheng
 * on 2018/2/20.
 */
public class ExitBean {

    /**
     * status : 1
     * msg : success
     * data : null
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

    public class DataBean{
        public String getuGold() {
            return uGold;
        }

        public void setuGold(String uGold) {
            this.uGold = uGold;
        }

        private String uGold;
    }
    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }
}

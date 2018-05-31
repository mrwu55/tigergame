package com.blyy.game.tigermachinegame.bean;

import java.util.List;

/**
 * Created by WuJingCheng
 * on 2018/5/27.
 */

public class LuckyBean {

    /**
     * status : 1
     * msg : 获取成功
     * data : {"messageVos":[{"msgId":2,"message":"五月积分双倍得，全天在线送金币，啦啦啦啦双方都很高","msgType":1,"showTime":0}]}
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
        private List<MessageVosBean> messageVos;

        public List<MessageVosBean> getMessageVos() {
            return messageVos;
        }

        public void setMessageVos(List<MessageVosBean> messageVos) {
            this.messageVos = messageVos;
        }

        public static class MessageVosBean {
            /**
             * msgId : 2
             * message : 五月积分双倍得，全天在线送金币，啦啦啦啦双方都很高
             * msgType : 1
             * showTime : 0
             */

            private int msgId;
            private String message;
            private int msgType;
            private int showTime;

            public int getMsgId() {
                return msgId;
            }

            public void setMsgId(int msgId) {
                this.msgId = msgId;
            }

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }

            public int getMsgType() {
                return msgType;
            }

            public void setMsgType(int msgType) {
                this.msgType = msgType;
            }

            public int getShowTime() {
                return showTime;
            }

            public void setShowTime(int showTime) {
                this.showTime = showTime;
            }
        }
    }
}

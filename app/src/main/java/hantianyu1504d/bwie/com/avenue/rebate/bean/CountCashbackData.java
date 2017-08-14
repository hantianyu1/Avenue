package hantianyu1504d.bwie.com.avenue.rebate.bean;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public class CountCashbackData {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"waitCashback":0,"countReally":0}
     */

    private String code;
    private String descirption;
    private ObjectBean object;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * waitCashback : 0
         * countReally : 0
         */

        private int waitCashback;
        private int countReally;

        public int getWaitCashback() {
            return waitCashback;
        }

        public void setWaitCashback(int waitCashback) {
            this.waitCashback = waitCashback;
        }

        public int getCountReally() {
            return countReally;
        }

        public void setCountReally(int countReally) {
            this.countReally = countReally;
        }
    }
}

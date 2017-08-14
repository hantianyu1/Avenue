package hantianyu1504d.bwie.com.avenue.rebate.bean;

import java.util.List;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/14
 */

public class RebateData {


    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : [{"cashbackMoney":500,"cashbackSpecificDate":1499744912000,"really":490,"recordCoding":"A20171001","taxPayment":10}]
     */

    private String code;
    private String descirption;
    private List<ObjectBean> object;

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

    public List<ObjectBean> getObject() {
        return object;
    }

    public void setObject(List<ObjectBean> object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * cashbackMoney : 500
         * cashbackSpecificDate : 1499744912000
         * really : 490
         * recordCoding : A20171001
         * taxPayment : 10
         */

        private int cashbackMoney;
        private long cashbackSpecificDate;
        private int really;
        private String recordCoding;
        private int taxPayment;

        public int getCashbackMoney() {
            return cashbackMoney;
        }

        public void setCashbackMoney(int cashbackMoney) {
            this.cashbackMoney = cashbackMoney;
        }

        public long getCashbackSpecificDate() {
            return cashbackSpecificDate;
        }

        public void setCashbackSpecificDate(long cashbackSpecificDate) {
            this.cashbackSpecificDate = cashbackSpecificDate;
        }

        public int getReally() {
            return really;
        }

        public void setReally(int really) {
            this.really = really;
        }

        public String getRecordCoding() {
            return recordCoding;
        }

        public void setRecordCoding(String recordCoding) {
            this.recordCoding = recordCoding;
        }

        public int getTaxPayment() {
            return taxPayment;
        }

        public void setTaxPayment(int taxPayment) {
            this.taxPayment = taxPayment;
        }
    }
}

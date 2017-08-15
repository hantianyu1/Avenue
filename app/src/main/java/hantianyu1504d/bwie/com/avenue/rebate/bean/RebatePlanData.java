package hantianyu1504d.bwie.com.avenue.rebate.bean;

import java.util.List;

/**
 * 类的作用:返利计划
 * author: 刘婕
 * date:2017/8/15
 */

public class RebatePlanData {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : [{"cashbackSpecificDate":1499184000000,"consumeLower":20001,"consumeUpper":5000000,"integral":0,"integralStyle":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502360023391.png","recordCoding":"B20171002"}]
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
         * cashbackSpecificDate : 1499184000000
         * consumeLower : 20001
         * consumeUpper : 5000000
         * integral : 0
         * integralStyle : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502360023391.png
         * recordCoding : B20171002
         */

        private long cashbackSpecificDate;
        private int consumeLower;
        private int consumeUpper;
        private int integral;
        private String integralStyle;
        private String recordCoding;

        public long getCashbackSpecificDate() {
            return cashbackSpecificDate;
        }

        public void setCashbackSpecificDate(long cashbackSpecificDate) {
            this.cashbackSpecificDate = cashbackSpecificDate;
        }

        public int getConsumeLower() {
            return consumeLower;
        }

        public void setConsumeLower(int consumeLower) {
            this.consumeLower = consumeLower;
        }

        public int getConsumeUpper() {
            return consumeUpper;
        }

        public void setConsumeUpper(int consumeUpper) {
            this.consumeUpper = consumeUpper;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public String getIntegralStyle() {
            return integralStyle;
        }

        public void setIntegralStyle(String integralStyle) {
            this.integralStyle = integralStyle;
        }

        public String getRecordCoding() {
            return recordCoding;
        }

        public void setRecordCoding(String recordCoding) {
            this.recordCoding = recordCoding;
        }
    }
}

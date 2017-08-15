package hantianyu1504d.bwie.com.avenue.rebate.bean;

import java.util.List;

/**
 * 类的作用:积分记录
 * author: 刘婕
 * date:2017/8/14
 */

public class RecordData {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":2,"totalPage":1,"list":[{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","name":"兰州拉面","money":500,"direction":0,"integral":50,"integralStyle":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502359324680.png","createTime":1501589252000},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","name":"天津大麻花","money":800,"direction":0,"integral":96,"integralStyle":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502359324680.png","createTime":1502086141000}]}
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
         * pageNum : 1
         * totalSize : 2
         * totalPage : 1
         * list : [{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","name":"兰州拉面","money":500,"direction":0,"integral":50,"integralStyle":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502359324680.png","createTime":1501589252000},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","name":"天津大麻花","money":800,"direction":0,"integral":96,"integralStyle":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502359324680.png","createTime":1502086141000}]
         */

        private int pageNum;
        private int totalSize;
        private int totalPage;
        private List<ListBean> list;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getTotalSize() {
            return totalSize;
        }

        public void setTotalSize(int totalSize) {
            this.totalSize = totalSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * beginIndex : 0
             * pageSize : 10
             * sort :
             * order : desc
             * name : 兰州拉面
             * money : 500
             * direction : 0
             * integral : 50
             * integralStyle : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502359324680.png
             * createTime : 1501589252000
             */

            private int beginIndex;
            private int pageSize;
            private String sort;
            private String order;
            private String name;
            private int money;
            private int direction;
            private int integral;
            private String integralStyle;
            private long createTime;

            public int getBeginIndex() {
                return beginIndex;
            }

            public void setBeginIndex(int beginIndex) {
                this.beginIndex = beginIndex;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public int getDirection() {
                return direction;
            }

            public void setDirection(int direction) {
                this.direction = direction;
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

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }
        }
    }
}

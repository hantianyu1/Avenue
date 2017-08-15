package hantianyu1504d.bwie.com.avenue.homepage.mode;

import java.util.List;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/11 20:53
 */
public class PagerAndShopsBean {

    /**首页分类列表
     * code : SUCCESS
     * descirption :
     * object : {"pageNum":1,"totalSize":5,"totalPage":1,"list":[{"recommendId":2,"picture":"two","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":4,"picture":"four","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":5,"picture":"five","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":6,"picture":"six","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":7,"picture":"seven","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""}]}
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
         * totalSize : 5
         * totalPage : 1
         * list : [{"recommendId":2,"picture":"two","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":4,"picture":"four","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":5,"picture":"five","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":6,"picture":"six","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""},{"recommendId":7,"picture":"seven","description":"","type":-10,"sequence":-10,"status":-10,"createTime":""}]
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
             * recommendId : 2
             * picture : two
             * description :
             * type : -10
             * sequence : -10
             * status : -10
             * createTime :
             */

            private int recommendId;
            private String picture;
            private String description;
            private int type;
            private int sequence;
            private int status;
            private String createTime;

            public int getRecommendId() {
                return recommendId;
            }

            public void setRecommendId(int recommendId) {
                this.recommendId = recommendId;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }
        }
    }
}

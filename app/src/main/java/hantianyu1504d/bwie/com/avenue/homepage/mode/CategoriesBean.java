package hantianyu1504d.bwie.com.avenue.homepage.mode;

import java.util.List;

/**
 * 类描述：首页分类
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/12 11:47
 */
public class CategoriesBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":20,"totalPage":2,"list":[{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":20,"categoryName":"游戏动漫","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522831155.png?Expires=1502526428&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=Obni%2BGS%2FgoLU8402CKPKX8NuKvI%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":19,"categoryName":"图书乐器","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522831155.png?Expires=1502526428&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=Obni%2BGS%2FgoLU8402CKPKX8NuKvI%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":18,"categoryName":"鲜花宠物","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":17,"categoryName":"汽车","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":16,"categoryName":"运动户外","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":15,"categoryName":"二手交易","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":14,"categoryName":"机票火车票","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":13,"categoryName":"家电","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":12,"categoryName":"服装","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":11,"categoryName":"充值缴费","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0}]}
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
         * totalSize : 20
         * totalPage : 2
         * list : [{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":20,"categoryName":"游戏动漫","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522831155.png?Expires=1502526428&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=Obni%2BGS%2FgoLU8402CKPKX8NuKvI%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":19,"categoryName":"图书乐器","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522831155.png?Expires=1502526428&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=Obni%2BGS%2FgoLU8402CKPKX8NuKvI%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":18,"categoryName":"鲜花宠物","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":17,"categoryName":"汽车","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":16,"categoryName":"运动户外","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":15,"categoryName":"二手交易","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":14,"categoryName":"机票火车票","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":13,"categoryName":"家电","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":12,"categoryName":"服装","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0},{"beginIndex":0,"pageSize":10,"sort":"","order":"desc","categoryId":11,"categoryName":"充值缴费","sequence":0,"parentId":null,"picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522898007.png?Expires=1502526489&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=66kRceemiakXiKGWwZNo5Ui4kZE%3D","type":null,"status":0}]
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
             * categoryId : 20
             * categoryName : 游戏动漫
             * sequence : 0
             * parentId : null
             * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502522831155.png?Expires=1502526428&OSSAccessKeyId=LTAIs5q5GaQnLxry&Signature=Obni%2BGS%2FgoLU8402CKPKX8NuKvI%3D
             * type : null
             * status : 0
             */

            private int beginIndex;
            private int pageSize;
            private String sort;
            private String order;
            private int categoryId;
            private String categoryName;
            private int sequence;
            private Object parentId;
            private String picture;
            private Object type;
            private int status;

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

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public int getSequence() {
                return sequence;
            }

            public void setSequence(int sequence) {
                this.sequence = sequence;
            }

            public Object getParentId() {
                return parentId;
            }

            public void setParentId(Object parentId) {
                this.parentId = parentId;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}

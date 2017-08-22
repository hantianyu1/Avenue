package hantianyu1504d.bwie.com.avenue.nearby.bean;

import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/8/16 11:51
 * 功能：附近商铺
 * 接口：http://123.57.33.185:8088//near/shops?
 longitude=116.4192930000&
 latitude=39.9768360000&
 categoryType=  1 - 美食
 7 - 休闲娱乐
 5 - 生活服务
 2 - 酒店
 */

public class ShopBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"pageNum":1,"totalSize":10,"totalPage":1,"list":[{"shopId":101,"shopName":"体育店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4118838310","latitude":"39.9747522601","address":"北京市朝阳区和平街街道胜古北社区","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":43,"distance":"0.6734535182049411"},{"shopId":4,"shopName":"过桥米线","shopDescription":"","phone":"19130385481","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4187502861","latitude":"39.9699176687","address":"北京市朝阳区和平街街道胜古庄社区东方向","integralRate":7,"commissionRate":0,"businessStartTime":"2017-08-14 17:04:27.0","businessEndTime":"2017-08-14 21:04:35.0","tags":"wifi","createTime":1501482122000,"perCapitaConsumption":50,"categoryId":21,"distance":"0.7717381487067728"},{"shopId":102,"shopName":"菜市场","shopDescription":"菜市场","phone":"18626535187","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119267464","latitude":"39.9824967600","address":"北京市朝阳区小关街道小关社区西北方向","integralRate":8,"commissionRate":10,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"0002-11-30 00:00:00.0","tags":"wifi","createTime":1501829773000,"perCapitaConsumption":50,"categoryId":42,"distance":"0.8901376944614683"},{"shopId":3,"shopName":"重庆小面","shopDescription":"","phone":"13892743383","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4130000000","latitude":"39.9704200000","address":"北京市朝阳区和平街街道胜古庄社区","integralRate":5,"commissionRate":12,"businessStartTime":"2017-08-14 17:04:12.0","businessEndTime":"2017-08-15 17:04:17.0","tags":"wifi","createTime":1500261797000,"perCapitaConsumption":50,"categoryId":21,"distance":"0.893729589388431"},{"shopId":100,"shopName":"水果店","shopDescription":"","phone":"15623148569","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4136433601","latitude":"39.9683718429","address":"北京市朝阳区和平街街道胜古庄社区西南方向","integralRate":9,"commissionRate":10,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车位","createTime":1501556364000,"perCapitaConsumption":50,"categoryId":42,"distance":"1.0586220856525677"},{"shopId":8,"shopName":"兰州拉面","shopDescription":"兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰：\"兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。\"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：\u201c雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面\u201d。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。 ","phone":"18309291927","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4222264290","latitude":"39.9647538159","address":"北京市朝阳区和平街街道和平家园","integralRate":3,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 21:00:00.0","tags":"wifi","createTime":1501487875000,"perCapitaConsumption":25,"categoryId":21,"distance":"1.368426828346673"},{"shopId":6,"shopName":"天津大麻花","shopDescription":"天津大麻花制作考究、料精货实。每个麻花中都夹有一棵由桃仁青梅、桂花等十几种小料配制成的什锦馅酥条，再和麻条、白条拧成5个花。用花生油微火炸透。出锅后放上冰糖和青红丝。特点香甜、酥脆，放置数月不绵软、不变质、不走味。","phone":"17791312895","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4262819290","latitude":"39.9653952074","address":"北京市朝阳区和平街街道和平东街社区西南方向","integralRate":10,"commissionRate":22,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 08:00:00.0","tags":"wifi","createTime":1501483834000,"perCapitaConsumption":34,"categoryId":21,"distance":"1.4066145599682316"},{"shopId":9,"shopName":"西北穆斯林","shopDescription":"","phone":"13636756429","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4179134369","latitude":"39.9625500148","address":"北京市东城区和平里街道化工社区东北方向","integralRate":11,"commissionRate":22,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi","createTime":1501489336000,"perCapitaConsumption":34,"categoryId":21,"distance":"1.5950767370985788"},{"shopId":103,"shopName":"菜市场","shopDescription":"菜市场","phone":"18626535187","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4130640030","latitude":"39.9908979742","address":"北京市朝阳区亚运村街道安慧里社区","integralRate":5,"commissionRate":10,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"0002-11-30 00:00:00.0","tags":"wifi","createTime":1501830692000,"perCapitaConsumption":30,"categoryId":42,"distance":"1.6535179315912678"},{"shopId":104,"shopName":"花店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119052887","latitude":"40.0180509945","address":"北京市通州区宋庄镇辛店村西北方向","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":18,"distance":"4.632303735992523"}]}
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
         * totalSize : 10
         * totalPage : 1
         * list : [{"shopId":101,"shopName":"体育店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4118838310","latitude":"39.9747522601","address":"北京市朝阳区和平街街道胜古北社区","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":43,"distance":"0.6734535182049411"},{"shopId":4,"shopName":"过桥米线","shopDescription":"","phone":"19130385481","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4187502861","latitude":"39.9699176687","address":"北京市朝阳区和平街街道胜古庄社区东方向","integralRate":7,"commissionRate":0,"businessStartTime":"2017-08-14 17:04:27.0","businessEndTime":"2017-08-14 21:04:35.0","tags":"wifi","createTime":1501482122000,"perCapitaConsumption":50,"categoryId":21,"distance":"0.7717381487067728"},{"shopId":102,"shopName":"菜市场","shopDescription":"菜市场","phone":"18626535187","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119267464","latitude":"39.9824967600","address":"北京市朝阳区小关街道小关社区西北方向","integralRate":8,"commissionRate":10,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"0002-11-30 00:00:00.0","tags":"wifi","createTime":1501829773000,"perCapitaConsumption":50,"categoryId":42,"distance":"0.8901376944614683"},{"shopId":3,"shopName":"重庆小面","shopDescription":"","phone":"13892743383","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4130000000","latitude":"39.9704200000","address":"北京市朝阳区和平街街道胜古庄社区","integralRate":5,"commissionRate":12,"businessStartTime":"2017-08-14 17:04:12.0","businessEndTime":"2017-08-15 17:04:17.0","tags":"wifi","createTime":1500261797000,"perCapitaConsumption":50,"categoryId":21,"distance":"0.893729589388431"},{"shopId":100,"shopName":"水果店","shopDescription":"","phone":"15623148569","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4136433601","latitude":"39.9683718429","address":"北京市朝阳区和平街街道胜古庄社区西南方向","integralRate":9,"commissionRate":10,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车位","createTime":1501556364000,"perCapitaConsumption":50,"categoryId":42,"distance":"1.0586220856525677"},{"shopId":8,"shopName":"兰州拉面","shopDescription":"兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰：\"兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。\"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：\u201c雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面\u201d。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。 ","phone":"18309291927","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4222264290","latitude":"39.9647538159","address":"北京市朝阳区和平街街道和平家园","integralRate":3,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 21:00:00.0","tags":"wifi","createTime":1501487875000,"perCapitaConsumption":25,"categoryId":21,"distance":"1.368426828346673"},{"shopId":6,"shopName":"天津大麻花","shopDescription":"天津大麻花制作考究、料精货实。每个麻花中都夹有一棵由桃仁青梅、桂花等十几种小料配制成的什锦馅酥条，再和麻条、白条拧成5个花。用花生油微火炸透。出锅后放上冰糖和青红丝。特点香甜、酥脆，放置数月不绵软、不变质、不走味。","phone":"17791312895","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4262819290","latitude":"39.9653952074","address":"北京市朝阳区和平街街道和平东街社区西南方向","integralRate":10,"commissionRate":22,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 08:00:00.0","tags":"wifi","createTime":1501483834000,"perCapitaConsumption":34,"categoryId":21,"distance":"1.4066145599682316"},{"shopId":9,"shopName":"西北穆斯林","shopDescription":"","phone":"13636756429","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4179134369","latitude":"39.9625500148","address":"北京市东城区和平里街道化工社区东北方向","integralRate":11,"commissionRate":22,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi","createTime":1501489336000,"perCapitaConsumption":34,"categoryId":21,"distance":"1.5950767370985788"},{"shopId":103,"shopName":"菜市场","shopDescription":"菜市场","phone":"18626535187","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4130640030","latitude":"39.9908979742","address":"北京市朝阳区亚运村街道安慧里社区","integralRate":5,"commissionRate":10,"businessStartTime":"0002-11-30 00:00:00.0","businessEndTime":"0002-11-30 00:00:00.0","tags":"wifi","createTime":1501830692000,"perCapitaConsumption":30,"categoryId":42,"distance":"1.6535179315912678"},{"shopId":104,"shopName":"花店","shopDescription":"体育用品","phone":"18240877076","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","markPicture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","longitude":"116.4119052887","latitude":"40.0180509945","address":"北京市通州区宋庄镇辛店村西北方向","integralRate":6,"commissionRate":12,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 20:00:00.0","tags":"wifi,停车场","createTime":1501829557000,"perCapitaConsumption":50,"categoryId":18,"distance":"4.632303735992523"}]
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
             * shopId : 101
             * shopName : 体育店
             * shopDescription : 体育用品
             * phone : 18240877076
             * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
             * verticalVersionPicture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
             * markPicture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
             * longitude : 116.4118838310
             * latitude : 39.9747522601
             * address : 北京市朝阳区和平街街道胜古北社区
             * integralRate : 6
             * commissionRate : 12
             * businessStartTime : 2017-07-13 08:00:00.0
             * businessEndTime : 2017-07-13 20:00:00.0
             * tags : wifi,停车场
             * createTime : 1501829557000
             * perCapitaConsumption : 50
             * categoryId : 43
             * distance : 0.6734535182049411
             */

            private int shopId;
            private String shopName;
            private String shopDescription;
            private String phone;
            private String picture;
            private String verticalVersionPicture;
            private String markPicture;
            private String longitude;
            private String latitude;
            private String address;
            private int integralRate;
            private int commissionRate;
            private String businessStartTime;
            private String businessEndTime;
            private String tags;
            private long createTime;
            private int perCapitaConsumption;
            private int categoryId;
            private String distance;

            public int getShopId() {
                return shopId;
            }

            public void setShopId(int shopId) {
                this.shopId = shopId;
            }

            public String getShopName() {
                return shopName;
            }

            public void setShopName(String shopName) {
                this.shopName = shopName;
            }

            public String getShopDescription() {
                return shopDescription;
            }

            public void setShopDescription(String shopDescription) {
                this.shopDescription = shopDescription;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getVerticalVersionPicture() {
                return verticalVersionPicture;
            }

            public void setVerticalVersionPicture(String verticalVersionPicture) {
                this.verticalVersionPicture = verticalVersionPicture;
            }

            public String getMarkPicture() {
                return markPicture;
            }

            public void setMarkPicture(String markPicture) {
                this.markPicture = markPicture;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getIntegralRate() {
                return integralRate;
            }

            public void setIntegralRate(int integralRate) {
                this.integralRate = integralRate;
            }

            public int getCommissionRate() {
                return commissionRate;
            }

            public void setCommissionRate(int commissionRate) {
                this.commissionRate = commissionRate;
            }

            public String getBusinessStartTime() {
                return businessStartTime;
            }

            public void setBusinessStartTime(String businessStartTime) {
                this.businessStartTime = businessStartTime;
            }

            public String getBusinessEndTime() {
                return businessEndTime;
            }

            public void setBusinessEndTime(String businessEndTime) {
                this.businessEndTime = businessEndTime;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getPerCapitaConsumption() {
                return perCapitaConsumption;
            }

            public void setPerCapitaConsumption(int perCapitaConsumption) {
                this.perCapitaConsumption = perCapitaConsumption;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getDistance() {
                return distance;
            }

            public void setDistance(String distance) {
                this.distance = distance;
            }
        }
    }
}

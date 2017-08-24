package hantianyu1504d.bwie.com.avenue.nearby.bean;

/**
 * 作者：李飞宇
 * 时间：2017/8/16 11:58
 * 功能：商铺详情
 * 接口： http://123.57.33.185:8088/findShopById   ?shopId=8
 * post请求： ?shopId=8
 */

public class ShopDetailsBean {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"shopId":8,"shopName":"兰州拉面","shopDescription":"兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰：\"兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。\"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：\u201c雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面\u201d。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。 ","phone":"18309291927","picture":"http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg","verticalVersionPicture":"","markPicture":"","longitude":"47.2","latitude":"112.3","address":"亚美大厦","integralRate":10,"commissionRate":-2,"businessStartTime":"2017-07-13 08:00:00.0","businessEndTime":"2017-07-13 21:00:00.0","tags":"wifi","createTime":1501487875000,"perCapitaConsumption":25,"categoryId":21,"distance":""}
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
         * shopId : 8
         * shopName : 兰州拉面
         * shopDescription : 兰州牛肉拉面技术，堪称中国一绝。拉面制作在中国流传已久，清代王憺望曾作《兰州牛肉面吟》曰："兰州拉面天下功，制法来自怀庆府。汤如甘露面似金，一条入口赛神仙。"由此可见兰州拉面制作久负盛名，天下第一之技法。兰州牛肉拉面是技术含量较高的品种，尤其是马家大爷牛肉面，实践性很强，其方法和技巧，用文字表述，您只能看个七八成。其真功夫方法和技巧只能由师傅言传身教，面授机宜，弟子要边悟边学，边悟边练，方能渐入其境界。著名的马家大爷牛肉面的清香与可口，正如清代张澍诗中所写的：“雨过金城关，白马激溜回。几度黄河水，临流此路穷。拉面千丝香，惟独马家爷。美味难再期，回首故乡远。日出念真经，暮落白塔空。焚香自叹息，只盼牛肉面”。 兰州牛肉拉面面的制作的五大步奏无论从选料、和面、醒面，还是溜条和拉面，都巧妙地运用了所含成分的物理性能，即面筋蛋白质的延伸性和弹性。
         * phone : 18309291927
         * picture : http://dadao-file.oss-cn-beijing.aliyuncs.com/dadao/1502700958933.jpg
         * verticalVersionPicture :
         * markPicture :
         * longitude : 47.2
         * latitude : 112.3
         * address : 亚美大厦
         * integralRate : 10
         * commissionRate : -2
         * businessStartTime : 2017-07-13 08:00:00.0
         * businessEndTime : 2017-07-13 21:00:00.0
         * tags : wifi
         * createTime : 1501487875000
         * perCapitaConsumption : 25
         * categoryId : 21
         * distance :
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

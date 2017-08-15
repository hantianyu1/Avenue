package hantianyu1504d.bwie.com.avenue.nearby.bean;

import java.util.List;

/**
 * 作者：李飞宇
 * 时间：2017/8/14 19:20
 * 功能：附近
 */

public class NearbyShopBean {
/*    //图片
    private String picture;
    //商铺名称
    private String shopName;
    //积分率
    private int integralRate;
    //人均消费
    private int perCapitaConsumption;*/
    /**
     * resultcode : 200
     * reason : 查询成功
     * result : [{"name":"德丽苑度假村","navigation":"上海酒店>>近郊>>崇明>>度假村>>德丽苑度假村","city":"上海","area":"近郊","address":"崇明东平森林公园东侧","phone":"021-59643155","latitude":"31.66808","longitude":"121.54002","stars":"0.0","avg_price":"","photos":"http://i3.s2.dpfile.com/2010-12-20/6201691_b.jpg(249x249)/thumb.jpg","tags":"度假村,崇明","all_remarks":"4","very_good_remarks":"0","good_remarks":"1","common_remarks":"0","bad_remarks":"0","very_bad_remarks":"0","product_rating":"","environment_rating":"","service_rating":"","recommended_products":"","recommended_dishes":"","nearby_shops":"瀛都宾馆"},{"name":"黄山酒店","navigation":"无锡酒店>>新区>>旺庄>>更多酒店住宿>>黄山酒店","city":"无锡","area":"新区","address":"长江公路大桥西侧","phone":"0510-86856596","latitude":"31.67063","longitude":"121.54213","stars":"0.0","avg_price":"","photos":"http://i2.dpfile.com/s/img/shopnopic_x249.9182bfb823d671e1eb86a239ca54f88e.png","tags":"更多酒店住宿,旺庄","all_remarks":"","very_good_remarks":"","good_remarks":"","common_remarks":"","bad_remarks":"","very_bad_remarks":"","product_rating":"","environment_rating":"","service_rating":"","recommended_products":"","recommended_dishes":"","nearby_shops":""},{"name":"昌茂酒家","navigation":"上海餐厅>>近郊>>崇明>>本帮江浙菜>>农家菜>>昌茂酒家","city":"上海","area":"近郊","address":"崇明县北沿公路1647弄732号(近长江公路)","phone":"021-59668272","latitude":"31.67416","longitude":"121.5385","stars":"0.0","avg_price":"","photos":"http://i1.s1.dpfile.com/pc/f59ce7b879eea202f36692aa9ead9dac(249x249)/thumb.jpg","tags":"农家菜,崇明","all_remarks":"5","very_good_remarks":"3","good_remarks":"1","common_remarks":"1","bad_remarks":"0","very_bad_remarks":"0","product_rating":"","environment_rating":"","service_rating":"","recommended_products":"","recommended_dishes":"","nearby_shops":"东平国家森林公园烧烤,紫海鹭缘浪漫庄园餐厅,宝岛度假村御花园中餐厅"}]
     */

    private String resultcode;
    private String reason;
    private List<ResultBean> result;

    public String getResultcode() {
        return resultcode;
    }

    public void setResultcode(String resultcode) {
        this.resultcode = resultcode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * name : 德丽苑度假村
         * navigation : 上海酒店>>近郊>>崇明>>度假村>>德丽苑度假村
         * city : 上海
         * area : 近郊
         * address : 崇明东平森林公园东侧
         * phone : 021-59643155
         * latitude : 31.66808
         * longitude : 121.54002
         * stars : 0.0
         * avg_price :
         * photos : http://i3.s2.dpfile.com/2010-12-20/6201691_b.jpg(249x249)/thumb.jpg
         * tags : 度假村,崇明
         * all_remarks : 4
         * very_good_remarks : 0
         * good_remarks : 1
         * common_remarks : 0
         * bad_remarks : 0
         * very_bad_remarks : 0
         * product_rating :
         * environment_rating :
         * service_rating :
         * recommended_products :
         * recommended_dishes :
         * nearby_shops : 瀛都宾馆
         */

        private String name;
        private String navigation;
        private String city;
        private String area;
        private String address;
        private String phone;
        private String latitude;
        private String longitude;
        private String stars;
        private String avg_price;
        private String photos;
        private String tags;
        private String all_remarks;
        private String very_good_remarks;
        private String good_remarks;
        private String common_remarks;
        private String bad_remarks;
        private String very_bad_remarks;
        private String product_rating;
        private String environment_rating;
        private String service_rating;
        private String recommended_products;
        private String recommended_dishes;
        private String nearby_shops;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNavigation() {
            return navigation;
        }

        public void setNavigation(String navigation) {
            this.navigation = navigation;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public String getAvg_price() {
            return avg_price;
        }

        public void setAvg_price(String avg_price) {
            this.avg_price = avg_price;
        }

        public String getPhotos() {
            return photos;
        }

        public void setPhotos(String photos) {
            this.photos = photos;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getAll_remarks() {
            return all_remarks;
        }

        public void setAll_remarks(String all_remarks) {
            this.all_remarks = all_remarks;
        }

        public String getVery_good_remarks() {
            return very_good_remarks;
        }

        public void setVery_good_remarks(String very_good_remarks) {
            this.very_good_remarks = very_good_remarks;
        }

        public String getGood_remarks() {
            return good_remarks;
        }

        public void setGood_remarks(String good_remarks) {
            this.good_remarks = good_remarks;
        }

        public String getCommon_remarks() {
            return common_remarks;
        }

        public void setCommon_remarks(String common_remarks) {
            this.common_remarks = common_remarks;
        }

        public String getBad_remarks() {
            return bad_remarks;
        }

        public void setBad_remarks(String bad_remarks) {
            this.bad_remarks = bad_remarks;
        }

        public String getVery_bad_remarks() {
            return very_bad_remarks;
        }

        public void setVery_bad_remarks(String very_bad_remarks) {
            this.very_bad_remarks = very_bad_remarks;
        }

        public String getProduct_rating() {
            return product_rating;
        }

        public void setProduct_rating(String product_rating) {
            this.product_rating = product_rating;
        }

        public String getEnvironment_rating() {
            return environment_rating;
        }

        public void setEnvironment_rating(String environment_rating) {
            this.environment_rating = environment_rating;
        }

        public String getService_rating() {
            return service_rating;
        }

        public void setService_rating(String service_rating) {
            this.service_rating = service_rating;
        }

        public String getRecommended_products() {
            return recommended_products;
        }

        public void setRecommended_products(String recommended_products) {
            this.recommended_products = recommended_products;
        }

        public String getRecommended_dishes() {
            return recommended_dishes;
        }

        public void setRecommended_dishes(String recommended_dishes) {
            this.recommended_dishes = recommended_dishes;
        }

        public String getNearby_shops() {
            return nearby_shops;
        }

        public void setNearby_shops(String nearby_shops) {
            this.nearby_shops = nearby_shops;
        }
    }
    //

}

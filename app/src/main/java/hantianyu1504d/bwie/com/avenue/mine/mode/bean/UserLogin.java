package hantianyu1504d.bwie.com.avenue.mine.mode.bean;

import com.google.gson.Gson;

/**
 * Created by lichaohui on 2017/8/15.
 */

public class UserLogin {


    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : {"phone":"15229255596","createTime":1501829234000,"nickname":"大道用户5596","userId":115,"picture":"","token":"7a86b6ca07dfb2770e6d8b7f86756bb6"}
     */

    public String code;
    public String descirption;
    public ObjectBean object;

    public static UserLogin objectFromData(String str) {

        return new Gson().fromJson(str, UserLogin.class);
    }

    public static class ObjectBean {
        /**
         * phone : 15229255596
         * createTime : 1501829234000
         * nickname : 大道用户5596
         * userId : 115
         * picture :
         * token : 7a86b6ca07dfb2770e6d8b7f86756bb6
         */

        public String phone;
        public long createTime;
        public String nickname;
        public int userId;
        public String picture;
        public String token;

        public static ObjectBean objectFromData(String str) {

            return new Gson().fromJson(str, ObjectBean.class);
        }
    }
}

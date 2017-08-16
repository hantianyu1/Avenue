package hantianyu1504d.bwie.com.avenue.mine.mode.bean;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * Created by lichaohui on 2017/8/14.
 */

public class UserLog  implements Serializable {
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

    public static UserLog objectFromData(String str) {

        return new Gson().fromJson(str, UserLog.class);
    }
}

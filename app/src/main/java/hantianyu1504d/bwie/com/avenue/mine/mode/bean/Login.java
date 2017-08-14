package hantianyu1504d.bwie.com.avenue.mine.mode.bean;

import com.google.gson.Gson;

/**
 * Created by lichaohui on 2017/8/11.
 */

public class Login {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object : 18309291927
     */

    public String code;
    public String descirption;
    public String object;

    public static Login objectFromData(String str) {

        return new Gson().fromJson(str, Login.class);
    }
}

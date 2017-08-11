package hantianyu1504d.bwie.com.avenue.homepage.mode.bean;

import com.google.gson.Gson;

/**
 * Created by lichaohui on 2017/8/11.
 */

public class Note {

    /**
     * code : 1000
     * descirption : 系统处理成功
     * object :
     */

    public String code;
    public String descirption;
    public String object;

    public static Note objectFromData(String str) {

        return new Gson().fromJson(str, Note.class);
    }
}

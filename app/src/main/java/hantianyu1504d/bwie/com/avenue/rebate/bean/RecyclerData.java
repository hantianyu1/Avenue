package hantianyu1504d.bwie.com.avenue.rebate.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 类的作用:
 * author: 刘婕
 * date:2017/8/12
 */

public class RecyclerData {
    private String title;
    private String name;

    public RecyclerData(String title, String name) {
        this.title = title;
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<RecyclerData> initData() {
        List<RecyclerData> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            RecyclerData user = new RecyclerData("A2017023"+i,"2017年6月21日兑换"+i);
            list.add(user);
        }

        return list;
    }
}

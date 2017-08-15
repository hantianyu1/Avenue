package hantianyu1504d.bwie.com.avenue.mine.mode.utils;

/**
 * Created by lichaohui on 2017/8/15.
 */

public class CommonUtils {
    private static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if (0 < timeD && timeD < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}

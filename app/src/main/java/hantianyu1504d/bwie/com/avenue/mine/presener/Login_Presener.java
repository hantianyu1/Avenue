package hantianyu1504d.bwie.com.avenue.mine.presener;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.core.utils.RegexUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.TUtil;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.Note;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.UserLog;
import hantianyu1504d.bwie.com.avenue.mine.mode.net.HttpUtils;
import hantianyu1504d.bwie.com.avenue.mine.mode.net.NetDataCallBack;
import hantianyu1504d.bwie.com.avenue.mine.mode.utils.MD5;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.IMainView;

/**
 * Created by lichaohui on 2017/8/11.
 */

public class Login_Presener extends BasePresener<IMainView> {

    private MD5 md5;

    private Login_Presener() {
        if (md5 != null) {
            md5 = new MD5();
        }
    }

    private static volatile Login_Presener instanct;

    public static Login_Presener getInstanct() {
        if (instanct == null) {
            synchronized (Login_Presener.class) {
                if (instanct == null) {
                    instanct = new Login_Presener();
                }
            }
        }
        return instanct;
    }

    private StringBuffer stringBuffer;
    private HashMap<String, String> hashMap = new HashMap<>();

    /*
    * 获取验证码
    *
    * */
    public void Login_Post_Presener(String phone, final Context context) {

        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();

            return;
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("sendCode/");
        HttpUtils instant = HttpUtils.getInstant();
        hashMap.put("phone", phone);
        hashMap.put("type", "1");
        hashMap.put("merchant", "0");
        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String msg) {
                if (o != null && getView() != null) {
                    Note login = (Note) o;
                    String descirption = login.descirption;
                    String code = login.code;
                    getView().sccessCallBack(login, msg);
                    if (code.equals("-1")) {
                        TUtil.show(context, descirption, Toast.LENGTH_LONG);
                    } else if (code.equals("2006")) {
                        TUtil.show(context, descirption, Toast.LENGTH_LONG);
                    } else if (code.equals("2005")) {
                        TUtil.show(context, descirption, Toast.LENGTH_LONG);
                    } else if (code.equals("1000")) {
                        TUtil.show(context, descirption, Toast.LENGTH_LONG);
                    }
                }
            }

            @Override
            public void errCallBack(String err, int code) {

            }
        }, Note.class);
    }

    /*
   * 注册 页面
   *
   * */
    public void Login_Post_Presener(String phone, String password, String code, final Context context) {

        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password) || TextUtils.isEmpty(code)) {
            Toast.makeText(context, "输入数据为空", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        String s = md5.Md5(password);
        stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("user/register/");
        HttpUtils instant = HttpUtils.getInstant();
        hashMap.put("phone", phone);
        hashMap.put("merchant", "0");
        hashMap.put("code", code);
        hashMap.put("password", s);


        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String str) {
                if (o != null && getView() != null) {
                    Note note = (Note) o;
                    Toast.makeText(context, "" + note.descirption, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void errCallBack(String err, int code) {
            }
        }, Note.class);
    }

    /*
    *
    * 登录 页面
    * */
    public void loadPresener(String phone, String password, final Context context) {

        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "密码为空", Toast.LENGTH_SHORT).show();
            return;
        }
        String phone1 = md5.Md5(phone);
        stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("/user/login/");
        HttpUtils instant = HttpUtils.getInstant();
        hashMap.put("phone", phone1);
        hashMap.put("password", password);
        hashMap.put("merchant", "0");
        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String msg) {
                if (o != null && getView() != null) {
                    UserLog note = (UserLog) o;
                    if (note.code.equals("1000")) {
                        Toast.makeText(context, "登录成功", Toast.LENGTH_SHORT).show();
                    } else if (note.code.equals("1002")) {
                        getView().errCallBack(note.descirption, 2000);
                    }
                }
            }

            @Override
            public void errCallBack(String err, int code) {


            }
        }, UserLog.class);
    }


}

package hantianyu1504d.bwie.com.avenue.mine.presener;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.core.utils.RegexUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.core.utils.TUtil;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.Login_Base;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.Note;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.UserLogin;
import hantianyu1504d.bwie.com.avenue.mine.mode.net.HttpUtils;
import hantianyu1504d.bwie.com.avenue.mine.mode.net.NetDataCallBack;
import hantianyu1504d.bwie.com.avenue.mine.mode.utils.MD5;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.IMainView;

/**
 * Created by lichaohui on 2017/8/11.
 */

public class Login_Presener extends BasePresener<IMainView> {

    private MD5 md5;
    private HashMap<String, String> hashMap;

    public Login_Presener() {
        if (md5 == null) {
            md5 = new MD5();
        }
    }

    private StringBuffer stringBuffer;

    /*
    * 获取验证码
    * 0 登录  1 注册  2 找回密码
    * */
    public <T> boolean Login_Post_Presener(int code, String phone, final Context context, Class<T> tClass) {
       HashMap<String, String> hashMap = new HashMap<>();
        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            return true;
        }
        stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("sendCode/");
        hashMap.put("phone", phone);
        hashMap.put("type", "" + code);
        hashMap.put("merchant", "0");
        HttpUtils instant = HttpUtils.getInstant();
        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String str) {
                if (o != null && getView() != null) {
                    Note login = (Note) o;
                    String descirption = login.descirption;
                    String code = login.code;
                    Log.d("zzz", "code" + code + "descirption" + descirption);
                    TUtil.show(context, descirption, Toast.LENGTH_LONG);
                    if (code.equals("1000")){
                        getView().sccessCallBack(true,str);
                    }
                }
            }
            @Override
            public void errCallBack(String err, int code) {

            }
        }, tClass);
        return false;
    }

    /*
   * 注册 页面
   *
   * //注册  0      找回密码  1
   * */
    public void Login_Post_Presener(int tag, String phone, String password, String code, final Context context) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(password) || TextUtils.isEmpty(code)) {
            Toast.makeText(context, "输入数据为空", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确" + phone, Toast.LENGTH_SHORT).show();
            return;
        }
        HttpUtils instant = HttpUtils.getInstant();
        String s = md5.Md5(password);
        switch (tag) {
            //注册
            case 0:
                hashMap = new HashMap<>();

                stringBuffer = new StringBuffer();
                stringBuffer.append(Canstant.anim.PATH)
                        .append("user/register/");
                hashMap.put("phone", phone);
                hashMap.put("merchant", "0");
                hashMap.put("code", code);
                hashMap.put("password", s);
                break;
            // 找回密码 ：
            case 1:
               hashMap = new HashMap<>();

                stringBuffer = new StringBuffer();
                stringBuffer.append(Canstant.anim.PATH)
                        .append("user/forgetPassword/");
                hashMap.put("phone", phone);
                hashMap.put("token", "");
                hashMap.put("code", code);
                hashMap.put("password", s);
                break;
        }
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

        hashMap = new HashMap<>();
        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(context, "密码为空", Toast.LENGTH_SHORT).show();
            return;
        }
        if (md5 == null) {
            md5 = new MD5();
        }
        String md5password = md5.Md5(password);
        stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("user/login/");
        HttpUtils instant = HttpUtils.getInstant();
        hashMap.put("phone", phone);
        hashMap.put("password", md5password);
        hashMap.put("merchant", "0");
        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String msg) {
                if (o != null && getView() != null) {
                    Login_Base note = (Login_Base) o;
                    String descirption = note.descirption;
                    String code = note.code;
                    if (code.equals("1000")) {
                        String token = UserLogin.objectFromData(msg).object.token;
                        SPUtil.put(context, Canstant.anim.MINE_KEY, msg);
                        SPUtil.put(context, Canstant.anim.TOKEN, token);
                    }
                    Toast.makeText(context, descirption, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void errCallBack(String err, int code) {

            }
        }, Login_Base.class);
    }


}

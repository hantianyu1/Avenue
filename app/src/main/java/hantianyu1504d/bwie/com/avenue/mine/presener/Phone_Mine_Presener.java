package hantianyu1504d.bwie.com.avenue.mine.presener;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.HashMap;

import hantianyu1504d.bwie.com.avenue.application.Canstant;
import hantianyu1504d.bwie.com.avenue.core.utils.RegexUtils;
import hantianyu1504d.bwie.com.avenue.core.utils.SPUtil;
import hantianyu1504d.bwie.com.avenue.mine.mode.bean.Login_Base;
import hantianyu1504d.bwie.com.avenue.mine.mode.net.HttpUtils;
import hantianyu1504d.bwie.com.avenue.mine.mode.net.NetDataCallBack;
import hantianyu1504d.bwie.com.avenue.mine.view.iview.IPhone_Mine_View;
/**
 * token	string	用户唯一秘钥	是
 * phone	string	手机号	是
 * code	string	验证码	是
 * <p>
 * Created by lichaohui on 2017/8/14.
 */
public class Phone_Mine_Presener extends BasePresener<IPhone_Mine_View> {

    private HttpUtils instant;

    private void Phone_Mine_Presener() {
        instant = HttpUtils.getInstant();
    }

    public void load_Phone_Mine(String phone, String code, final Context context) {
        if (TextUtils.isEmpty(phone) || TextUtils.isEmpty(code)) {
            Toast.makeText(context, "账号密码为空 ", Toast.LENGTH_SHORT).show();
        }
        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("user/updatePhone/");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("token", (String) SPUtil.get(context, Canstant.anim.TOKEN, ""));
        hashMap.put("phone", phone);
        hashMap.put("code", code);
        if (instant == null) {
            instant = HttpUtils.getInstant();
        }
        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String str) {
                if (o != null && getView() != null) {
                    Login_Base note = (Login_Base) o;
                    String descirption = note.descirption;
                    Toast.makeText(context, "" + descirption, Toast.LENGTH_SHORT).show();
                    getView().sccessCallBack(o, str);
                }
            }

            @Override
            public void errCallBack(String err, int code) {
            }
        }, Login_Base.class);
    }


    /*
    * 获取验证码
    * */
    public void load_Phone_verification(String phone, final Context context) {
        boolean mobileExact = RegexUtils.isMobileExact(phone);
        if (!mobileExact) {
            Toast.makeText(context, "手机号格式不正确", Toast.LENGTH_SHORT).show();
            return;
        }
        if (instant == null) {
            instant = HttpUtils.getInstant();
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Canstant.anim.PATH)
                .append("sendCode/");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("phone", phone);
        hashMap.put("type", "2");
        hashMap.put("merchant", "0");

        instant.loadDataPostCallBack(stringBuffer.toString(), hashMap, new NetDataCallBack() {
            @Override
            public void sccessCallBack(Object o, String str) {
                if (o != null && getView() != null) {
                    Login_Base login_base = (Login_Base) o;
                    Toast.makeText(context, "" + login_base.descirption, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void errCallBack(String err, int code) {

            }
        }, Login_Base.class);
    }


}

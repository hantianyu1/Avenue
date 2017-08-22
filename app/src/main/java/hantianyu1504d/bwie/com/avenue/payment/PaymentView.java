package hantianyu1504d.bwie.com.avenue.payment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/15 21:51
 */
public class PaymentView extends View{
    private Paint mPaint;
    private int inputNum=0;//当前输入的密码个数
    private int passwordNum=6;//密码个数

    private int boundWidth=2;//外层框线条粗细
    private int boundColor= Color.BLACK;//外层框线条颜色
    private int boundRadius=0;//外框圆角半径

    private int deliverWidth=1;//分割线粗细
    private int deliverColor=Color.GRAY;//分割线条颜色
    private int deliverPadding=5;//分割线距离框的大小

    private int circleRadius =15;//密码圆点半径大小
    private int circleColor= Color.BLACK;//密码圆点颜色

    private StringBuilder currentPassword;//用户输入的密码
    private int width;
    private int height;
    private int squareWidth;
    public PaymentView(Context context) {
        this(context,null);
    }

    public PaymentView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PaymentView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        currentPassword=new StringBuilder();
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getWidth();
        height = getHeight();
        squareWidth=width/6;
    }
}

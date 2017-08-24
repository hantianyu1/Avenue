package hantianyu1504d.bwie.com.avenue.myview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * 类描述：
 * 创建人：韩天宇
 * 班级：移动通信1504D
 * 创建时间：2017/8/22 14:57
 */
public class MyViewPager extends ViewPager{


    public MyViewPager(Context context) {
        this(context,null);
    }

    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = 0;
        // 下面遍历所有child的高度
        Log.e("onMeasure", "onMeasure: "+getCurrentItem());
        if(getChildCount() > 1) {
            if (getCurrentItem() == 0) {
                View child = getChildAt(0);

                child.measure(widthMeasureSpec,
                        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                height = h;
            } else {
                View child = getChildAt(1);

                child.measure(widthMeasureSpec,
                        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
                int h = child.getMeasuredHeight();
                height = h;
            }
//        if (getChildCount() > 1) {
//            int h = ((LinearLayout)getChildAt(1)).getChildAt(0).getMeasuredHeight();
//            Log.e("onMeasure", "onMeasure height: "+h);
//            for (int i = 0; i < getChildCount(); i++) {
//                View child = getChildAt(i);
//
//                child.measure(widthMeasureSpec,
//                        MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
//                int h = child.getMeasuredHeight();
//                // 采用最大的view的高度
////            if (h > height) {
////                height = h;
////            }
////                height += h;
////            }
//            if (h != height) {
//                height = h;
//            }
//        }
        }
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(height,
                MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void refresh(int totalHeight) {
//        int h = ((LinearLayout)getChildAt(1)).getChildAt(0).getMeasuredHeight();
        super.measure(getMeasuredWidth(), totalHeight);
    }

}

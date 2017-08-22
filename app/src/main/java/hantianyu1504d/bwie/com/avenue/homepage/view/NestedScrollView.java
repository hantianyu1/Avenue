package hantianyu1504d.bwie.com.avenue.homepage.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * 作者：李飞宇
 * 时间：2017/8/22 10:33
 * 功能：
 */

public class NestedScrollView extends RecyclerView {


    public NestedScrollView(Context context) {
        this(context,null);
    }

    public NestedScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public NestedScrollView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //设置为Integer.MAX_VALUE>>2 是listview全部展开
        int measureSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
//设置为400是设置listview的高度只能有400 不全部展开   实现可以滑动的效果
        int measureSpec1 = MeasureSpec.makeMeasureSpec(900, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, measureSpec1);
    }


}

package cn.pangkai.mineselfviewdemo.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import cn.pangkai.mineselfviewdemo.R;

/**
 * Created by Administrator on 2018/6/20.
 * 绘制一系列从小到大且颜色交替变换的同心圆
 */

public class MineSeveralColorCircle extends View {

    private String TAG = "MineSeveralColorCircle";

    /**
     * 画笔
     */
    private Paint mPaint;

    /**
     * 中心
     */
    private Point mCenter;

    /**
     * 半径
     */
    private float mRadius;

    public MineSeveralColorCircle(Context context) {
        this(context, null);
    }

    public MineSeveralColorCircle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MineSeveralColorCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //创建用于回执的画刷
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        //我们要绘制填充的圆
        mPaint.setStyle(Paint.Style.FILL);
        //创建圆的中心点
        mCenter = new Point();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        Log.e(TAG, "走到了 111111111111111111");

        int width;
        int height;

        //确定内容的理想大小，无约束
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.size_1000px);

        int contentWidth = dimensionPixelSize;
        int contentHeight = dimensionPixelSize;

        width = getMeasurement(widthMeasureSpec, contentWidth);
        height = getMeasurement(heightMeasureSpec, contentHeight);

        //必须使用测试值调用此方法
        setMeasuredDimension(width, height);

        Log.e(TAG, "走到了 2222222222222222");
    }

    /**
     * 用于测量宽度和高度的辅助方法
     *
     * @param measureSpec
     * @param contentSize
     * @return
     */
    private int getMeasurement(int measureSpec, int contentSize) {

        int specSize = MeasureSpec.getSize(measureSpec);
        switch (MeasureSpec.getMode(measureSpec)) {

            case MeasureSpec.AT_MOST:
                //返回俩个中的叫小的
                return Math.min(specSize, contentSize);

            case MeasureSpec.UNSPECIFIED:
                return contentSize;

            case MeasureSpec.EXACTLY:
                return specSize;

            default:
                return 0;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.e(TAG, "走到了 333333333333");
        if (w != oldw || h != oldh) {
            //有变化，复位参数
            mCenter.x = w / 2;
            mCenter.y = h / 2;
            mRadius = Math.min(mCenter.x, mCenter.y);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Log.e(TAG, "走到了 444444444444");
        //绘制一系列从小到大且颜色交替变换的同心圆

        //全半径
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius, mPaint);

        //0.8半径
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.8f, mPaint);
//
//        //0.6半径
        mPaint.setColor(Color.BLUE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.6f, mPaint);

        //0.4半径
        mPaint.setColor(Color.WHITE);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.4f, mPaint);

        //0.1半径
        mPaint.setColor(Color.RED);
        canvas.drawCircle(mCenter.x, mCenter.y, mRadius * 0.1f, mPaint);

    }
}

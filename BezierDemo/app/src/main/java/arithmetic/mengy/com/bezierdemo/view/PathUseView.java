package arithmetic.mengy.com.bezierdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import arithmetic.mengy.com.bezierdemo.R;
import arithmetic.mengy.com.bezierdemo.utils.ScreenUtils;

/**
 * Author：mengyuan
 * Date  : 2017/4/17下午3:08
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class PathUseView extends View {
    private Paint blackPaint;


    public PathUseView(Context context) {
        super(context);

        initView();
    }

    public PathUseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();

    }

    public PathUseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();

    }

    private void initView() {
        initPaint();
    }

    private void initPaint() {
        blackPaint = new Paint();
        blackPaint.setColor(getResources().getColor(R.color.c_000000));
        blackPaint.setStyle(Paint.Style.STROKE);
        blackPaint.setStrokeWidth(ScreenUtils.dp2Px(5));
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path1 = new Path();
        Path path2 = new Path();
        //画一条(0,0)-(100,100)的线条
        path1.lineTo(100, 100);
        //将起点移动到(200,200)
        path1.moveTo(200, 200);
        //画一条(200,200)-(1000,1000)的线条
        path1.lineTo(1000, 100);
        //取消上个线条并重新绘制(200,200)-(500,200)
        path1.setLastPoint(500, 200);
        //画一条(500,500)-(600,600)线条
        path1.lineTo(600, 600);
        //连接(100,500)-(200,200)
        path1.close();
        //画一个圆心为(100,100)，半径为100的圆
        path1.addCircle(100, 100, 100, Path.Direction.CW);
        //规定一个左上角为(100,100)，右下角为(500，300)的矩形
        RectF rectF1 = new RectF(100, 100, 500, 300);
        //规定一个左上角为(100,400)，右下角为(500，600)的矩形
        RectF rectF2 = new RectF(100, 400, 500, 600);
        RectF rectF3 = new RectF(100, 700, 500, 900);
        //矩形
        path1.addRect(rectF1, Path.Direction.CW);
        //圆角矩形
        path1.addRoundRect(rectF2, 30, 100, Path.Direction.CW);
        //椭圆-其实是矩形的内切圆，如果矩形=正方形，其实就是一个圆
        path1.addOval(rectF3, Path.Direction.CW);
        //在Path2中画出Path1
//        path2.addPath(path1);
        //在Path2种画出Path1，并向右平移400像素
//        path2.addPath(path1,400,0);
        //复制Path1到Path2
        path2.set(path1);
        //绘制Path2
        canvas.drawPath(path2, blackPaint);
    }
}

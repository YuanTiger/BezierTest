package arithmetic.mengy.com.bezierdemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.health.PackageHealthStats;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import arithmetic.mengy.com.bezierdemo.R;
import arithmetic.mengy.com.bezierdemo.utils.ScreenUtils;

/**
 * Author：mengyuan
 * Date  : 2017/4/13下午6:17
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class WaterRippleView extends View {


    private Paint bgPaint;//背景画笔
    private Paint waterPaint;//波浪画笔
    private Path waterPath;//形状


    private int waterHeight = ScreenUtils.dp2Px(40);//水波纹高度
    private int waterWidth = ScreenUtils.dp2Px(150);//水波纹宽度
    private long animotionTime = 1000;//动画速率，变大则变慢

    private int moveDirection = MOVE_LEFT;//默认向左边移动
    private int currentOffSet = 0;//当前运动进度

    private static final int MOVE_RIGHT = 5200;//向右边运动
    private static final int MOVE_LEFT = 5201;//向左边运动

    public WaterRippleView(Context context) {
        super(context);
        initView(context);
    }

    public WaterRippleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    public WaterRippleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        initPaint();

        initPath();

        initAnimator();
    }

    private void initPath() {
        waterPath = new Path();
        int screenWidth = ScreenUtils.getScreenWidth();
        int waterLength = (screenWidth / waterWidth) + 1;
        if (waterLength < 5) {
            waterLength = 5;
        }
        waterPath.moveTo(0, ScreenUtils.getScreenHeight() / 2);
        for (int i = 1; i <= waterLength; i++) {
            if (i % 2 == 0) {
                waterPath.quadTo(waterWidth * (2 * i - 1), ScreenUtils.getScreenHeight() / 2 + waterHeight, waterWidth * (2 * i), ScreenUtils.getScreenHeight() / 2);
            } else {
                waterPath.quadTo(waterWidth * (2 * i - 1), ScreenUtils.getScreenHeight() / 2 - waterHeight, waterWidth * (2 * i), ScreenUtils.getScreenHeight() / 2);
            }
        }
        RectF rectF = new RectF(0, ScreenUtils.getScreenHeight() / 2, waterLength * waterWidth * 2, ScreenUtils.getScreenHeight());
        waterPath.addRect(rectF, Path.Direction.CW);
    }

    private void initAnimator() {
        ValueAnimator animator = ValueAnimator.ofInt(0, waterWidth * 4);
        animator.setDuration(animotionTime);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentOffSet = (Integer) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }

    private void initPaint() {
        bgPaint = new Paint();
        bgPaint.setColor(getContext().getResources().getColor(R.color.c_ffffff));
        bgPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        waterPaint = new Paint();
        waterPaint.setColor(getContext().getResources().getColor(R.color.c_0050f0));
        waterPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Path path = new Path();
        switch (moveDirection) {
            case MOVE_RIGHT://波浪向右边移动
                path.addPath(waterPath, currentOffSet, 0);
                break;
            case MOVE_LEFT://波浪向左边移动
                path.addPath(waterPath, -currentOffSet, 0);
                break;
        }
        canvas.drawPath(path, waterPaint);
    }
}

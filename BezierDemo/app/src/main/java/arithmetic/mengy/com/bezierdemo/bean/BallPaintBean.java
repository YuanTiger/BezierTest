package arithmetic.mengy.com.bezierdemo.bean;

import java.io.Serializable;

/**
 * Author：mengyuan
 * Date  : 2017/4/19下午2:32
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class BallPaintBean implements Serializable {
    private static final float C = 0.551915024494f;


    public BallPaintBean(int ballRadius) {
        p0.x = ballRadius;
        p0.y = 0;

        p1.x = ballRadius + C * ballRadius;
        p1.y = 0;

        p2.x = ballRadius * 2;
        p2.y = ballRadius - C * ballRadius;

        p3.x = ballRadius * 2;
        p3.y = ballRadius;

        p4.x = ballRadius * 2;
        p4.y = ballRadius + C * ballRadius;

        p5.x = ballRadius + C * ballRadius;
        p5.y = ballRadius * 2;

        p6.x = ballRadius;
        p6.y = ballRadius * 2;

        p7.x = ballRadius - C * ballRadius;
        p7.y = ballRadius * 2;

        p8.x = 0;
        p8.y = ballRadius + C * ballRadius;

        p9.x = 0;
        p9.y = ballRadius;

        p10.x = 0;
        p10.y = ballRadius - C * ballRadius;

        p11.x = ballRadius - C * ballRadius;
        p11.y = 0;
    }

    public BallPaint p0 = new BallPaint();
    public BallPaint p1 = new BallPaint();
    public BallPaint p2 = new BallPaint();
    public BallPaint p3 = new BallPaint();
    public BallPaint p4 = new BallPaint();
    public BallPaint p5 = new BallPaint();
    public BallPaint p6 = new BallPaint();
    public BallPaint p7 = new BallPaint();
    public BallPaint p8 = new BallPaint();
    public BallPaint p9 = new BallPaint();
    public BallPaint p10 = new BallPaint();
    public BallPaint p11 = new BallPaint();

    public static class BallPaint {
        public float x;
        public float y;
    }
}

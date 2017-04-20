package arithmetic.mengy.com.bezierdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

import arithmetic.mengy.com.bezierdemo.R;
import arithmetic.mengy.com.bezierdemo.view.BallView;

/**
 * Author：mengyuan
 * Date  : 2017/4/18下午6:50
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class BallActivity extends AppCompatActivity {

    private BallView view_ball;
    private Button bt_change_position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_view);

        view_ball = (BallView) findViewById(R.id.view_ball);
        view_ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        bt_change_position = (Button) findViewById(R.id.bt_change_position);


        bt_change_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(4);
                Log.i("myii",i+"");
                view_ball.setCurrentPosition(i);
            }
        });
    }
}

package arithmetic.mengy.com.bezierdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

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

    private SeekBar sbar_radius;
    private SeekBar sbar_number;
    private SeekBar sbar_margin;

    private TextView tv_margin;
    private TextView tv_number;
    private TextView tv_radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ball_view);

        view_ball = (BallView) findViewById(R.id.view_ball);
        sbar_radius = (SeekBar) findViewById(R.id.sbar_radius);
        sbar_number = (SeekBar) findViewById(R.id.sbar_number);
        sbar_margin = (SeekBar) findViewById(R.id.sbar_margin);

        tv_margin = (TextView) findViewById(R.id.tv_margin);
        tv_number = (TextView) findViewById(R.id.tv_number);
        tv_radius = (TextView) findViewById(R.id.tv_radius);


        bt_change_position = (Button) findViewById(R.id.bt_change_position);


        registerListener();

    }

    private void registerListener() {
        //半径
        sbar_radius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view_ball.setRadius(progress);
                tv_radius.setText(String.format(getString(R.string.dp_d), progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //间隔
        sbar_margin.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float v = progress / 10f;
                view_ball.setMargin(v);
                tv_margin.setText(String.format(getString(R.string.radius_f), v));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        //指示点数量
        sbar_number.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view_ball.setLength(progress);
                tv_number.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        bt_change_position.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(view_ball.getLength());
                view_ball.setCurrentPosition(i);
            }
        });
    }
}

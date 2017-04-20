package arithmetic.mengy.com.bezierdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import arithmetic.mengy.com.bezierdemo.R;
import arithmetic.mengy.com.bezierdemo.view.WaterRippleView;

/**
 * Author：mengyuan
 * Date  : 2017/4/13下午6:22
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class WaterRippleActivity extends AppCompatActivity {

    private WaterRippleView view_water_ripple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_ripple);

        view_water_ripple = (WaterRippleView) findViewById(R.id.view_water_ripple);
    }


}

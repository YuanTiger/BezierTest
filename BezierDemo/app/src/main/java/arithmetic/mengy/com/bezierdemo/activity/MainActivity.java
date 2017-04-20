package arithmetic.mengy.com.bezierdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import arithmetic.mengy.com.bezierdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void water_ripple(View view) {
        startActivity(new Intent(this, WaterRippleActivity.class));
    }

    public void path_use(View view) {
        startActivity(new Intent(this, PathUseActivity.class));
    }

    public void ball_change(View view) {
        startActivity(new Intent(this, BallActivity.class));
    }

}

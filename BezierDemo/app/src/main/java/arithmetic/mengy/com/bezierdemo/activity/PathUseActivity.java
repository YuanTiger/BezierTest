package arithmetic.mengy.com.bezierdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import arithmetic.mengy.com.bezierdemo.R;
import arithmetic.mengy.com.bezierdemo.view.PathUseView;

/**
 * Author：mengyuan
 * Date  : 2017/4/17下午3:08
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class PathUseActivity  extends AppCompatActivity {

    private PathUseView pathUseView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_use);


        initPathView();
    }

    private void initPathView() {
        pathUseView = (PathUseView) findViewById(R.id.view_path_use);
    }
}

package arithmetic.mengy.com.bezierdemo.activity;

import android.app.Application;
import android.content.Context;

/**
 * Author：mengyuan
 * Date  : 2017/4/13下午6:27
 * E-Mail:mengyuanzz@126.com
 * Desc  :
 */

public class BaseApplication extends Application {

    public static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}

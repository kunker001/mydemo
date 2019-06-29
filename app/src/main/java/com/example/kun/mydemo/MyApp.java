package com.example.kun.mydemo;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.xuexiang.xui.XUI;



/**
 * @author xuexiang
 * @since 2018/11/7 下午1:12
 */
public class MyApp extends Application {

    public static Context appContext;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //解决4.x运行崩溃的问题
        //MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        initUI();
        initFresco();
    }

    private void initUI() {
        XUI.init(this);
        XUI.debug(BuildConfig.DEBUG);
//        //设置默认字体为华文行楷
//        XUI.getInstance().initFontStyle("fonts/hwxk.ttf");
    }


    /**
     * 初始化Fresco
     * 使用ImagePipelineConfig的原因是为了支持不同格式图片的压缩
     */
    private void initFresco() {
        ImagePipelineConfig config = ImagePipelineConfig.newBuilder(this)
                .setDownsampleEnabled(true)
                .build();
        Fresco.initialize(this, config);
    }

    public static Context getConText(){
        return appContext;
    }

}

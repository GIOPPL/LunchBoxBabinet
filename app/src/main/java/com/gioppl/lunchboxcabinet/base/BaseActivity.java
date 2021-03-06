package com.gioppl.lunchboxcabinet.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

/**
 * @author admin
 * 描述:     基类activity
 * 作者:     梁亚龙
 * 时间:     2019/12/28
 * 版本:     1.0
 */
public abstract class BaseActivity extends Activity {
    /**
     * 获取TAG的activity名称
     */
    protected final String TAG = this.getClass().getSimpleName();
    /**
     * 是否显示标题栏
     */
    private boolean isShowTitle = true;
    /**
     * 是否显示状态栏
     */
    private boolean isShowStatusBar = true;
    /**
     * 是否显示导航栏
     */
    private boolean isShowNavigationBar = true;
    /**
     * 是否允许旋转屏幕
     */
    private boolean isAllowScreenRoate = true;
    /**
     * 封装Toast对象
     */
    private static Toast toast;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        //加入activity管理
        ActivityCollector.addActivity(this);
        //判断是否显示标题栏
        if (!isShowTitle) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        //判断是否显示状态栏
        if (isShowStatusBar) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                    , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        //判断是否显示导航栏
        if (isShowNavigationBar) {
            WindowManager.LayoutParams params = getWindow().getAttributes();
            params.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE;
            getWindow().setAttributes(params);
        }
        //设置布局
        setContentView(initLayout());
        //设置屏幕是否可旋转
        if (!isAllowScreenRoate) {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
//            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        //初始化控件
        initView();
        //设置数据
        initData();


    }

    protected abstract void initView();

    /**
     * 初始化布局
     *
     * @return 布局id
     */
    protected abstract int initLayout();

    /**
     * 设置数据
     */
    protected abstract void initData();
    protected boolean isRegisterEventBus() {
        return false;
    }
    /**
     * 设置是否显示标题栏
     *
     * @param showTitle true or false
     */
    public void setShowTitle(boolean showTitle) {
        isShowTitle = showTitle;
    }

    /**
     * 设置是否显示状态栏
     *
     * @param showStatusBar true or false
     */
    public void setShowStatusBar(boolean showStatusBar) {
        isShowStatusBar = showStatusBar;
    }

    /**
     * 是否允许屏幕旋转
     *
     * @param allowScreenRoate true or false
     */
    public void setAllowScreenRoate(boolean allowScreenRoate) {
        isAllowScreenRoate = allowScreenRoate;
    }

    /**
     * 显示提示  toast
     *
     * @param msg 提示信息
     */
    @SuppressLint("ShowToast")
    public void showToast(final String msg) {
        try {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (null == toast) {
                        toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
                    } else {
                        toast.setText(msg);
                    }
                    toast.show();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            //解决在子线程中调用Toast的异常情况处理
            Looper.prepare();
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
            Looper.loop();
        }
    }




}

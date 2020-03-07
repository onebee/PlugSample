package com.one.plug;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * @author diaokaibin@gmail.com on 2020/3/7.
 */
public class PluginManager {

    private static final String TAG = "PluginManager";

    private static PluginManager pluginManager;

    private Context mContext;

    public static PluginManager getInstance(Context context) {
        if (pluginManager == null) {
            synchronized (PluginManager.class) {
                if (pluginManager == null) {
                    pluginManager = new PluginManager(context);
                }
            }
        }
        return pluginManager;
    }

    public PluginManager(Context context) {
        this.mContext = context;
    }


    private DexClassLoader mDexClassLoader;
    private Resources mResources;

    /**
     * 加载插件
     * 1. Activity class
     * 2. layout
     */

    public void loadPlugin() {

        try {
            File file = new File(Environment.getExternalStorageDirectory() + File.separator + "p.apk");
            if (!file.exists()) {
                Log.d(TAG, "插件包 不存在...");
                return;
            }

            String pluginPath = file.getAbsolutePath();

            // dexClassLoader 需要一个缓存目录 /data/data/当前应用的包名/pDir
            File fileDir = mContext.getDir("pDir", Context.MODE_PRIVATE);

            /**
             * 加载插件里面 的class
             */
            // Activity class
            mDexClassLoader = new DexClassLoader(pluginPath, fileDir.getAbsolutePath(), null, null);


            /**
             * 加载插件里面的 layout
             */
            AssetManager assetManager = AssetManager.class.newInstance();

            /**
             * 要执行 此方法,为了把插件包的路径 添加进去
             * public final int addAssetPath(String path)
             */
            Method addAssetPathMethod = assetManager.getClass().getMethod("addAssetPath", String.class);// 他的类型是String

            addAssetPathMethod.invoke(addAssetPathMethod, pluginPath);

            Resources r = mContext.getResources(); // 宿主的资源配置信息

            /**
             * 参数2 和 3 资源的配置信息
             * 特殊的 Resources, 加载插件里面的资源的Resources
             */
            mResources = new Resources(assetManager, r.getDisplayMetrics(), r.getConfiguration());

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public ClassLoader getClassLoader() {
        return mDexClassLoader;
    }

    public Resources getResources() {
        return mResources;
    }

}

package application.nsd.nsdcodehub.Controller.PreferencesManager;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.StaticLayout;

/**
 * Created by NSD on 9/19/16.
 */
public class NSDSharedPreferencesController {

    private SharedPreferences sharedPreferences;

    private static NSDSharedPreferencesController instance = null;

    private static NSDSharedPreferencesController getInstance(){
        if(instance==null){
            instance = new NSDSharedPreferencesController();
        }
        return instance;
    }

    public static void Init(Activity activity){
        getInstance().sharedPreferences = activity.getPreferences(Context.MODE_PRIVATE);
    }



    public static void putString(String key,String val){
        final SharedPreferences.Editor editor = getInstance().sharedPreferences.edit().putString(key, val);
        editor.apply();

    }

    public static void putInt(String key,int val){
        final SharedPreferences.Editor editor = getInstance().sharedPreferences.edit().putInt(key, val);
        editor.apply();

    }

    public static String getString(String key){
        return getInstance().sharedPreferences.getString(key,null);
    }

    public static int getInt(String key){
        return getInstance().sharedPreferences.getInt(key,0);
    }



}

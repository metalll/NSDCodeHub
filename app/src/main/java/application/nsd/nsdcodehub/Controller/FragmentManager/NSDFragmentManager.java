package application.nsd.nsdcodehub.Controller.FragmentManager;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by NSD on 9/16/16.
 */
public class NSDFragmentManager {

    private static NSDFragmentManager instance;

    private static NSDFragmentManager getInstance() {
            if(instance==null)
            {
                instance=new NSDFragmentManager();
            }
            return instance;
        }

    private Activity activity;
    private FragmentManager fragmentManager;

    private NSDFragmentManager() {}



    public static void Init(Activity activity){
            NSDFragmentManager.getInstance();
            instance.activity = activity;
            instance.fragmentManager = activity.getFragmentManager();

        }

    public static void setFragment(int containerViewId, Fragment fragment, boolean addToBackStack) {
            FragmentTransaction fragmentTransaction = getInstance().fragmentManager.beginTransaction();
                    fragmentTransaction.replace(containerViewId, fragment);

            if (addToBackStack) {
                fragmentTransaction.addToBackStack(null);
            }



            fragmentTransaction.commit();
        }

    public static FragmentManager getFragmentManager() {
            return getInstance().fragmentManager;
        }

    }


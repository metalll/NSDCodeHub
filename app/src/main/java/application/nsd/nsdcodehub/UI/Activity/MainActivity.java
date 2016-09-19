package application.nsd.nsdcodehub.UI.Activity;

import android.app.Activity;
import android.os.Bundle;

import application.nsd.nsdcodehub.Controller.FragmentManager.NSDFragmentManager;
import application.nsd.nsdcodehub.Controller.PreferencesManager.NSDSharedPreferencesController;
import application.nsd.nsdcodehub.R;
import application.nsd.nsdcodehub.UI.Fragment.OAuthWebLogin;

public class MainActivity extends Activity {

    public static final int ROOT_COUNTAINER = R.id.root;

    public static final boolean YES = true;
    public static final boolean NO = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initSingletones;
        NSDFragmentManager.Init(this);
        NSDSharedPreferencesController.Init(this);





        NSDFragmentManager.setFragment(ROOT_COUNTAINER,new OAuthWebLogin(),YES);

    }
}

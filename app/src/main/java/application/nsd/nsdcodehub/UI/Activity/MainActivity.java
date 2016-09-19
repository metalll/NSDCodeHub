package application.nsd.nsdcodehub.UI.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.ParcelUuid;

import application.nsd.nsdcodehub.Controller.FragmentManager.NSDFragmentManager;
import application.nsd.nsdcodehub.R;
import application.nsd.nsdcodehub.UI.Fragment.Launch;

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
        NSDFragmentManager.setFragment(ROOT_COUNTAINER,new Launch(),YES);

    }
}

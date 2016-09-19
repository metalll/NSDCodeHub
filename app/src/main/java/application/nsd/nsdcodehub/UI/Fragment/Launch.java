package application.nsd.nsdcodehub.UI.Fragment;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Map;

import application.nsd.nsdcodehub.Controller.Network.NSDGitClient.NSDGitManager;
import application.nsd.nsdcodehub.Controller.Network.NSDUtils;
import application.nsd.nsdcodehub.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Launch extends Fragment {


    private View rootView = null;
    private WebView webView = null;


    public Launch() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.fragment_blank, container, false);
        webView = (WebView) rootView.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
               if(url.contains("nsdgitclient://")){
                   Log.e("NSD auth code accept","  " + url);
                   Map<String,String> respMap = NSDUtils.ParamsUrlCoder.decode(url);

                   if(respMap.containsKey("code")){
                       Log.e("NSD req code",respMap.get("code"));
                   }



               }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.e("NSD FinishLoad","  " + url);
            }
        });



        webView.loadUrl(NSDGitManager.GET_AUTH_CODE);

        // Inflate the layout for this fragment
        return rootView;
    }

}

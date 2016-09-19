package application.nsd.nsdcodehub.Controller.Network.NSDGitClient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import application.nsd.nsdcodehub.Controller.Network.NSDUtils;
import application.nsd.nsdcodehub.Controller.PreferencesManager.NSDSharedPreferencesController;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by NSD on 9/16/16.
 */
public class NSDGitManager {
    private static final String GITHUB_APP_ID = "90148ae988fcef1f0bb3";
    private static final String GITHUB_APP_SECRET = "4344c30471cdf09a1a72bf35674f75eebcc10fc4";


    private static class GitInstance {
        private static final String ACCESS_TOKEN = "token";
        public String AccessToken = null;
        public Map<String, String> headers = null;

        public GitInstance(){
            AccessToken = NSDSharedPreferencesController.getString(ACCESS_TOKEN);
            if(AccessToken!=null){
                headers = new HashMap<>();
                headers.put("Authorization","token " + AccessToken);
            }


        }
    }

    private static GitInstance instance;

    private static GitInstance getInstance(){
        if(instance==null)
            instance = new GitInstance();
        return instance;
    }

    public static final String GET_AUTH_CODE = "https://github.com/login/oauth/authorize?client_id=90148ae988fcef1f0bb3&scope=user,repo,notifications";
    public static final String BASE_URL = "https://api.github.com";
    public static final String POST_AUTH_TOKEN = "https://github.com/login/oauth/access_token";


    public static boolean hasToken(){ return getInstance().AccessToken!=null;}

    public static void processedReqCodeAndSetToken(Map<String,String> reqCode, final INSDCompletion completion){
        String strReqCode = reqCode.get("code");
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody formBody = new FormBody.Builder()
                .add("client_id",GITHUB_APP_ID)
                .add("client_secret",GITHUB_APP_SECRET)
                .add("code",strReqCode)
                .build();

        Request request = new Request.Builder()
                .url(POST_AUTH_TOKEN)
                .post(formBody)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                completion.onError(e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Map<String,String> respMap = NSDUtils.ParamsUrlCoder.decode("?"+response.body().string());

//                for(int i=0;i<respMap.keySet().size();i++){
//                    Log.d("NSD Decoder Responce",respMap.keySet().toArray()[i] + " : " + respMap.get((String)respMap.keySet().toArray()[i])  );
//                }

                NSDSharedPreferencesController.putString(GitInstance.ACCESS_TOKEN,respMap.get("access_token"));

                getInstance().AccessToken = respMap.get("access_token");
                getInstance().headers = new HashMap<>();
                getInstance().headers.put("Authorization","token " + getInstance().AccessToken);


                completion.Completion(respMap);
            }
        });


    }

    public static Map<String,String> getHeaders(){
        return getInstance().headers;
    }



}

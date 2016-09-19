package application.nsd.nsdcodehub.Controller.Network.NSDGitClient;

import java.util.Map;

/**
 * Created by NSD on 9/16/16.
 */
public class NSDGitManager {

    private static class GitInstance {
        public String AccessToken;
        public Map<String, String> headers;

        public GitInstance(){

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


    public static void processedReqCode(Map<String,String> reqCode){



    }




}

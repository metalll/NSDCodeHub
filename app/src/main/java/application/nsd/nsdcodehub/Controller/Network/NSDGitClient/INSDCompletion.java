package application.nsd.nsdcodehub.Controller.Network.NSDGitClient;

import java.util.Map;

/**
 * Created by NSD on 9/19/16.
 */
public interface INSDCompletion {
    void Completion(Map<String,String> responseMap);
    void onError(String errorDescription);
}

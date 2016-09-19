package application.nsd.nsdcodehub.Controller.Network;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by NSD on 9/19/16.
 */
public class NSDUtils {

    public static class ParamsUrlCoder{

        public static String encode(Map<String,String> dictionary){

            String retVal = "?";
            boolean isFirstIteration = true;
            for(Map.Entry<String,String> entry:dictionary.entrySet()){
                String tempKey = entry.getKey();
                String tempValue = entry.getValue();

                if(isFirstIteration){isFirstIteration = false;}
                else { retVal+="&"; }
                retVal += tempKey.concat("="+tempValue);
            }

            return retVal;

        }

        public static Map<String,String> decode(String url) {
            Map<String,String> retVal = new HashMap<>();
            if(url.contains("?")){
                url = url.substring(url.indexOf('?')+1);
            }
            String[] pairs = url.split("&");
            for(int i=0;i<pairs.length;i++){
                int index = pairs[i].indexOf('=');
                retVal.put(pairs[i].substring(0,index),pairs[i].substring(index+1));
            }

            return retVal;
        }
    }
}

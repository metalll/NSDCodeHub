package application.nsd.nsdcodehub.Controller.Network;

import android.app.Notification;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;

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

        public static Map<String,String> decode(String url){
            Map<String,String> retVal = new HashMap<>();

            String paramsWithoutURL = "";

            int i = 0;
            while (paramsWithoutURL.equals("")){

                if(url.charAt(i)=='?'){
                    paramsWithoutURL = url.substring(i+1,url.length());
                }
                i++;

            }
            Log.e("NSD decode"," "+ paramsWithoutURL);

            i=0;
            while(i < paramsWithoutURL.length()){

                if(paramsWithoutURL.charAt(i)=='='){
                    String tempKey = paramsWithoutURL.substring(0,i);
                    String tempVal = "";

                        try {

                            int j = i;
                            while (tempVal.equals("") || j >= paramsWithoutURL.length()) {
                                if (paramsWithoutURL.charAt(j) == '&') {
                                    tempVal = paramsWithoutURL.substring(i, j);
                                    i = j;
                                    break;
                                }
                                j++;
                            }
                        }
                        catch (Exception e){
                           tempVal = paramsWithoutURL.substring(i+1,paramsWithoutURL.length()) ;

                        }



//                    Log.e("NSD tempKey"," "+tempKey);
//                    Log.e("NSD tempVal"," "+tempVal);

                    retVal.put(tempKey,tempVal);




                }

                i++;


            }



            return retVal;

        }

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cypher;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 *
 * @author fdamilola
 */
public class MapUtils {
    public static byte[] wrap(HashMap<Integer, String> map){
        return new Gson().toJson(map).getBytes(StandardCharsets.UTF_8);
    }
    
    public static HashMap<Integer, String> unwrap(byte[] data){
        final String jdata = new String(data, StandardCharsets.UTF_8);
        //ambiPrint("To unwrap -> "+ jdata);
        Type type = new TypeToken<HashMap<Integer, String>>(){}.getType();
        return new Gson().fromJson(jdata, type);
    }
    
    
    public static void ambivalentPrintln(Object o){
        System.out.println(o);
    }
}

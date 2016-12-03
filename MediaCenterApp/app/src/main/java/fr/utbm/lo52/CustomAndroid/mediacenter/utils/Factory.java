package fr.utbm.lo52.CustomAndroid.mediacenter.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vmars on 03/12/2016.
 */

public class Factory {
    static Map<String, Object> instances = new HashMap<>();

    public static void set(String key, Object instance){
        instances.put(key, instance);
    }
    public static Object get(String key){
        return instances.get(key);
    }
}

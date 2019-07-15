package com.panpan.fleamarketapi.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {
    public static String toJSonArrStr(Object data) {
        return JSONArray.fromObject(data).toString();
    }

    public static String toJSonStr(Object data) {
        return JSONObject.fromObject(data).toString();
    }

    public static JSONArray toJSonArr(Object data) {
        return JSONArray.fromObject(data);
    }

    public static JSONObject toJSon(Object data) {
        return JSONObject.fromObject(data);
    }

}



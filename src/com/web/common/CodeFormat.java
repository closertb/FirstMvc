package com.web.common;

import java.util.HashMap;
import java.util.Map;

public class CodeFormat {
    private static Map<String,String> messageMap = new HashMap<String, String>();
    //初始化状态码与文字说明
    static {
        messageMap.put("0", "");

        messageMap.put("200", "Success!");
        messageMap.put("400", "Bad Request!");
        messageMap.put("401", "NotAuthorization");
        messageMap.put("405", "Method Not Allowed");
        messageMap.put("406", "Not Acceptable");
        messageMap.put("500", "Internal Server Error");

    }
    public static String retParam(int status,Object data) {
        OutputJson json = new OutputJson(status, messageMap.get(String.valueOf(status)), data);
        return json.toString();
    }
}

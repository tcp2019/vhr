package com.pactera.sms.vhr.vo;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName ResponseVo
 * @Description: TODO
 * @Author TCP
 * @Date 2020/3/26 0026
 * @Version V1.0
 **/
public class ResponseVo {
    private Integer status;
    private String message;
    private Object object;

    public static String ok(Integer status, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("msg", message);
        return jsonObject.toJSONString();
    }

    public static String ok(Integer status, String message, Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("msg", message);
        jsonObject.put("obj", object);
        return jsonObject.toJSONString();
    }

    public static String error(Integer status, String message) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", status);
        jsonObject.put("msg", message);
        return jsonObject.toJSONString();
    }
}

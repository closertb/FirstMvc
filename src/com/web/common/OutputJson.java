package com.web.common;

import java.io.Serializable;
import com.alibaba.fastjson.JSON;


public class OutputJson implements Serializable {

    /**
     * 返回客户端统一格式，包括状态码，提示信息，以及业务数据
     */
    private static final long serialVersionUID = 1L;
    //状态码
    private int status;
    //必要的提示信息
    private String message;
    //业务数据
    private Object content;

    public OutputJson(int status,String message,Object content){
        this.status = status;
        this.message = message;
        this.content = content;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Object getContent() {
        return content;
    }
    public void setContent(Object content) {
        this.content = content;
    }
    public String toString(){
        if(null == this.content){
            this.setContent(new Object());
        }
        return JSON.toJSONString(this);
    }
}

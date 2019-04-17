package com.web.common;

public class BaseController {
    protected String retContent(int status,Object data) {
        return CodeFormat.retParam(status, data);
    }
}

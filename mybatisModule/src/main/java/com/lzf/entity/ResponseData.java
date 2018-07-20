package com.lzf.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by silence on 17-5-29.
 */
public class ResponseData {
    private String code;
    private String message;
    private Map<String, Object> data;

    public ResponseData( ) {

    }

    public ResponseData(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode ( ) {
        return code;
    }

    public void setCode (String code) {
        this.code = code;
    }

    public String getMessage ( ) {
        return message;
    }

    public void setMessage (String message) {
        this.message = message;
    }

    public Map<String, Object> getData ( ) {
        return data;
    }

    public void setData (Map<String, Object> data) {
        this.data = data;
    }

    public void addData (String key, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        data.put(key, value);
    }

    public static ResponseData ok ( ) {

        return new ResponseData("200", "操作成功");
    }

    public static ResponseData paramsNull ( ) {

        return new ResponseData("199", "参数错误");
    }

    public static ResponseData serverInternalError ( ) {
        return new ResponseData("500", "程序出错啦，请稍安勿躁");
    }

    public static ResponseData empty() {
        return new ResponseData("199", "没查询到数据");
    }

}

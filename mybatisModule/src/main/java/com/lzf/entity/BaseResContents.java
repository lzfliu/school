package com.lzf.entity;

/**
 * Created by silence on 17-5-30.
 */
public class BaseResContents {
    public static final String KEY_SUCCESS = "200";
    public static final String MSG_SUCCESS = "成功";
    public static final String KEY_INPUT_EMPTY = "201";//缺少参数
    public static final String REPEAT_INPUT_EMPTY = "203";//重复数据

    public static final String KEY_EMPTY = "199";
    public static final String MSG_EMPTY = "没查询到数据";

    
    public static final String KEY_COMMON_ERROR="500";

    public static final String KEY_USER_EMPTY="U-1000";
    public static final String MSG_USER_EMPTY="用户名错误";

    public static final String KEY_USER_PWD_ERROR="U-1001";
    public static final String MSG_USER_PWD_ERROR="用户名密码错误";

    public static final String KEY_USER_TYPE_ERROR="U-1002";
    public static final String MSG_USER_TYPE_ERROR="用户权限错误，您是尊贵的超级管理员！";

    public static final String KEY_USER_EMPTY_EXIST="U-1003";
    public static final String MSG_USER_EMPTY_EXIST="用户名已经存在";


    public static ResponseData ok() {
        return new ResponseData(BaseResContents.KEY_SUCCESS, BaseResContents.MSG_SUCCESS);
    }
    public static ResponseData empty() {
        return new ResponseData(BaseResContents.KEY_EMPTY, BaseResContents.MSG_EMPTY);
    }

    public static ResponseData notFound() {
        return new ResponseData("404", "Not Found");
    }

    public static ResponseData emptyInput() {
        return new ResponseData(KEY_INPUT_EMPTY, "");
    }

    public static ResponseData badRequest() {
        return new ResponseData("400", "Bad Request");
    }

    public static ResponseData forbidden() {
        return new ResponseData("403", "Forbidden");
    }

    public static ResponseData unauthorized() {
        return new ResponseData("401", "unauthorized");
    }

    public static ResponseData serverInternalError() {
        return new ResponseData("500", "程序出错啦，请稍安勿躁");
    }

    public static ResponseData overDue(){
        return new ResponseData("101","您长期未登录，请重新登录");
    }
    public static ResponseData tokenEmpty(){
        return new ResponseData("102","传输协议错误，登录令牌为空");
    }

    public static ResponseData customerError() {
        return new ResponseData("1001", "customer Error");
    }

}

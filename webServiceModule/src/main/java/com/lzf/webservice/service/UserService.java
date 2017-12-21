package com.lzf.webservice.service;

import com.lzf.webservice.entity.User;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * Created by lzf on 2017/12/20.
 */
@WebService(name = "user", // 暴露服务名称
        targetNamespace = "http://service.demo.lzf.cn/"// 命名空间,一般是接口的包名倒序
)
public interface UserService {

    @WebMethod
    String getName(@WebParam(name = "userId") String userId);

    @WebMethod
    User getUser(@WebParam(name = "userId") String userId);
}
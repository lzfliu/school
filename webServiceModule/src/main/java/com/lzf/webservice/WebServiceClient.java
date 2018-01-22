package com.lzf.webservice;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;


/**
 * Created by lzf on 2017/12/20.
 */
public class WebServiceClient {

    public static void main(String[] args) throws Exception {


        JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        Client client =dcf.createClient("http://localhost:8080/test/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects=client.invoke("getUser","411001");
        //输出调用结果
        System.out.println("*****"+objects[0].toString());

        /*JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/services/CommonService?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("sayHello", "Leftso");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }*/
    }


}

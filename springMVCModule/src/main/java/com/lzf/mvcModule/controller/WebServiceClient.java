package com.lzf.mvcModule.controller;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.utils.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;


/**
 * Created by lzf on 2017/12/20.
 */
public class WebServiceClient {

    public static void main(String[] args) throws Exception {
       /* String url = "http://localhost:8080/test/user?wsdl";
        String method = "getUser";
        String[] parms = new String[]{"411001"};
        WebServiceClient webClient = new WebServiceClient();

        String svrResult = webClient.CallMethod(url, method, parms);

        System.out.println(svrResult);
*/

      /*  JaxWsDynamicClientFactory dcf =JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client =dcf.createClient("http://localhost:8080/test/user?wsdl");
        //getUser 为接口中定义的方法名称  张三为传递的参数   返回一个Object数组
        Object[] objects=client.invoke("getUser","411001");
        //输出调用结果
        System.out.println("*****"+objects[0].toString());
        */

        // 创建动态客户端
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient("http://localhost:8080/test/user?wsdl");
        // 需要密码的情况需要加上用户名和密码
        // client.getOutInterceptors().add(new ClientLoginInterceptor(USER_NAME,
        // PASS_WORD));
        Object[] objects = new Object[0];
        try {
            // invoke("方法名",参数1,参数2,参数3....);
            objects = client.invoke("getUser", "411001");
            System.out.println("返回数据:" + objects[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }

    }

    public String CallMethod(String url, String method, Object[] args) {
        String result = null;

        if(StringUtils.isEmpty(url))
        {
            return "url地址为空";
        }

        if(StringUtils.isEmpty(method))
        {
            return "method地址为空";
        }

        Call rpcCall = null;


        try {
            //实例websevice调用实例
            Service webService = new Service();
            rpcCall = (Call) webService.createCall();
            rpcCall.setTargetEndpointAddress(new java.net.URL(url));
            rpcCall.setOperationName(method);

            //执行webservice方法
            result = (String) rpcCall.invoke(args);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;

    }
}

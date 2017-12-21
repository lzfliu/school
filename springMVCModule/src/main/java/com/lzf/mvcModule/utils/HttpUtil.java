package com.lzf.mvcModule.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author ouyangan
 * @Date 2017/1/13/16:17
 * @Description http请求工具类
 */
public class HttpUtil {

    private static final Logger log = LoggerFactory.getLogger(HttpUtil.class);

    public static final String CONTENT_TYPE_FORM="application/x-www-form-urlencoded; charset=UTF-8";
    public static final String CONTENT_TYPE_JSON="application/json";
//    /**
//     * 通用请求头
//     */
//    private static final Header[] headers = new Header[]{
//            new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 Safari/537.36"),
//            new BasicHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8")
//    };

    /**
     * @param url
     * @param map
     * @return
     * @throws IOException
     * @Author ouyangan
     * @Date 2017-1-14 15:01:02
     * @Description post请求
     */
    public static String post(String url, Map<String, String> map,String contentType) throws IOException {
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", StringUtils.isBlank(contentType)?CONTENT_TYPE_FORM:contentType);
        post.setConfig(requestConfig);
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (String key : map.keySet()) {
            String value = map.get(key);
            log.debug("post.param.key-{}.value-{}", value);
            list.add(new BasicNameValuePair(key, value));
        }
        System.out.println(JSONArray.toJSONString(list));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, "utf-8");
        post.setEntity(entity);
        CloseableHttpResponse execute = client.execute(post);
        HttpEntity httpEntity = execute.getEntity();
        String responseString = EntityUtils.toString(httpEntity);
        post.releaseConnection();
        client.close();
        log.debug("responseString:{}",responseString);
        return responseString;
    }

    /**
     * post请求
     *
     * @param url
     * @param param
     * @return
     * @throws IOException
     */
    public static String post(String url, String param,String contentType) throws IOException {
        log.debug("post.请求参数.url:{},entity:{}", url, param);
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
                .setSocketTimeout(2000)
                .setConnectTimeout(2000)
                .setConnectionRequestTimeout(2000)
                .build();
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", StringUtils.isBlank(contentType)?CONTENT_TYPE_FORM:contentType);
        post.setConfig(requestConfig);
        log.debug("post.param.{}", param);
        StringEntity stringEntity = new StringEntity(param, "UTF-8");
        post.setEntity(stringEntity);
        CloseableHttpResponse execute = client.execute(post);
        HttpEntity httpEntity = execute.getEntity();
        String responseString = EntityUtils.toString(httpEntity, "UTF-8");
        post.releaseConnection();
        client.close();
        log.debug("responseString:{}",responseString);
        return responseString;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     * @Author ouyangan
     * @Date 2017-1-14 15:02:11
     * @Description get请求
     */
    public static String get(String url,String contentType) throws IOException {
        HttpClients.createDefault();
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
                .setSocketTimeout(10000)
                .setConnectTimeout(10000)
                .setConnectionRequestTimeout(10000)
                .build();
        HttpGet get = new HttpGet(url);
        log.debug("get.url-{}", url);
        get.setHeader("Content-Type", StringUtils.isBlank(contentType)?CONTENT_TYPE_FORM:contentType);
        get.setConfig(requestConfig);
        CloseableHttpResponse execute = client.execute(get);
        HttpEntity httpEntity = execute.getEntity();
        String s = EntityUtils.toString(httpEntity);
        get.releaseConnection();
        client.close();
        return s;
    }

    public static String post(String url,Map<String,Object> map)  throws IOException{
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost http = new HttpPost(url);
            http.addHeader(HTTP.CONTENT_TYPE, "application/json;charset=UTF-8");
            StringEntity se = new StringEntity(JSONObject.toJSONString(map),"UTF-8");
            http.setEntity(se);
            HttpResponse httpResponse = httpClient.execute(http);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent(),"UTF-8"));
            StringBuffer stb = new StringBuffer();
            String line = null;
            while ((line = buffer.readLine()) != null) {
                stb.append(line);
            }
            buffer.close();
           String result = stb.toString();
            return  result;
    }

    /**
     * @param url
     * @return
     * @throws IOException
     * @Author ouyangan
     * @Date 2017-1-14 15:02:11
     * @Description get请求
     */
    public static byte[] getBytes(String url) throws IOException {
        HttpClients.createDefault();
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        CloseableHttpClient client = httpClientBuilder.build();
        RequestConfig requestConfig = RequestConfig.copy(RequestConfig.DEFAULT)
                .setSocketTimeout(30000)
                .setConnectTimeout(30000)
                .setConnectionRequestTimeout(30000)
                .build();
        HttpGet get = new HttpGet(url);
        log.debug("get.url-{}", url);
        get.setHeader("Content-Type", "application/octet-stream");
        get.setConfig(requestConfig);
        CloseableHttpResponse execute = client.execute(get);
        HttpEntity httpEntity = execute.getEntity();
        String s = EntityUtils.toString(httpEntity);
        get.releaseConnection();
        client.close();
        return new byte[0];
    }

    /**
     * 发送文件到文件服务器
     * @param localFile 本地文件路径
     * @param url 文件服务器路径
     * @param appkey 文件服务器appkey
     * @param secret 秘钥
     * @return 上传返回的路径。
     */
    public static String upload(String localFile, String url, String appkey, String secret){
        String path = "";
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        BufferedReader buffer = null;
        try {
            httpClient = HttpClients.createDefault();

            // 把一个普通参数和文件上传给下面这个地址 是一个servlet
            HttpPost httpPost = new HttpPost(url);

            // 把文件转换成流对象FileBody
            FileBody bin = new FileBody(new File(localFile));

            StringBody appkey1 = new StringBody(appkey, ContentType.create(
                    "text/plain", Consts.UTF_8));
            StringBody secret1 = new StringBody(secret, ContentType.create(
                    "text/plain", Consts.UTF_8));

            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    // 相当于<input type="file" name="file"/>
                    .addPart("file", bin)

                    // 相当于<input type="text" name="userName" value=userName>
                    .addPart("appkey", appkey1)
                    .addPart("secret", secret1)
                    .build();

            httpPost.setEntity(reqEntity);

            // 发起请求 并返回请求的响应
            response = httpClient.execute(httpPost);

            // 获取响应对象
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                buffer = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                StringBuffer stb = new StringBuffer();
                String line = null;
                while ((line = buffer.readLine()) != null) {
                    stb.append(line);
                }
                String result = stb.toString();
                JSONObject jsonObject = JSONObject.parseObject(result);
                path = jsonObject.getString("data");
            }
            // 销毁
            EntityUtils.consume(resEntity);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(buffer != null){
                    buffer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(httpClient != null){
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return path;
    }

    /**
     * 下载文件
     * @param url            http://www.xxx.com/img/333.jpg
     * @param destFileName   xxx.jpg/xxx.png/xxx.txt
     */
    public static void getFile(String url, String destDirPath, String destFileName) {

        File file = new File(destDirPath);

        if(!file.exists()){
            file.mkdirs();
        }

        String destFilePathName = destDirPath+destFileName;

        getFile(url, destFilePathName);
    }


    /**
     * 上传文件
     * @param url 网络文件地址 http://www.xxx.com/img/333.jpg
     * @param destFilePathName 本地本地存储名称
     */
    public static void getFile(String url, String destFilePathName) {
        FileOutputStream fout = null;
        InputStream in = null;
        CloseableHttpClient httpclient = null;
        CloseableHttpResponse response = null;
        try {
            // 生成一个httpclient对象
            httpclient = HttpClients.createDefault();
//            httpclient.
            HttpGet httpget = new HttpGet(url);
            response = httpclient.execute(httpget);
            HttpEntity entity = response.getEntity();
            in = entity.getContent();
            File file = new File(destFilePathName);
            fout = new FileOutputStream(file);
            int l;
            byte[] tmp = new byte[1024];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp, 0, l);
                // 注意这里如果用OutputStream.write(buff)的话，图片会失真，大家可以试试
            }
            fout.flush();
            System.out.println("文件创建成功："+destFilePathName);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }finally {
            try {
                if(fout != null){
                    fout.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(in != null){
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(response != null){
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (httpclient != null){
                    httpclient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}

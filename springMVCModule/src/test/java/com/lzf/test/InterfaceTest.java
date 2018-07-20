package com.lzf.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lzf.mvcModule.utils.HttpUtil;

import java.security.MessageDigest;
import java.util.*;

public class InterfaceTest {

    public static void main(String[] args) throws Exception{
        //图片地址
        List<JSONObject> imgList = new ArrayList<>();
        JSONObject imgData1 = new JSONObject();
        JSONObject imgData2 = new JSONObject();
        imgList.add(imgData1);
        imgList.add(imgData2);
        imgData1.put("photo_type_id", 201);
        imgData1.put("url", "http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png");

        imgData2.put("photo_type_id", 202);
        imgData2.put("url", "http://img.zcool.cn/community/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png");


        StringBuffer str  = new StringBuffer("[");
        str.append("{\"photo_type_id\":201,").append("\"url\":\"http:\\/\\/img.zcool.cn\\/community\\/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png\"},");
        str.append("{\"photo_type_id\":202,").append("\"url\":\"http:\\/\\/img.zcool.cn\\/community\\/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png\"}]");

        //准备参数
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("order_sn","1234567");
        dataMap.put("vin","LSVAM4187C2184847");
        dataMap.put("province_name","山东");
        dataMap.put("city_name","青岛");
        dataMap.put("model_full_name","123456");
        dataMap.put("first_reg_date","2018-12-12");
        dataMap.put("mileage","5");
        dataMap.put("transaction_price","12");
        dataMap.put("operation_type",11);
        dataMap.put("photo_list", JSON.toJSONString(imgList));
        dataMap.put("user_mobile","18561393417");
        dataMap.put("app_key","129990101");
        dataMap.put("remark","");
        dataMap.put("timestamp",1522027795960L);


        //加密生成sign
        Set<String> keySet = dataMap.keySet();
        List<String> keyList = new ArrayList();
        keyList.addAll(keySet);
        Collections.sort(keyList);
        StringBuffer dataSbf = new StringBuffer("");
        for (String key : keyList) {
            Object value = dataMap.get(key);
            dataSbf.append(key);
            if(value != null){
                dataSbf.append(value);
            }
        }
        String dataStr = "6c758991b43db5a9e990b068a056061"+dataSbf.toString()+"6c758991b43db5a9e990b068a056061";
        System.out.println(dataStr);
        String sign = getMD5(dataStr);
        dataMap.put("sign",sign);
        System.out.println("sign:"+sign);

        //请求接口
        String url = "http://39.155.165.2:27000/qinvin/index/sync";
        String params = "{\"first_reg_date\":\"2018-12-12\",\"operation_type\":11,\"model_full_name\":\"123456\",\"sign\":\"6497f26da9a29f97b9a80fe8ff3bd851\",\"remark\":\"\",\"province_name\":\"山东\",\"photo_list\":\"[{\"photo_type_id\":201,\"url\":\"http:\\/\\/img.zcool.cn\\/community\\/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png\"},{\"photo_type_id\":202,\"url\":\"http:\\/\\/img.zcool.cn\\/community\\/0142135541fe180000019ae9b8cf86.jpg@1280w_1l_2o_100sh.png\"}]\",\"city_name\":\"青岛\",\"app_key\":\"129990101\",\"user_mobile\":\"18561393417\",\"transaction_price\":\"12\",\"vin\":\"LSVAM4187C2184847\",\"order_sn\":\"1234567\",\"mileage\":\"5\",\"timestamp\":1522027795960}";
        System.out.println("第一次请求参数："+params);
        String post = HttpUtil.post(url, params, HttpUtil.CONTENT_TYPE_FORM);
        String post3 = HttpUtil.post(url, params, HttpUtil.CONTENT_TYPE_JSON);
        System.out.println("第一次请求结果："+post3);

        System.out.println("第二次请求参数："+JSON.toJSONString(dataMap));
        String post1 = HttpUtil.post(url, dataMap, HttpUtil.CONTENT_TYPE_FORM);
        String post2 = HttpUtil.post(url, dataMap, HttpUtil.CONTENT_TYPE_JSON);
        System.out.println("第二次请求结果："+post1);
        System.out.println("第二次请求结果："+post2);

    }

    public final static String MD5(String s) {
        char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f' };
        try {
            byte[] strTemp = s.getBytes();
            //使用MD5创建MessageDigest对象
            MessageDigest mdTemp = MessageDigest.getInstance("MD5");
            mdTemp.update(strTemp);
            byte[] md = mdTemp.digest();
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte b = md[i];
                //System.out.println((int)b);
                //将没个数(int)b进行双字节加密
                str[k++] = hexDigits[b >> 4 & 0xf];
                str[k++] = hexDigits[b & 0xf];
            }
            return new String(str);
        } catch (Exception e) {return null;}
    }

    /**
     * 获取MD5加密后的字符串
     * @param str 明文
     * @return 加密后的字符串
     * @throws Exception
     */
    public static String getMD5(String str) throws Exception {
        StringBuilder sign = new StringBuilder();

        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] bytes = md.digest(str.getBytes());

        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex);//.toUpperCase()
        }
        return sign.toString();
    }
}

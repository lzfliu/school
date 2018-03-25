package com.lzf.test;

import com.lzf.mvcModule.utils.HttpUtil;

import java.security.MessageDigest;
import java.util.*;

public class InterfaceTest {

    public static void main(String[] args) throws Exception{

//        String str = "6c758991b43db5a9e990b068a056061app_key199888522city_name北京province_name北京timestamp15084813336c758991b43db5a9e990b068a056061";
//
//        String md5 = getMD5(str);
//
//        String s = MD5(str);
//        System.out.println(md5);
//        System.out.println(s);


        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("order_sn","123456");
        dataMap.put("vin","123456");
        dataMap.put("province_name","山东");
        dataMap.put("city_name","青岛");
        dataMap.put("model_full_name","123456");
        dataMap.put("first_reg_date","2018-12-12");
        dataMap.put("mileage","5");
        dataMap.put("transaction_price","12");
        dataMap.put("operation_type",11);
        dataMap.put("photo_list",null);
        dataMap.put("user_mobile","18561393417");
        dataMap.put("app_key","129990101");
        dataMap.put("remark","");
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
        System.out.println(dataSbf);

        String dataStr = "6c758991b43db5a9e990b068a056061"+dataSbf.toString()+"6c758991b43db5a9e990b068a056061";

        String sign = MD5(dataStr);

        dataMap.put("sign",sign);

        System.out.println("sign:"+sign);
        String url = "http://39.155.165.2:27000/qinvin/index/sync";
        String post = HttpUtil.post(url, dataMap, HttpUtil.CONTENT_TYPE_FORM);
        System.out.println(post);

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
        /** 创建MD5加密对象 */
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        /** 进行加密 */
        md5.update(str.getBytes("GBK"));
        /** 获取加密后的字节数组 */
        byte[] md5Bytes = md5.digest();
        String res = "";
        for (int i = 0; i < md5Bytes.length; i++){
            int temp = md5Bytes[i] & 0xFF;
            if (temp <= 0XF){ // 转化成十六进制不够两位，前面加零
                res += "0";
            }
            res += Integer.toHexString(temp);
        }
        return res;
    }
}

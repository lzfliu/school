package com.lzf.utils;

import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 描述:
 * 属性与字段相互转换工具类
 *
 * @author liuzhenfei
 * @create 2017-11-09 上午 8:34
 */
public class ColumnFieldUtils {
    /**
     * 对象属性转换为字段  例如：userName to user_name
     * @param filed 字段名
     * @return
     */
    public static String filedToColumn(String filed) {
        if (null == filed) {
            return "";
        }
        char[] chars = filed.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (char c : chars) {
            if (CharUtils.isAsciiAlphaUpper(c)) {
                sb.append("_" + StringUtils.lowerCase(CharUtils.toString(c)));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * 字段转换成对象属性 例如：user_name to userName
     * @param column
     * @return
     */
    public static String columnToField(String column) {
        if (null == column) {
            return "";
        }
        char[] chars = column.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '_') {
                int j = i + 1;
                if (j < chars.length) {
                    sb.append(StringUtils.upperCase(CharUtils.toString(chars[j])));
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


}

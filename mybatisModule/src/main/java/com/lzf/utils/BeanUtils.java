package com.lzf.utils;

import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述:
 * map与Object的相互转化
 *
 * @author liuzhenfei
 */
public abstract class BeanUtils {

    /**
     *  map --> Object
     * @param map map数据集合
     * @param beanClass 需封装的Bean
     * @return obj 封装好的实例
     * @throws IllegalAccessException InstantiationException 实体无法实例化或调用了private方法
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> beanClass) throws IllegalAccessException, InstantiationException {
        if (map == null){
            return null;
        }else{
            Map<String, Object> formatMap = new HashMap<>();
            for (String key : map.keySet()) {
                String newKey = ColumnFieldUtils.columnToField(key);
                formatMap.put(newKey,map.get(key));
            }



            Object obj = null ;
            Field[] fields = beanClass.getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                if( obj == null && formatMap.get(field.getName()) != null   ){
                    obj = beanClass.newInstance();
                }
                if(obj != null ){
                    field.setAccessible(true);
                    field.set(obj, formatMap.get(field.getName()));
                }
            }
            return obj;
        }
    }


    public static Object mapToObject(Map<String, Object> map, Object targetObj) throws IllegalAccessException, InstantiationException {
        if (map == null){
            return null;
        }else{
            Field[] fields = targetObj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                if(targetObj != null ){
                    field.setAccessible(true);
                    if(map.get(field.getName()) != null){
                        field.set(targetObj, map.get(field.getName()));
                    }

                }

            }
            return targetObj;
        }
    }


    /**
     *  Object -->map
     * @param obj 实例对象
     * @return map map集合
     * @throws Exception 调用了实例中的private方法
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        if(obj == null){
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        setMap(map, obj, obj.getClass().getDeclaredFields());
        //获取父节点字段
        setMap(map, obj, obj.getClass().getSuperclass().getDeclaredFields());
        return map;
    }

    /**
     *  Object -->map
     * @param obj 实例对象
     * @return map map集合
     */
    private static void setMap(Map<String,Object> map, Object obj, Field[] declaredFields) throws IllegalAccessException{
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Object o = field.get(obj);
            if(o instanceof String){
                String str = (String) o;
                map.put(field.getName(),str );
            }else if( o != null) {
                map.put(field.getName(),field.get(obj) );
            }else if(o instanceof Boolean){
                Boolean b = (Boolean) o;
                map.put(field.getName(),b );
            }
        }
    }


    /**
     *  Object -->Object
     * @param obj 数据对象
     * @param targetObj 返回对象
     * @return map
     * @throws Exception
     */

    public static Object object2Object(Object obj, Object targetObj) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        return object2Object(obj, targetObj, true );
    }

    /**
     * 将一个对象中的属性值转换到另一个对象上
     * @param obj 页面对象
     * @param targetObj 数据库查询对象
     * @param isString 是否对空字符串检测
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static Object object2Object(Object obj, Object targetObj, boolean isString ) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        Method[] methods = obj.getClass().getMethods();
        Map<String, Object> dataMap = objectToMap(obj);
        for (String key : dataMap.keySet()) {
            Object value = dataMap.get(key);
            if(value instanceof String && isString){
                if(StringUtils.isNotBlank((String)value)){
                    for (Method method : methods){
                        if (("set" + key).toLowerCase().equals(method.getName().toLowerCase())) {
                            method.invoke(targetObj,value);
                            break;
                        }
                    }
                }
            }else{
                if(value != null){
                    for (Method method : methods){
                        if (("set" + key).toLowerCase().equals(method.getName().toLowerCase())) {
                            method.invoke(targetObj,value);
                            break;
                        }
                    }
                }
            }
        }
        return targetObj;
    }
}

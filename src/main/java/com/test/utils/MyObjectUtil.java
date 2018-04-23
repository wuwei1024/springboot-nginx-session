package com.test.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wuwei
 * @date: 2018/4/23 15:38
 */

public class MyObjectUtil {

    /**
     * 构造器私有，防止外部实例化
     */
    private MyObjectUtil() {
    }

    /**
     * 利用反射将Java对象转转成Map
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        if (obj == null) return null;
        Map<String, Object> map = new HashMap<>();
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj));
        }
        return map;
    }

    /**
     * 利用反射将Map转转成Java对象
     *
     * @param map
     * @param clazz
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object mapToObject(Map<String, Object> map, Class<?> clazz) throws IllegalAccessException, InstantiationException {
        if (map == null) return null;
        Object obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            int mod = field.getModifiers();
            if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) continue;
            field.setAccessible(true);
            field.set(obj, map.get(field.getName()));
        }
        return obj;
    }
}

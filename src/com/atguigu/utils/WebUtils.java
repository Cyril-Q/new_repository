package com.atguigu.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * @author apple
 * @create 2021-04-23 下午10:56
 */
public class WebUtils {
    /**
     * 把Map中的值注入到对应的Javabean属性中
     * @param value
     * @param bean
     * @throws Exception
     */
    public static <T> T copyParamToBean(Map value, T bean) {
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    public static Integer parseInt(String s, Integer defaultValue) {
        if (s == null) {
            return defaultValue;
        }
        return Integer.parseInt(s);
    }
}

package com.chiyi.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @author chiyi
 */
public class CollectionUtil {

    /**
     * 集合里元素过多，拆分为多个
     * 将数据按照每批大小为maxBatchSize 分批, 剩余不够一批size的分为一批
     *
     * */
    public static <T> List<List<T>> splitBatch(List<T> data, int maxBatchSize) {
        List<List<T>> batches = new ArrayList<>();

        int startIndex = 0;
        for (; startIndex <= data.size() - maxBatchSize; startIndex += maxBatchSize) {
            List<T> subList = data.subList(startIndex, startIndex + maxBatchSize);
            batches.add(subList);
        }
        // 剩余部分作为一个batch
        if (startIndex <= data.size() - 1) {
            List<T> subList = data.subList(startIndex, data.size());
            batches.add(subList);
        }
        return batches;
    }

    /**
     * bean对象转为map, 字段一一对应
     * @param bean
     * @return
     */
    public static Map<String, Object> bean2map(Object bean) {
        if (bean == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!StringUtils.equals(key, "class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(bean);

                    map.put(key, value);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return map;

    }

    public static List<Map<String, Object>> beanList2MapList(List<?> beanList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (Object bean : beanList) {
            mapList.add(bean2map(bean));
        }
        return mapList;
    }
}

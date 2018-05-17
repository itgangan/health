package com.health.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class POJOConvertUtils<S, T> {

    public List<T> convert(List<S> sources) {
        List<T> tlist = new ArrayList<>();
        Class<T> rawType = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        for (S s : sources) {
            try {
                T t = rawType.newInstance();
                convert(s, t);
                tlist.add(t);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return tlist;

    }

    public void convert(S s, T t) {
        BeanUtils.copyProperties(s, t);
    }
}

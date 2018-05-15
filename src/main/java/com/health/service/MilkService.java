package com.health.service;

import com.health.bo.MilkBO;

import javax.inject.Named;

/**
 * 喂奶相关的业务
 */
@Named
public interface MilkService {

    /**
     * 插入一条喂奶记录（ps:为什么没有返回值标识save成功与否，答：save成功与否应该由exception来报告，service可以自己决定是否捕获dao的异常）
     * @param milkBO
     */
    void saveMilk(MilkBO milkBO);


}

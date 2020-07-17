package com.example.demo.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * @author yanzhongliu
 * @email yanzhongliu@ctrip.com
 * @date 2020/6/23 16:10
 */
public interface CustomBaseMapper<T> extends BaseMapper<T> {

    /**
     * 请经过严格测试之后使用！！
     * 存在以下问题：
     * 如果mysql设置了默认值且实体中未设置值则此值在数据库中不会被填写！！
     * @param entityList
     * @return
     */
    int insertBatchSomeColumn(List<T> entityList);
}

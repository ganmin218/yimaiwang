package com.cn.dao;

import com.cn.entity.Enews;

public interface EnewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enews record);

    int insertSelective(Enews record);

    Enews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Enews record);

    int updateByPrimaryKey(Enews record);
}
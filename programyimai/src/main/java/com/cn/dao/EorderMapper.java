package com.cn.dao;

import com.cn.entity.Eorder;

public interface EorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eorder record);

    int insertSelective(Eorder record);

    Eorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eorder record);

    int updateByPrimaryKey(Eorder record);
}
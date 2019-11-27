package com.cn.dao;

import com.cn.entity.Eodetail;

public interface EodetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eodetail record);

    int insertSelective(Eodetail record);

    Eodetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eodetail record);

    int updateByPrimaryKey(Eodetail record);
}
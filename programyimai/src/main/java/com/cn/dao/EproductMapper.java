package com.cn.dao;

import com.cn.entity.Eproduct;

import java.util.List;

public interface EproductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eproduct record);

    int insertSelective(Eproduct record);

    Eproduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eproduct record);

    int updateByPrimaryKey(Eproduct record);

    List<Eproduct> selectproducts();
}
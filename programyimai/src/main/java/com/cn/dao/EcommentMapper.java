package com.cn.dao;

import com.cn.entity.Ecomment;

import java.util.List;

public interface EcommentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ecomment record);

    int insertSelective(Ecomment record);

    Ecomment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ecomment record);

    int updateByPrimaryKey(Ecomment record);

    List<Ecomment> selectEcomment();

}
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

    //登录后就查询
    List<Eproduct> selectproducts();

    List<Eproduct> selectproductsBypage(Integer ye);

    //根据二级目录
    List<Eproduct> selectproductsByEpcategoryId(Integer id);

    List<Eproduct> selectproductsByEpcategoryIdpage(Integer id, Integer ye);
}
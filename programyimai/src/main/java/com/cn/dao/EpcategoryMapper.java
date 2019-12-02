package com.cn.dao;

import com.cn.entity.Epcategory;

import java.util.List;

public interface EpcategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Epcategory record);

    int insertSelective(Epcategory record);

    Epcategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Epcategory record);

    int updateByPrimaryKey(Epcategory record);

    List<Epcategory> selectEpcategoryByParentId(Integer id);

    //查全部
    List<Epcategory> selectAllEpcategory();
}
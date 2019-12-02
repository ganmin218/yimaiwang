package com.cn.dao;

import com.cn.entity.Enews;

import java.util.List;

public interface EnewsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Enews record);

    int insertSelective(Enews record);

    Enews selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Enews record);

    int updateByPrimaryKey(Enews record);

    //显示新闻
    List<Enews> selectEnews();

    //新闻管理 根据页面查询
    List<Enews> selectEnewsByPage(Integer ye);

}
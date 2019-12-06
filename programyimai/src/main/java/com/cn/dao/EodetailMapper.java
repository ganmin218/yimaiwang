package com.cn.dao;

import com.cn.entity.Eodetail;

import java.util.List;

public interface EodetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eodetail record);

    int insertSelective(Eodetail record);

    Eodetail selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eodetail record);

    int updateByPrimaryKey(Eodetail record);

    //显示所有订单
    List<Eodetail> selectAllEodetail();

    //分页查询
    List<Eodetail> selectEodetailByPage(Integer ye);

    //查看自己的购物车
    List<Eodetail> selectmyEodetail(Integer id);

    //分页查询自己的
    List<Eodetail> selectmyEodetailByPage(Integer id, Integer ye);

    //模糊查询订单
    List<Eodetail> selectEodetailByidname(Eodetail eodetail);

}
package com.cn.dao;

import com.cn.entity.Eorder;

import java.util.List;

public interface EorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Eorder record);

    int insertSelective(Eorder record);

    Eorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Eorder record);

    int updateByPrimaryKey(Eorder record);

    //根据商品id判断购物车是否有此物品
    Eorder selectByproductid(Integer id, Integer userid);

    //显示购物车
    List<Eorder> selectallorderByuserid(Integer id);

    //显示购物车分页
    List<Eorder> selectorderByuseridPage(Integer id, Integer ye);


}
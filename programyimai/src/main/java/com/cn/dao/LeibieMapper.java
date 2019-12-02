package com.cn.dao;

import com.cn.entity.Leibie;

import java.util.List;

public interface LeibieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Leibie record);

    int insertSelective(Leibie record);

    Leibie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Leibie record);

    int updateByPrimaryKey(Leibie record);

    List<Leibie> selectLeibie();

    Leibie selectLeibieByName(String name);

    //类别分页查询
    List<Leibie> selectLeibieByPage(Integer ye);
}
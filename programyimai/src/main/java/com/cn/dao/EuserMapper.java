package com.cn.dao;

import com.cn.entity.Euser;

public interface EuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Euser record);

    int insertSelective(Euser record);

    Euser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Euser record);

    int updateByPrimaryKey(Euser record);

    Euser selectuser(Euser user);

}
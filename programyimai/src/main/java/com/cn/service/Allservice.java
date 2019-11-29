package com.cn.service;

import com.cn.entity.*;

import java.util.List;

public interface Allservice {
    Euser selectuser(Euser user);

    List<Eproduct> selectproducts();

    void insertUser(Euser user);

    List<Ecomment> selectEcomment();

    //添加评论
    int insertSelective(Ecomment record);

    //删除评论
    int deleteByPrimaryKey(Integer id);

    //查看当条留言
    Ecomment selectByPrimaryKey(Integer id);

    //管理员回复留言
    int updateByPrimaryKeySelective(Ecomment record);

    //显示用户左侧
    List<Leibie> selectLeibie();

    Leibie selectLeibieByName(String name);

    //查二级目录
    List<Epcategory> selectEpcategoryByParentId(Integer id);

    //显示新闻
    List<Enews> selectEnews();


}

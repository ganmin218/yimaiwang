package com.cn.service;

import com.cn.entity.*;

import java.util.List;

public interface Allservice {
    Euser selectuser(Euser user);

    //首页显示商品
    List<Eproduct> selectproducts();

    List<Eproduct> selectproductsBypage(Integer ye);

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

    Enews selectEnewsByPrimaryKey(Integer id);

    //根据二级目录
    List<Eproduct> selectproductsByEpcategoryId(Integer id);

    List<Eproduct> selectproductsByEpcategoryIdpage(Integer id, Integer ye);

    //用户管理
    List<Euser> selectAlluser();

    Euser selectuserByPrimaryKey(Integer id);

    int updateUserByPrimaryKeySelective(Euser record);

    int deleteUserByPrimaryKey(Integer id);

    //新闻管理,查看新闻根据id
    int updatenewsByPrimaryKeySelective(Enews record);

    //添加新闻
    int insertnewsSelective(Enews record);

    //删除新闻
    int deletenewsByPrimaryKey(Integer id);

    //商品管理
    //添加商品
    int insertproductSelective(Eproduct record);


    //分类管理
    //查看单条分类
    Leibie selectleibieByPrimaryKey(Integer id);

    int updateleibieByPrimaryKeySelective(Leibie record);

    int deleteleibieByPrimaryKey(Integer id);

    int insertleibieSelective(Leibie record);

    //二级目录
    Epcategory selectEpcategoryByPrimaryKey(Integer id);

    int updateEpcategoryByPrimaryKeySelective(Epcategory record);

    int deleteEpcategoryByPrimaryKey(Integer id);

    int insertEpcategorySelective(Epcategory record);


}

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

    //根据页面编号查
    List<Ecomment> selectEcommentByPage(Integer ye);

    //显示用户左侧
    List<Leibie> selectLeibie();

    Leibie selectLeibieByName(String name);

    //查二级目录
    List<Epcategory> selectEpcategoryByParentId(Integer id);

    //显示新闻
    List<Enews> selectEnews();

    //新闻管理 根据页面查询
    List<Enews> selectEnewsByPage(Integer ye);
    Enews selectEnewsByPrimaryKey(Integer id);

    //根据二级目录
    List<Eproduct> selectproductsByEpcategoryId(Integer id);

    List<Eproduct> selectproductsByEpcategoryIdpage(Integer id, Integer ye);

    //用户管理
    List<Euser> selectAlluser();
    Euser selectuserByPrimaryKey(Integer id);
    int updateUserByPrimaryKeySelective(Euser record);
    int deleteUserByPrimaryKey(Integer id);

    //根据页面显示
    List<Euser> selectuserByPage(Integer ye);

    //新闻管理,查看新闻根据id
    int updatenewsByPrimaryKeySelective(Enews record);

    //添加新闻
    int insertnewsSelective(Enews record);

    //删除新闻
    int deletenewsByPrimaryKey(Integer id);

    //商品管理
    //添加商品
    int insertproductSelective(Eproduct record);

    Eproduct selectproductByPrimaryKey(Integer id);

    int updateproductByPrimaryKeySelective(Eproduct record);

    int deleteproductByPrimaryKey(Integer id);


    //分类管理
    //类别分页查询
    List<Leibie> selectLeibieByPage(Integer ye);
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

    //查全部二级目录
    List<Epcategory> selectAllEpcategory();

    //用户购物处理
    //加入购物车
    int insertorderSelective(Eorder record);

    //根据商品id判断购物车是否有此物品
    Eorder selectByproductid(Integer id, Integer userid);

    //商品已经加入过购物车修改数量
    int updateorderByPrimaryKeySelective(Eorder record);

    //显示购物车
    List<Eorder> selectallorderByuserid(Integer id);

    int deleteorderByPrimaryKey(Integer id);

    //显示购物车分页
    List<Eorder> selectorderByuseridPage(Integer id, Integer ye);

    //根据订单id查询订单
    Eorder selectorderByPrimaryKey(Integer id);

    //生成订单,插入数据库
    int insertEodetailSelective(Eodetail record);

    //显示所有订单
    List<Eodetail> selectAllEodetail();

    //分页查询
    List<Eodetail> selectEodetailByPage(Integer ye);

    //删除订单根据id
    int deleteEodetailByPrimaryKey(Integer id);

    Eodetail selectEodetailByPrimaryKey(Integer id);

    //修改订单
    int updateEodetailByPrimaryKeySelective(Eodetail record);

    //查看自己的购物车
    List<Eodetail> selectmyEodetail(Integer id);

    //分页查询自己的
    List<Eodetail> selectmyEodetailByPage(Integer id, Integer ye);

}

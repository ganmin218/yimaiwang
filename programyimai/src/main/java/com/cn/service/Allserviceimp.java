package com.cn.service;


import com.cn.dao.*;
import com.cn.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Allserviceimp implements Allservice {
    @Autowired
    EuserMapper euserMapper;
    @Autowired
    EproductMapper eproductMapper;
    @Autowired
    EcommentMapper ecommentMapper;
    @Autowired
    LeibieMapper leibieMapper;
    @Autowired
    EpcategoryMapper epcategoryMapper;
    @Autowired
    EnewsMapper enewsMapper;

    //查用户验证
    public Euser selectuser(Euser user) {
        return euserMapper.selectuser(user);
    }

    //首页显示商品
    public List<Eproduct> selectproducts() {
        return eproductMapper.selectproducts();
    }

    public List<Eproduct> selectproductsBypage(Integer ye) {
        return eproductMapper.selectproductsBypage(ye);
    }

    //注册用户
    public void insertUser(Euser user) {
        euserMapper.insertSelective(user);
    }

    //显示评论
    public List<Ecomment> selectEcomment() {
        return ecommentMapper.selectEcomment();
    }

    //添加评论
    public int insertSelective(Ecomment record) {
        return ecommentMapper.insertSelective(record);
    }

    //删除评论
    public int deleteByPrimaryKey(Integer id) {
        return ecommentMapper.deleteByPrimaryKey(id);
    }

    //查看当条留言
    public Ecomment selectByPrimaryKey(Integer id) {
        return ecommentMapper.selectByPrimaryKey(id);
    }

    //管理员回复留言
    public int updateByPrimaryKeySelective(Ecomment record) {
        return ecommentMapper.updateByPrimaryKeySelective(record);
    }

    //显示用户左侧
    public List<Leibie> selectLeibie() {
        return leibieMapper.selectLeibie();
    }

    public Leibie selectLeibieByName(String name) {
        return leibieMapper.selectLeibieByName(name);
    }

    //查二级目录
    public List<Epcategory> selectEpcategoryByParentId(Integer id) {
        return epcategoryMapper.selectEpcategoryByParentId(id);
    }

    //根据二级目录
    public List<Eproduct> selectproductsByEpcategoryId(Integer id) {
        return eproductMapper.selectproductsByEpcategoryId(id);
    }

    public List<Eproduct> selectproductsByEpcategoryIdpage(Integer id, Integer ye) {
        return eproductMapper.selectproductsByEpcategoryIdpage(id, ye);
    }

    //显示新闻
    public List<Enews> selectEnews() {
        return enewsMapper.selectEnews();
    }

    //单条新闻
    public Enews selectEnewsByPrimaryKey(Integer id) {
        return enewsMapper.selectByPrimaryKey(id);
    }

    //用户管理
    public List<Euser> selectAlluser() {
        return euserMapper.selectAlluser();
    }

    //根据id查询用户
    public Euser selectuserByPrimaryKey(Integer id) {
        return euserMapper.selectByPrimaryKey(id);
    }

    //修改用户信息
    public int updateUserByPrimaryKeySelective(Euser record) {
        return euserMapper.updateByPrimaryKeySelective(record);
    }

    //删除用户根据id
    public int deleteUserByPrimaryKey(Integer id) {
        return euserMapper.deleteByPrimaryKey(id);
    }

    //新闻管理,修改新闻
    public int updatenewsByPrimaryKeySelective(Enews record) {
        return enewsMapper.updateByPrimaryKeySelective(record);
    }

    //新增新闻
    public int insertnewsSelective(Enews record) {
        return enewsMapper.insertSelective(record);
    }

    //删除新闻
    public int deletenewsByPrimaryKey(Integer id) {
        return enewsMapper.deleteByPrimaryKey(id);
    }

    //商品管理
    //添加商品
    public int insertproductSelective(Eproduct record) {
        return eproductMapper.insertSelective(record);
    }

    //分类管理
    //查看单条分类
    public Leibie selectleibieByPrimaryKey(Integer id) {
        return leibieMapper.selectByPrimaryKey(id);
    }

    public int updateleibieByPrimaryKeySelective(Leibie record) {
        return leibieMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteleibieByPrimaryKey(Integer id) {
        return leibieMapper.deleteByPrimaryKey(id);
    }

    public int insertleibieSelective(Leibie record) {
        return leibieMapper.insertSelective(record);
    }

    //二级目录
    public Epcategory selectEpcategoryByPrimaryKey(Integer id) {
        return epcategoryMapper.selectByPrimaryKey(id);
    }

    public int updateEpcategoryByPrimaryKeySelective(Epcategory record) {
        return epcategoryMapper.updateByPrimaryKeySelective(record);
    }

    public int deleteEpcategoryByPrimaryKey(Integer id) {
        return epcategoryMapper.deleteByPrimaryKey(id);
    }

    public int insertEpcategorySelective(Epcategory record) {
        return epcategoryMapper.insertSelective(record);
    }
}

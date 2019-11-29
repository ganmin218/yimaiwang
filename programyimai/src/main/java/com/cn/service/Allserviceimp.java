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

    //显示商品
    public List<Eproduct> selectproducts() {
        return eproductMapper.selectproducts();
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

    //显示新闻
    public List<Enews> selectEnews() {
        return enewsMapper.selectEnews();
    }
}

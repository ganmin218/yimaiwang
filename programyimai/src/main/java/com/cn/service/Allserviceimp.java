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
    @Autowired
    EorderMapper eorderMapper;
    @Autowired
    EodetailMapper eodetailMapper;

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

    //根据页面编号查评论
    public List<Ecomment> selectEcommentByPage(Integer ye) {
        return ecommentMapper.selectEcommentByPage(ye);
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

    //新闻管理 根据页面查询
    public List<Enews> selectEnewsByPage(Integer ye) {
        return enewsMapper.selectEnewsByPage(ye);
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

    //根据页面显示
    public List<Euser> selectuserByPage(Integer ye) {
        return euserMapper.selectuserByPage(ye);
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

    //修改商品先查当前商品
    public Eproduct selectproductByPrimaryKey(Integer id) {
        return eproductMapper.selectByPrimaryKey(id);
    }

    public int updateproductByPrimaryKeySelective(Eproduct record) {
        return eproductMapper.updateByPrimaryKeySelective(record);
    }

    //删除商品
    public int deleteproductByPrimaryKey(Integer id) {
        return eproductMapper.deleteByPrimaryKey(id);
    }

    //分类管理
    //类别分页查询
    public List<Leibie> selectLeibieByPage(Integer ye) {
        return leibieMapper.selectLeibieByPage(ye);
    }
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

    //查全部二级目录
    public List<Epcategory> selectAllEpcategory() {
        return epcategoryMapper.selectAllEpcategory();
    }

    //用户购物处理
    //加入购物车
    public int insertorderSelective(Eorder record) {
        return eorderMapper.insertSelective(record);
    }

    //根据商品id判断购物车是否有此物品
    public Eorder selectByproductid(Integer id, Integer userid) {
        return eorderMapper.selectByproductid(id, userid);
    }

    //商品已经加入过购物车修改数量
    public int updateorderByPrimaryKeySelective(Eorder record) {
        return eorderMapper.updateByPrimaryKeySelective(record);
    }

    //显示购物车
    public List<Eorder> selectallorderByuserid(Integer id) {
        return eorderMapper.selectallorderByuserid(id);
    }

    //显示购物车分页
    public List<Eorder> selectorderByuseridPage(Integer id, Integer ye) {
        return eorderMapper.selectorderByuseridPage(id, ye);
    }

    //删除购物车的东西
    public int deleteorderByPrimaryKey(Integer id) {
        return eorderMapper.deleteByPrimaryKey(id);
    }

    //根据订单id查询订单
    public Eorder selectorderByPrimaryKey(Integer id) {
        return eorderMapper.selectByPrimaryKey(id);
    }

    //生成订单,插入数据库
    public int insertEodetailSelective(Eodetail record) {
        return eodetailMapper.insertSelective(record);
    }

    //显示所有订单
    public List<Eodetail> selectAllEodetail() {
        return eodetailMapper.selectAllEodetail();
    }

    //分页查询
    public List<Eodetail> selectEodetailByPage(Integer ye) {
        return eodetailMapper.selectEodetailByPage(ye);
    }

    //删除订单根据id
    public int deleteEodetailByPrimaryKey(Integer id) {
        return eodetailMapper.deleteByPrimaryKey(id);
    }

    //找到付款订单
    public Eodetail selectEodetailByPrimaryKey(Integer id) {
        return eodetailMapper.selectByPrimaryKey(id);
    }

    //修改订单
    public int updateEodetailByPrimaryKeySelective(Eodetail record) {
        return eodetailMapper.updateByPrimaryKeySelective(record);
    }

    //查看自己的购物车
    public List<Eodetail> selectmyEodetail(Integer id) {
        return eodetailMapper.selectmyEodetail(id);
    }

    //分页查询自己的
    public List<Eodetail> selectmyEodetailByPage(Integer id, Integer ye) {
        return eodetailMapper.selectmyEodetailByPage(id, ye);
    }

}

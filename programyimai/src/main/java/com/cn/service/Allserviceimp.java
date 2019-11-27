package com.cn.service;


import com.cn.dao.EproductMapper;
import com.cn.dao.EuserMapper;
import com.cn.entity.Eproduct;
import com.cn.entity.Euser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Allserviceimp implements Allservice {
    @Autowired
    EuserMapper euserMapper;
    @Autowired
    EproductMapper eproductMapper;

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
}

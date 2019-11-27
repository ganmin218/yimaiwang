package com.cn.service;

import com.cn.entity.Eproduct;
import com.cn.entity.Euser;

import java.util.List;

public interface Allservice {
    Euser selectuser(Euser user);

    List<Eproduct> selectproducts();

    void insertUser(Euser user);


}

package com.cn.entity;

import java.util.Date;

public class Eodetail {
    private Integer id;

    private Integer userid;

    private String loginname;

    private String details;

    private String useraddress;

    private Date createtime;

    private Float cost;

    private String serialnumber;

    private String status;

    private String paymoney;

    public Eodetail(Integer id, Integer userid, String loginname, String details, String useraddress, Date createtime, Float cost, String serialnumber, String status, String paymoney) {
        this.id = id;
        this.userid = userid;
        this.loginname = loginname;
        this.details = details;
        this.useraddress = useraddress;
        this.createtime = createtime;
        this.cost = cost;
        this.serialnumber = serialnumber;
        this.status = status;
        this.paymoney = paymoney;
    }

    public Eodetail() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress == null ? null : useraddress.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(String paymoney) {
        this.paymoney = paymoney == null ? null : paymoney.trim();
    }

    public Eodetail(Integer userid, String loginname, String details, String useraddress, Date createtime, Float cost, String serialnumber, String status, String paymoney) {
        this.userid = userid;
        this.loginname = loginname;
        this.details = details;
        this.useraddress = useraddress;
        this.createtime = createtime;
        this.cost = cost;
        this.serialnumber = serialnumber;
        this.status = status;
        this.paymoney = paymoney;
    }

    public Eodetail(Integer id, String loginname, String useraddress, Date createtime, Float cost, String status) {
        this.id = id;
        this.loginname = loginname;
        this.useraddress = useraddress;
        this.createtime = createtime;
        this.cost = cost;
        this.status = status;
    }

    public Eodetail(Integer id, String loginname) {
        this.id = id;
        this.loginname = loginname;
    }
}
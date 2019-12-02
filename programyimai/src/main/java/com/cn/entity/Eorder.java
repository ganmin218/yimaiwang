package com.cn.entity;

public class Eorder {
    private Integer id;

    private Integer productid;

    private Integer euserid;

    private String productname;

    private String productfilname;

    private Integer quantity;

    private String userloginname;

    private Float cost;

    public Eorder(Integer id, Integer productid, Integer euserid, String productname, String productfilname, Integer quantity, String userloginname, Float cost) {
        this.id = id;
        this.productid = productid;
        this.euserid = euserid;
        this.productname = productname;
        this.productfilname = productfilname;
        this.quantity = quantity;
        this.userloginname = userloginname;
        this.cost = cost;
    }

    public Eorder() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getEuserid() {
        return euserid;
    }

    public void setEuserid(Integer euserid) {
        this.euserid = euserid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getProductfilname() {
        return productfilname;
    }

    public void setProductfilname(String productfilname) {
        this.productfilname = productfilname == null ? null : productfilname.trim();
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getUserloginname() {
        return userloginname;
    }

    public void setUserloginname(String userloginname) {
        this.userloginname = userloginname == null ? null : userloginname.trim();
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Eorder(Integer productid, Integer euserid, String productname, String productfilname, Integer quantity, String userloginname, Float cost) {
        this.productid = productid;
        this.euserid = euserid;
        this.productname = productname;
        this.productfilname = productfilname;
        this.quantity = quantity;
        this.userloginname = userloginname;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Eorder{" +
                "id=" + id +
                ", productid=" + productid +
                ", euserid=" + euserid +
                ", productname='" + productname + '\'' +
                ", productfilname='" + productfilname + '\'' +
                ", quantity=" + quantity +
                ", userloginname='" + userloginname + '\'' +
                ", cost=" + cost +
                '}';
    }

    public Eorder(Integer id, Integer quantity, Float cost) {
        this.id = id;
        this.quantity = quantity;
        this.cost = cost;
    }
}
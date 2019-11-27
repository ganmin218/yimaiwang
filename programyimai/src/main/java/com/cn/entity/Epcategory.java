package com.cn.entity;

public class Epcategory {
    private Integer id;

    private String name;

    private Integer parentid;

    private Integer type;

    private String iconclass;

    public Epcategory(Integer id, String name, Integer parentid, Integer type, String iconclass) {
        this.id = id;
        this.name = name;
        this.parentid = parentid;
        this.type = type;
        this.iconclass = iconclass;
    }

    public Epcategory() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIconclass() {
        return iconclass;
    }

    public void setIconclass(String iconclass) {
        this.iconclass = iconclass == null ? null : iconclass.trim();
    }
}
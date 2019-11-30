package com.cn.entity;

public class Leibie {
    private Integer id;

    private String name;

    public Leibie(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Leibie() {
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

    @Override
    public String toString() {
        return "Leibie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Leibie(String name) {
        this.name = name;
    }
}
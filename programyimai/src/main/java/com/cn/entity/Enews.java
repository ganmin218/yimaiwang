package com.cn.entity;

public class Enews {
    private Integer id;

    private String title;

    private String content;

    private String createtime;

    public Enews(Integer id, String title, String content, String createtime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createtime = createtime;
    }

    public Enews() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime == null ? null : createtime.trim();
    }

    @Override
    public String toString() {
        return "Enews{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createtime='" + createtime + '\'' +
                '}';
    }

    public Enews(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Enews(String title, String content, String createtime) {
        this.title = title;
        this.content = content;
        this.createtime = createtime;
    }
}
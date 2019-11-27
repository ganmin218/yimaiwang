package com.cn.entity;

public class Ecomment {
    private Integer id;

    private String reply;

    private String content;

    private String createtime;

    private String replytime;

    private String nickname;

    public Ecomment(Integer id, String reply, String content, String createtime, String replytime, String nickname) {
        this.id = id;
        this.reply = reply;
        this.content = content;
        this.createtime = createtime;
        this.replytime = replytime;
        this.nickname = nickname;
    }

    public Ecomment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply == null ? null : reply.trim();
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

    public String getReplytime() {
        return replytime;
    }

    public void setReplytime(String replytime) {
        this.replytime = replytime == null ? null : replytime.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }
}
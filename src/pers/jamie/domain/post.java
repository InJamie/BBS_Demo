package pers.jamie.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class post {
    /**
     * 帖子类
     * 主题 名称 创建时间 作者
     */
    private int post_id;
    private int theme_id;
    private String post_title;
    //借助注解将数据库传来的时间戳格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date crete_time;
    private int author;
    private String post_content;

    @Override
    public String toString() {
        return "post{" +
                "post_id=" + post_id +
                ", theme_id=" + theme_id +
                ", post_title='" + post_title + '\'' +
                ", crete_time=" + crete_time +
                ", author=" + author +
                ", post_content='" + post_content + '\'' +
                '}';
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getTheme_id() {
        return theme_id;
    }

    public void setTheme_id(int theme_id) {
        this.theme_id = theme_id;
    }

    public Date getCrete_time() {
        return crete_time;
    }

    public void setCrete_time(Date crete_time) {
        this.crete_time = crete_time;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }
}

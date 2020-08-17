package pers.jamie.service;

import pers.jamie.domain.PageBean;
import pers.jamie.domain.post;

import java.util.List;

public interface PostService {
    /**
     * 删除帖子
     */
    void deletepost(int post_id);

    /**
     * 根据当前页码获取当前页帖子
     */
    PageBean getpostByPage(PageBean pageBean);


    /**
     * 获取帖子
     */
    List<post> getpost();

    /**
     * 添加帖子
     */
    void addpost(post post);

    /**
     * 根据post_id查找post详细信息
     */
    post findbyid(String id);

}

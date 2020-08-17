package pers.jamie.dao;

import pers.jamie.domain.PageBean;
import pers.jamie.domain.post;

import java.util.List;

public interface PostDao {

    void deletepost(int post_id);

    int findAllCount();

    List<post> getpostByPage(PageBean pageBean);

    List<post> getpost();

    void addpost(post post);

    post findbyid(String id);
}

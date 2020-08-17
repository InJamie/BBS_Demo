package pers.jamie.service;

import pers.jamie.domain.Comment;
import pers.jamie.domain.post;

import java.util.List;

public interface CommentService {
    /**
     * 添加评论
     */
    void addcomment(Comment comment);

    /**
     * 查找评论
     */
    List<Comment> getcomments(int post_id);
}

package pers.jamie.dao;

import pers.jamie.domain.Comment;
import pers.jamie.domain.post;

import java.util.List;

public interface CommentDao {
    void addcomment(Comment comment);

    List<Comment> getcomments(int post_id);

}

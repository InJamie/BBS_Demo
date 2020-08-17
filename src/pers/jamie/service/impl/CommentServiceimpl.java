package pers.jamie.service.impl;

import pers.jamie.dao.CommentDao;
import pers.jamie.dao.impl.CommentDaoimpl;
import pers.jamie.domain.Comment;
import pers.jamie.domain.post;
import pers.jamie.service.CommentService;

import java.util.List;

public class CommentServiceimpl implements CommentService {
    private CommentDao dao = new CommentDaoimpl();

    @Override
    public void addcomment(Comment comment) {
        dao.addcomment(comment);
    }

    @Override
    public List<Comment> getcomments(int post_id) {
        return dao.getcomments(post_id);
    }
}

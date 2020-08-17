package pers.jamie.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.jamie.Utils.JDBCutil;
import pers.jamie.dao.CommentDao;
import pers.jamie.domain.Comment;

import java.util.List;

public class CommentDaoimpl implements CommentDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutil.getDataSource());

    @Override
    public void addcomment(Comment comment) {
        String sql = "INSERT INTO COMMENT VALUES(NULL,?,NOW(),?,?,?);";
        int update = template.update(sql,
                comment.getCotent(),
                comment.getAuthor_id(),
                comment.getPost_id(),
                comment.getAuthor()
        );
    }

    @Override
    public List<Comment> getcomments(int post_id) {
        String sql = "select * from comment where post_id =?";
        List<Comment> list = template.query(sql, new BeanPropertyRowMapper<Comment>(Comment.class), post_id);
        return list;
    }
}

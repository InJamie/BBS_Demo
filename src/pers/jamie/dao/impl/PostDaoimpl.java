package pers.jamie.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.jamie.Utils.JDBCutil;
import pers.jamie.dao.PostDao;
import pers.jamie.domain.PageBean;
import pers.jamie.domain.post;

import java.util.List;

public class PostDaoimpl implements PostDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutil.getDataSource());

    @Override
    public void deletepost(int post_id) {
        String sql = "delete from post where post_id = ?";
        template.update(sql, post_id);
    }

    @Override
    public int findAllCount() {
        String sql = "SELECT COUNT(*) FROM post";
        return template.queryForObject(sql, Integer.class);
    }

    @Override
    public List<post> getpostByPage(PageBean pageBean) {
        int currentPage = pageBean.getCurrentPage();
        int pageSize = pageBean.getPageSize();
        String sql = "select * from post limit ?,?";
        return template.query(sql, new BeanPropertyRowMapper<post>(post.class), currentPage * pageSize, pageSize);
    }

    @Override
    public List<post> getpost() {
        String sql = "select * from post";
        List<post> list = template.query(sql, new BeanPropertyRowMapper<post>(post.class));
        return template.query(sql, new BeanPropertyRowMapper<post>(post.class));
    }

    @Override
    public void addpost(post post) {
        String sql = "insert into post values(null,?,?,NOW(),?,?)";
        int update = template.update(sql,
                post.getTheme_id(),
                post.getPost_title(),
                post.getAuthor(),
                post.getPost_content()
        );
        System.out.println(update);
    }

    @Override
    public post findbyid(String id) {
        String sql = "select * from post where post_id = ?";
        post post = (post) template.queryForObject(sql, new BeanPropertyRowMapper<post>(post.class), id);
        return post;
    }
}

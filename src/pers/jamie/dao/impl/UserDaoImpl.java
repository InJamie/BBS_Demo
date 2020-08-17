package pers.jamie.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import pers.jamie.Utils.JDBCutil;
import pers.jamie.dao.UserDao;
import pers.jamie.domain.User;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCutil.getDataSource());

    @Override
    public User findByUsername(String username) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where username = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
        } catch (Exception e) {

        }
        return user;
    }

    @Override
    public String findById(int id) {
        User user = null;
        try {
            //1.定义sql
            String sql = "select * from user where id = ?";
            //2.执行sql
            user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), id);
        } catch (Exception e) {

        }
        return user.getName();
    }

    @Override
    public User login(String name, String password) {
        System.out.println("执行dao");
        try {
            String sql = "select * from user where username = ? and password = ?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), name, password);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void register(User user) {
        System.out.println("添加用户");
        System.out.println("dao_user======" + user);
        //1.定义sql
        String sql = "insert into user values(null,?,?,?,?,?,?,0 )";
        //2.执行sql
        int i = template.update(sql,
                user.getName(),
                user.getGender(),
                user.getEmail(),
                user.getNumber(),
                user.getUsername(),
                user.getPassword());
        System.out.println(i);
    }
}

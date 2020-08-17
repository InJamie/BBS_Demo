package pers.jamie.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import pers.jamie.domain.User;
import pers.jamie.domain.post;

import java.util.List;

/**
 * 链接数据库方法接口
 */
public interface UserDao {


    User login(String name, String password);

    void register(User user);

    User findByUsername(String username);

    String findById(int id);
}

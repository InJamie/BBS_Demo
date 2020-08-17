package pers.jamie.service;

import pers.jamie.domain.User;
import pers.jamie.domain.post;

import java.util.List;

/**
 * 用户操作业务接口
 */
public interface UserService {
    /**
     * 登录验证方法接口
     */
    User login(User user);

    /**
     * 注册方法接口
     */
    boolean register(User user);

    /**
     * 根据姓名查找用户
     */
    User findUserByName(String name);

    /**
     * 根据user_id寻找用户名
     */
    String findById(int id);
}

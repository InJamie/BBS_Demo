package pers.jamie.service.impl;

import org.junit.Test;
import pers.jamie.dao.impl.UserDaoImpl;
import pers.jamie.domain.User;
import pers.jamie.domain.post;
import pers.jamie.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDaoImpl dao = new UserDaoImpl();

    @Override
    public User login(User user) {
        System.out.println("执行到service");
        return dao.login(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean register(User user) {
        System.out.println("service_user====" + user);
//        先查重名再添加用户
        User byUsername = dao.findByUsername(user.getUsername());

        if (byUsername != null) {
            return false;
        }
        dao.register(user);
        return true;
    }

    @Override
    public User findUserByName(String name) {
        return dao.findByUsername(name);
    }

    @Override
    public String findById(int id) {
        return dao.findById(id);
    }


}

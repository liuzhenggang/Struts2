package com.xk.service;

import com.xk.dao.UserDao;
import com.xk.model.User;
import com.xk.util.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    private UserDao userDao;
    //checkUser
    public boolean checkUser(User user) {
        userDao = new UserDao();
        return userDao.checkUser(user);
    }

    //addUser
    public boolean addUser(User user) {
        userDao = new UserDao();
        return userDao.addUser(user);
    }

    //delUser
    public boolean delUser(int id) {
        userDao = new UserDao();
        return userDao.delUser(id);
    }

    //updUser
    public boolean updUser(User user) {
        userDao = new UserDao();
        return userDao.updUser(user);
    }

    //getUserById
    public User getUserById(int id) {
        userDao = new UserDao();
        return userDao.getUserById(id);
    }

    //searchUsers
    public ArrayList<User> searchUsers(User user) {
        userDao = new UserDao();
        return userDao.searchUsers(user);
    }
}

package com.xk.service;

import com.xk.dao.UserDao;
import com.xk.model.User;
import com.xk.util.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    public UserDao userDao;
    //checkUser
    public boolean checkUser(User user) {
        return userDao.checkUser(user);
    }

    //addUser
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    //getAllUsers
    public ArrayList<User> getAllUsers() {
        return userDao.getAllUsers();
    }
}

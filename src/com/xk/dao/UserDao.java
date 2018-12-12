package com.xk.dao;

import com.xk.model.User;
import com.xk.util.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    //checkUser
    public boolean checkUser(User user) {
        String sql = "select * from user where username = ? and password = ?";
        String[] parameters = {user.getUsername(), user.getPassword()};
        return executeSql(sql, parameters);
    }

    //addUser
    public boolean addUser(User user) {
        String sql = "insert into user(`username`,`password`,`email`,`identity`) values (?,?,?,?)";
        String[] parameters = {user.getUsername(), user.getPassword(), user.getEmail(), user.getIdentity()};
        return executeSql(sql, parameters);
    }

    //getAllUsers
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        String sql = "select * from user";
        String[] parameters = null;
        ResultSet rs = SQLHelper.executeQuery(sql, parameters);
        try {
            while (rs.next()) {
                User user = new User();
                allUsers.add(setUserInfo(user, rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return allUsers;
    }

    private boolean executeSql(String sql, String[] parameters){
        boolean flag = false;
        ResultSet rs = SQLHelper.executeQuery(sql, parameters);
        try {
            if (rs.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return flag;
    }

    private User setUserInfo(User user, ResultSet rs){
        try{
            user.setId(rs.getString( 1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setIdentity(rs.getString(5));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return user;
    }
}

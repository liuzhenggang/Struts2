package com.xk.dao;

import com.xk.model.User;
import com.xk.util.SQLHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {
    //checkUser
    public boolean checkUser(User user) {
        boolean flag = false;
        String sql = "select * from user where username = ? and password = ?";
        String[] parameters = {user.getUsername(), user.getPassword()};

        ResultSet rs = SQLHelper.executeQuery(sql, parameters);
        try {
            while (rs.next()) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return flag;
    }

    //addUser
    public boolean addUser(User user) {
        String sql = "insert into user(`id`,`username`,`password`,`email`,`identity`) values (0,?,?,?,?)";
        String[] parameters = {user.getUsername(), user.getPassword(), user.getEmail(), user.getIdentity()};
        return executeUpd(sql, parameters);
    }

    //delUser
    public boolean delUser(int id) {
        String sql = "delete from user where user.id =" + id;
        return executeUpd(sql, null);
    }

    //updUser
    public boolean updUser(User user) {
        String sql = "update user set username = ? , password = ?, email = ?, identity = ? where id = ?";
        Object[] parameters = {user.getUsername(), user.getPassword(), user.getEmail(), user.getIdentity(), user.getId()};
        return executeUpd(sql, parameters);
    }

    //getAllUsers
    public User getUserById(int id) {
        User user = new User();
        User userRs = new User();
        String sql = "select * from user where user.id =" + id;
        String[] parameters = null;
        ResultSet rs = SQLHelper.executeQuery(sql, parameters);
        try {
            while (rs.next()) {
                userRs = setUserInfo(user, rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return userRs;
    }

    //getAllUsers
    public ArrayList<User> getAllUsers() {
        ArrayList<User> allUsers = new ArrayList<>();
        String sql = "select * from user";
        ResultSet rs = SQLHelper.executeQuery(sql, null);
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

    private boolean executeUpd(String sql, Object[] parameters){
        try{
            SQLHelper.executeUpdate(sql, parameters);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
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

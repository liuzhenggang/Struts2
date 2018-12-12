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
        return executeQuery(sql, parameters);
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

    private boolean executeUpd(String sql, String[] parameters){
        try{
            SQLHelper.executeUpdate(sql, parameters);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    private boolean executeQuery(String sql, String[] parameters){
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

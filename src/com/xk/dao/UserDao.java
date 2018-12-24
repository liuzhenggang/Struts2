package com.xk.dao;

import com.xk.model.User;
import com.xk.util.SQLHelper;
import org.apache.commons.lang3.StringUtils;

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

    //getUserById
    public User getUserById(int id) {
        User userRs = new User();

        String sql = "select * from user where user.id =" + id;
        ResultSet rs = SQLHelper.executeQuery(sql, null);
        try {
            while (rs.next()) {
                userRs = setUserInfo(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return userRs;
    }

    //searchUsers
    public ArrayList<User> searchUsers(User user, Integer pageNum) {
        ArrayList<User> users = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from user where 1 = 1");

        if (StringUtils.isNotEmpty(user.getUsername())) {
            sql.append(" and username like " + "'%"+ user.getUsername() + "%'");
        }
        if (StringUtils.isNotEmpty(user.getPassword())) {
            sql.append(" and password like " + "'%"+ user.getPassword() + "%'");
        }

        if (StringUtils.isNotEmpty(user.getEmail())) {
            sql.append(" and email like " + "'%"+ user.getEmail() + "%'");
        }
        if (StringUtils.isNotEmpty(user.getIdentity())) {
            String [] identities =  user.getIdentity().split(", ");
            sql.append(" and identity in (");
            for (String id : identities) {
                sql.append("'" + id + "',");
            }
            sql.append("'" + identities[0] + "')");
        }

        sql.append(" limit " + (pageNum - 1) * 10 + ",10");
        ResultSet rs = SQLHelper.executeQuery(sql.toString(), null);
        try {
            while (rs.next()) {
                users.add(setUserInfo(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return users;
    }

    public Integer getMaxPage(int pageSize){
        int maxPage = 0;

        String sql = "select count(*) from user";
        ResultSet rs = SQLHelper.executeQuery(sql, null);
        try {
            while (rs.next()) {
                int count = Integer.parseInt(rs.getString(1));
                maxPage = count / pageSize + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLHelper.close(rs, SQLHelper.getPs(), SQLHelper.getCt());
        }
        return maxPage;
    }

    private boolean executeUpd(String sql, Object[] parameters) {
        try {
            SQLHelper.executeUpdate(sql, parameters);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private User setUserInfo(ResultSet rs) {
        User user = new User();
        try {
            user.setId(rs.getString(1));
            user.setUsername(rs.getString(2));
            user.setPassword(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setIdentity(rs.getString(5));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}

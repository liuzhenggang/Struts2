package com.xk.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xk.model.User;
import com.xk.service.UserService;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Map;

public class GetLoginUserAction implements Action {
    private User user = new User();
    private String username;
    private String password;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String execute() {
        ActionContext ac = ActionContext.getContext();

        if (username != null && password != null) {
            user.setUsername(username);
            user.setPassword(password);

            UserService userService = new UserService();
            if (userService.checkUser(user)) {
                ArrayList<User> users = userService.getAllUsers();
                ac.put("users", users);
                ac.put("currentUser", user.getUsername());
                return "success";
            } else {
                return "error";
            }
        } else {
            return "error";
        }
    }
}

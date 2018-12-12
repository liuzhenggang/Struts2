package com.xk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xk.model.User;
import com.xk.service.UserService;
import org.omg.PortableInterceptor.Interceptor;

import java.util.ArrayList;

public class UserAction  extends ActionSupport {
    private static final long serialVersionUID = 8L;

    private User user = new User();
    private int id = -1;
    private String username;
    private String password;
    private String email;
    private String identity;

    private UserService userService;
    @Override
    public String execute() {
        ActionContext ac = ActionContext.getContext();
        userService = new UserService();

        if (username != null && password != null) {
            user.setUsername(username);
            user.setPassword(password);

            if (userService.checkUser(user)) {
                ArrayList<User> users = userService.getAllUsers();
                ac.put("users", users);
                ac.put("currentUser", user.getUsername());
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }
    }

    public String add(){
        userService = new UserService();
        if(userService.addUser(user)){
            return SUCCESS;
        }
        return ERROR;
    }

    public String delete(){
        userService = new UserService();
        if(id != -1 && userService.delUser(id)){
            return SUCCESS;
        }
        return ERROR;
    }

    public String update(){
        userService = new UserService();
        if(id != -1 && userService.updUser(id)){
            return SUCCESS;
        }
        return ERROR;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

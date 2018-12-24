package com.xk.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.xk.model.User;
import com.xk.service.UserService;
import org.omg.PortableInterceptor.Interceptor;

import java.util.ArrayList;

public class UserAction  extends ActionSupport {
    private static final long serialVersionUID = 18L;

    private User user = new User();
    private Integer id = -1;
    private String username;
    private String password;
    private String email;
    private String identity;

    private Integer pageNum = 1;
    private Integer maxPage = -1;
    private static Integer pageSize = 10;

    private UserService userService;
    @Override
    public String execute() {
        ActionContext ac = ActionContext.getContext();
        userService = new UserService();

        if (username != null && password != null) {
            user.setUsername(username);
            user.setPassword(password);
            if (userService.checkUser(user)) {
                maxPage = userService.getMaxPage(pageSize);
                ac.put("maxPage", maxPage);
                ArrayList<User> users = userService.searchUsers(new User(), pageNum);
                ac.getSession().put("currentUser", user.getUsername());
                ac.put("users", users);
                return SUCCESS;
            } else {
                return ERROR;
            }
        } else {
            return ERROR;
        }
    }

    public String add(){
        ActionContext ac = ActionContext.getContext();
        userService = new UserService();
        if(userService.addUser(user)){
            maxPage = userService.getMaxPage(pageSize);
            ac.put("maxPage", maxPage);
            ArrayList<User> users = userService.searchUsers(new User(), pageNum);
            ac.put("users", users);

            return SUCCESS;
        }
        return ERROR;
    }

    public String search(){
        ActionContext ac = ActionContext.getContext();
        userService = new UserService();
        maxPage = userService.getMaxPage(pageSize);
        ac.put("maxPage", maxPage);
        ArrayList<User> users  = userService.searchUsers(user, pageNum);
        ac.put("users", users);
        return SUCCESS;
    }

    public String delete(){
        userService = new UserService();
        if(id != -1 && userService.delUser(id)){
            ActionContext ac = ActionContext.getContext();
            maxPage = userService.getMaxPage(pageSize);
            ArrayList<User> users = userService.searchUsers(new User(), pageNum);
            ac.put("maxPage", maxPage);
            ac.put("users", users);
            return SUCCESS;
        }
        return ERROR;
    }

    public String edit(){
        userService = new UserService();
        if(id != -1){
            user = userService.getUserById(id);
            return SUCCESS;
        }
        return ERROR;
    }

    public String upd(){
        ActionContext ac = ActionContext.getContext();
        userService = new UserService();
        if(userService.updUser(user)){
            maxPage = userService.getMaxPage(pageSize);
            ArrayList<User> users = userService.searchUsers(new User(), pageNum);
            ac.put("users", users);
            ac.put("maxPage", maxPage);
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

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(Integer maxPage) {
        this.maxPage = maxPage;
    }
}

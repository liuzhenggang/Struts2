package com.xk.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.xk.model.User;

public class GetUserAction implements Action {
    private User user = new User();

    public static void main(String[] args) {
        System.out.print("hello");
    }
    
    @Override
    public String execute() {
        user.setUsername("weixinya");
        user.setEmail("weixinya@live.cn");
        User user2 = new User();
        user2.setUsername("wxy");
        user2.setEmail("wxy@live.cn");
        ActionContext ac = ActionContext.getContext();
        ac.put("user", user);
        ac.put("user2", user2);
        return SUCCESS;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

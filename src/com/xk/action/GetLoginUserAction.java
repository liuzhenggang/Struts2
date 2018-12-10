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

    @Override
    public String execute() {
        ActionContext ac = ActionContext.getContext();
        String[] username = (String[]) ac.getParameters().get("username");
        String[] password = (String[]) ac.getParameters().get("password");

        if( username != null &&  password != null){
            user.setUsername(username[0]);
            user.setPassword(password[0]);

            //创建userService类，业务逻辑类
            UserService userService = new UserService();
            if(userService.checkUser(user)){
//                user = userService.getLoginUser(user);
//                ac.put("user", user);
                ArrayList<User> users = userService.getAllUsers();
                ac.put("users", users);
                ac.put("currentUser", user.getUsername());
                return "success";
            }else{
                return "error";
            }
        }
        else{
            return "error";
        }
    }
}

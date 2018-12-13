package com.xk.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class PermissionInterceptor implements Interceptor {
    public String intercept(ActionInvocation invocation) throws Exception{
        Object users = ActionContext.getContext().get("users");
        if (users != null){
            invocation.invoke();
            return "success";
        }else{
            ActionContext.getContext().put("message","没有权限");
            return "message";
        }
    }
    public void destroy(){

    }
    public void init() {}

}

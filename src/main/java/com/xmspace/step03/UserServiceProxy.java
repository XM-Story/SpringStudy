package com.xmspace.step03;

/**
 * @description:
 * @author: 小明长高高
 * @date: 2023/5/3 16:24
 **/
public class UserServiceProxy implements UserService{
    UserService userService = new UserServiceImpl();
    @Override
    public void login() {
        System.out.println("UserServiceProxy.login");
        userService.login();
    }
}

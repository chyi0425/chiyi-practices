package com.chiyi.proxy.cglib;

/**
 * @author chiyi
 * @date 2019/2/20.
 */
public class UserDao implements IUser {
    @Override
    public void save() {
        System.out.println("DB:保存用户");
    }
}

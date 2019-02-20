package com.chiyi.proxy.cglib;

/**
 * @author chiyi
 * @date 2019/2/20.
 */
public class App {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDao factory = (UserDao) new ProxyFactory(userDao).getProxyInstance();
        factory.save();
    }
}

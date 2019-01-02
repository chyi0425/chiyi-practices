package com.chiyi.dubbo;

/**
 * @author chiyi
 * @date 2019/1/2.
 */
public class Emp {
    private int account;
    private String name;

    public Emp() {
        this.account = 1;
        this.name = "test";
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //普通方法
    public void commonMethod() {
        System.out.println("haha");
    }
}

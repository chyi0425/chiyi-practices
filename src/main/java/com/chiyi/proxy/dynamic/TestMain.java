package com.chiyi.proxy.dynamic;

/**
 * @author chiyi
 * @date 2019/2/20.
 */
public class TestMain {
    public static void main(String[] args) {
        XiaoMingProxy xiaoMingProxy = new XiaoMingProxy();
        Person proxy = xiaoMingProxy.getProxy();

        proxy.sing("我爱你");
    }
}

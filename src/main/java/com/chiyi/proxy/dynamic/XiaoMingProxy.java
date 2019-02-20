package com.chiyi.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author chiyi
 * @date 2019/2/20.
 */
public class XiaoMingProxy {
    XiaoMing xiaoMing = new XiaoMing();

    public Person getProxy() {
        return (Person) Proxy.newProxyInstance(XiaoMingProxy.class.getClassLoader(), xiaoMing.getClass().getInterfaces(), new InvocationHandler() {

            /**
             *
             * @param proxy   把代理对象自己传递进来
             * @param method  把代理对象当前调用的方法传递进来
             * @param args    把方法参数传递进来
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if (method.getName().equals("sing")) {
                    System.out.println("给钱");
                    method.invoke(xiaoMing, args);
                }
                return null;
            }
        });
    }
}

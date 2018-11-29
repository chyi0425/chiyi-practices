package com.chiyi.spi.sample;

import com.chiyi.spi.DemoService;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author chiyi
 * @date 2018/11/29.
 */
public class SpiInvoke {
    public static void main(String[] args) {
        ServiceLoader<DemoService> serviceLoader = ServiceLoader.load(DemoService.class);
        Iterator<DemoService> it = serviceLoader.iterator();
        while (it.hasNext()) {
            DemoService demoService = it.next();
            System.out.println("class:" + demoService.getClass().getName() + "***" + demoService.sayHi("World"));
        }
    }
}

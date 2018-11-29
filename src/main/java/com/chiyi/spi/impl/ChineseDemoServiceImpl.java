package com.chiyi.spi.impl;

import com.chiyi.spi.DemoService;

/**
 * @author chiyi
 * @date 2018/11/29.
 */
public class ChineseDemoServiceImpl implements DemoService {
    @Override
    public String sayHi(String msg) {
        return "你好, " + msg;
    }
}

package com.chiyi.dubbo;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author chiyi
 * @date 2019/3/25.
 */
public class TcpServerHandler extends ChannelHandlerAdapter {
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String body = (String) msg;
        System.out.println("request content:\n" + body);
        // response
        resp(ctx,body);
    }

    private void resp(ChannelHandlerContext ctx, String body) {
        // todo  do something
    }
}

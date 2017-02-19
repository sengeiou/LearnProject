package com.cocoa.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * Created by sj on 17/2/17.
 */
public class TimeClientHandler extends ChannelInboundHandlerAdapter {

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//        ctx.writeAndFlush("Hello");
//    }
//
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
//        System.out.println(msg);
//    }
//
//    @Override
//    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);
//        ctx.flush();
//    }
//
//    @Override
//    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//        super.exceptionCaught(ctx, cause);
//        System.out.println(cause);
//        ctx.close();
//    }


    private final ByteBuf firstMessage;

    public TimeClientHandler() {
        firstMessage = Unpooled.buffer(656);
        for (int i = 0; i < firstMessage.capacity(); i++) {
            firstMessage.writeByte((byte) i);
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(firstMessage);
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws UnsupportedEncodingException {
        ByteBuf  byteBuf = (ByteBuf) msg;

        byte[] req = new byte[byteBuf.readableBytes()];
        byteBuf.readBytes(req);
        String result  = new String(req, "UTF-8");

        System.out.println(result);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }
}

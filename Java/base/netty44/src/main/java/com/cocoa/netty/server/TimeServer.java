package com.cocoa.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * Created by sj on 17/2/17.
 */
public class TimeServer {

    public static void main(String[] args) throws  Exception{
        int port  =  9999;
        new TimeServer().bind(port);
    }




    public void bind(int port )throws Exception{

        EventLoopGroup boosGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try{

            System.out.println("server start");
            ServerBootstrap b  = new ServerBootstrap();
            b.group(boosGroup,workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    // (5)
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childOption(ChannelOption.SO_KEEPALIVE, true) // (6)
                    .childHandler(new ChildChannelHandler());

            ChannelFuture  f = b.bind(port).sync();
            f.channel().closeFuture().sync();



        }catch (Exception e){
            System.out.println(e.toString());

        }finally {
            boosGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();

        }





    }


    private class ChildChannelHandler extends ChannelInitializer<SocketChannel>{

        protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new TimeServerHandler());
        }
    }



}

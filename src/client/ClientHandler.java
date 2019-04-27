package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import utils.Request;


/**
 * Handles a client-side channel.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {
	
	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg){
    	System.out.println("Client received msg!");
//    	Request m = (Request) msg;
//        System.out.println(m.getSuperR().getRequest());
    }
    
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
    	System.out.println("Client Channel active!");
    }
    
    @Override
    public void channelReadComplete(final ChannelHandlerContext ctx) {
    	
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    
    public static void sentToServer(Object obj) {
    	
    }
    
}

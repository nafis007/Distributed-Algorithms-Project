package client;

import org.json.simple.JSONObject;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import settings.Settings;


/**
 * Handles a client-side channel.
 */
public class ClientHandler extends SimpleChannelInboundHandler<String> {
	
    @Override
    public void channelRead0(ChannelHandlerContext ctx, String msg){
        System.err.println(msg);
    	JSONObject content = Settings.stringToJson(msg);
        if (content!=null) {
			
		}
    }
    
    @Override
    public void channelActive(final ChannelHandlerContext ctx) {
    	
    }
    
    @Override
    public void channelReadComplete(final ChannelHandlerContext ctx) {
    	
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
    
}

package client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import settings.Settings;

public class Communication {
	static final String HOST = System.getProperty("host", Settings.SERVER_ADDRESS);
    static final int PORT = Integer.parseInt(System.getProperty("port", Settings.OUT_PORT));
	static EventLoopGroup group = new NioEventLoopGroup();
	public Communication() {
        try {
            Bootstrap b = new Bootstrap();
            b.group(group)
             .channel(NioSocketChannel.class)
             .handler(new ClientInitializer());
            // Start the connection attempt.
            Channel ch = b.connect(HOST, PORT).sync().channel();
        } catch (Exception e) {
        	
        }finally {
            // The connection is closed automatically on shutdown.
//            group.shutdownGracefully();
        }
	}
}

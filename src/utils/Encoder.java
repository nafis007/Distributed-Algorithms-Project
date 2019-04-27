package utils;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class Encoder extends MessageToByteEncoder<Object> {
	@Override
	protected void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
		byte[] bytes = Settings.encodes(in);
		out.writeBytes(bytes);
	}
}
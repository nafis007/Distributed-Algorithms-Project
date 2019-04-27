package utils;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Decoder extends ByteToMessageDecoder {
	private static final int LENGTH = 4;
	@Override
	protected void decode(ChannelHandlerContext arg0, ByteBuf in, List<Object> out) throws Exception {
		int size = in.readableBytes();
		if (size > Decoder.LENGTH) {
			byte[] bytes = Settings.getByteFromBuf(in);
			Object info = Settings.decode(bytes);
			out.add(info);
		}
 
	}
}
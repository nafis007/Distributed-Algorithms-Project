package utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


public class Settings {
	public static final String OUT_PORT = "8888";
	public static final String CERT_PATH = "certificates/cert.pem";
	public static final String PRIVATE_KEY_PATH = "certificates/key.pem";
	
	public static final String SERVER = "SERV";
	
	/** Return JSON object, or null if transformation was failed.
	 * @param msg
	 * @return
	 */
	public static JSONObject stringToJson(String msg) {
		JSONObject content;
		JSONParser parser = new JSONParser();
		try {
			content = (JSONObject) parser.parse(msg);
			return content;
		} catch (ParseException e) {
			
		} catch (ClassCastException exc) {
			
		}
		return null;
    }
	
	public static byte[] encodes(Object obj) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		byte[] bytes = out.toByteArray();
		return bytes;
	}
 
	public static Object decode(byte[] bytes) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(bytes);
		ObjectInputStream inn = new ObjectInputStream(in);
		Object obj = inn.readObject();
		return obj;
	}
 
	/**
	 * byte to buf
	 * 
	 * @param bytes
	 * @return
	 */
	public ByteBuf getBufFromByte(byte[] bytes) {
		ByteBuf buf = Unpooled.copiedBuffer(bytes);
		return buf;
	}
 
	/**
	 * buf to byte
	 * 
	 * @param buf
	 * @return
	 */
	public static byte[] getByteFromBuf(ByteBuf buf) {
		int size = buf.readableBytes();
		byte[] bytes = new byte[size];
		buf.readBytes(bytes);
		return bytes;
	}

}

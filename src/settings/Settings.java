package settings;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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

}

package utils;

import java.io.Serializable;
import java.util.Date;

public class Request implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7308590349414753789L;
	private String request;
    private Date requestTime;
    private Request superR;
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}
	public Request getSuperR() {
		return superR;
	}
	public void setSuperR(Request superR) {
		this.superR = superR;
	}
    
}

package twitter;

import java.io.Serializable;

public class Usuario implements Serializable{

	
	private static final long serialVersionUID = 8666701496457213079L;
	
	private String id;
	private String token;
	private String secretToken;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getSecretToken() {
		return secretToken;
	}
	public void setSecretToken(String secretToken) {
		this.secretToken = secretToken;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}

package twitter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.apache.commons.codec.binary.Base64;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Cliente {

	private static String encodeKeys(String consumerKey, String consumerSecret) {
		try {
			String encodedKey = URLEncoder.encode(consumerKey, "UTF-8");
			String encodedSecret = URLEncoder.encode(consumerSecret, "UTF-8");

			String fullKey = encodedKey + ":" + encodedSecret;
			byte[] encodedBytes = Base64.encodeBase64(fullKey.getBytes());
			return new String(encodedBytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// Constructs the request for requesting a bearer token and returns that token as a string
	private static String requestBearerToken(String endPointUrl) throws IOException {
		HttpsURLConnection connection = null;
		String encodedCredentials = encodeKeys("kEgC1K5vx2mvRYxePYCUA","B1TQEaekHjW9XRBDSC3cTBKXx5EMaWiwffS4NrGiqfQ");
			
		try {
			URL url = new URL(endPointUrl); 
			connection = (HttpsURLConnection) url.openConnection();           
			connection.setDoOutput(true);
			connection.setDoInput(true); 
			connection.setRequestMethod("POST"); 
			connection.setRequestProperty("Host", "api.twitter.com");
			connection.setRequestProperty("User-Agent", "TvDigitalApp");
			connection.setRequestProperty("Authorization", "Basic " + encodedCredentials);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); 
			connection.setRequestProperty("Content-Length", "29");
			connection.setUseCaches(false);
				
			writeRequest(connection, "grant_type=client_credentials");
			String respuesta=readResponse(connection);
			System.out.println(respuesta);
			// Parse the JSON response into a JSON mapped object to fetch fields from.
			JSONObject obj = (JSONObject)JSONValue.parse(respuesta);
				
			if (obj != null) {
				String tokenType = (String)obj.get("token_type");
				String token = (String)obj.get("access_token");
			
				return ((tokenType.equals("bearer")) && (token != null)) ? token : "";
			}else{
				System.out.println("json Bearer vacio");
			}
			return new String();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Invalid endpoint URL specified.", e);
		}
		finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}


	// Fetches the first tweet from a given user's timeline
	private static String fetchTimelineTweet(String endPointUrl) throws IOException {
		HttpsURLConnection connection = null;
					
		try {
			URL url = new URL(endPointUrl); 
			connection = (HttpsURLConnection) url.openConnection();           
			connection.setDoOutput(true);
			connection.setDoInput(true); 
			connection.setRequestMethod("GET"); 
			connection.setRequestProperty("Host", "api.twitter.com");
			connection.setRequestProperty("User-Agent", "Your Program Name");
			String request=requestBearerToken("https://api.twitter.com/oauth2/token");
			System.out.println(request);
			connection.setRequestProperty("Authorization", "Bearer " + request );
			connection.setUseCaches(false);

			String respuesta=readResponse(connection);
			//System.out.println(respuesta);	
			// Parse the JSON response into a JSON mapped object to fetch fields from.
			JSONArray obj = (JSONArray)JSONValue.parse(respuesta);
				
			if (obj != null) {
				String tweet="";
				for(int i=0; i<2;i++){
					tweet = tweet+((JSONObject)obj.get(i)).get("text").toString()+"\n";
				}
				

				return (tweet != null) ? tweet : "";
			}else{
				System.out.println("json vacio");
			}
			return new String();
		}
		catch (MalformedURLException e) {
			throw new IOException("Invalid endpoint URL specified.", e);
		}
		finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}


	
	// Writes a request to a connection
	private static boolean writeRequest(HttpsURLConnection connection, String textBody) {
		try {
			BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
			wr.write(textBody);
			wr.flush();
			wr.close();
				
			return true;
		}
		catch (IOException e) { return false; }
	}
		
		
	// Reads a response for a given connection and returns it as a string.
	private static String readResponse(HttpsURLConnection connection) {
		try {
			StringBuilder str = new StringBuilder();
				
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String line = "";
			while((line = br.readLine()) != null) {
				str.append(line + System.getProperty("line.separator"));
			}
			return str.toString();
		}
		catch (IOException e) { return new String(); }
	}

	public static void main(String[] args) throws IOException {
		System.out.println(Cliente.fetchTimelineTweet("https://api.twitter.com/1.1/statuses/user_timeline.json?screen_name=tvdigital1&count=3"));
	
		
	}

}

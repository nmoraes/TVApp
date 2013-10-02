package twitter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Cliente {

	public static void main(String[] args) throws TwitterException, IOException {

		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("kEgC1K5vx2mvRYxePYCUA")
				.setOAuthConsumerSecret(
						"B1TQEaekHjW9XRBDSC3cTBKXx5EMaWiwffS4NrGiqfQ")
				.setUser("TVDigital1").setPassword("ihome01");
		TwitterFactory tf=new TwitterFactory(cb.build());
		Twitter twitter= tf.getInstance();
		
		RequestToken token=twitter.getOAuthRequestToken();
		System.out.println(token.getAuthorizationURL());
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String pin=bf.readLine();
		AccessToken access;
		if (pin.length() > 0) {
			access = twitter.getOAuthAccessToken(token, pin);
        } else {
        	access = twitter.getOAuthAccessToken(token);
        }
		//AccessToken access=twitter.getOAuthAccessToken(token, pin);
		System.out.println(access.getToken());
		System.out.println("publicando");
		String mensaje="probando app para tv digital 5";
		Status status=twitter.updateStatus(mensaje);
		System.out.println("publicado");
		System.out.println(status.getText());
		

	}
}

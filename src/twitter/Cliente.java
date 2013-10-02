package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import persistencia.Persistir;

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
						"B1TQEaekHjW9XRBDSC3cTBKXx5EMaWiwffS4NrGiqfQ");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		Persistir persistir = new Persistir();
		Usuario usuario = persistir.leerUsuarioTwitter();
		AccessToken access;
		if (usuario == null) {
			RequestToken token = twitter.getOAuthRequestToken();
			System.out.println(token.getAuthorizationURL());
			BufferedReader bf = new BufferedReader(new InputStreamReader(
					System.in));

			String pin = bf.readLine();
			if (pin.length() > 0) {
				access = twitter.getOAuthAccessToken(token, pin);
			} else {
				access = twitter.getOAuthAccessToken(token);
			}
			Usuario usuario2=new Usuario();
			usuario2.setId("");
			usuario2.setToken(access.getToken());
			usuario2.setSecretToken(access.getTokenSecret());
			persistir.persistirUsuarioTwitter(usuario2);
			System.out.println("usuario nuevo");
		}else{
			access=new AccessToken(usuario.getToken(), usuario.getSecretToken());
			twitter.setOAuthAccessToken(access);
			System.out.println("existe usuario");
		}
		System.out.println(access.getToken());
		System.out.println("publicando");
		String mensaje = "probando app para tv digital";
		Status status = twitter.updateStatus(mensaje);
		System.out.println("publicado");
		System.out.println(status.getText());

	}
}

package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import persistencia.Persistir;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class Cliente {

	private ConfigurationBuilder cb;
	private Twitter twitter;
	private Usuario usuario;
	private AccessToken access;
	private RequestToken token;
	
	public Cliente() {
		cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
				.setOAuthConsumerKey("kEgC1K5vx2mvRYxePYCUA")
				.setOAuthConsumerSecret(
						"B1TQEaekHjW9XRBDSC3cTBKXx5EMaWiwffS4NrGiqfQ");
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

	public Usuario getUsuario() {
		Persistir persistir = new Persistir();
		return persistir.leerUsuarioTwitter();
	}

	private void guardarUsuario(Usuario usuario) {
		Persistir persistir = new Persistir();
		persistir.persistirUsuarioTwitter(usuario);
	}

	public void crearUsuario(String id) {
		usuario = new Usuario();
		usuario.setId(id);
		usuario.setToken(access.getToken());
		usuario.setSecretToken(access.getTokenSecret());
		guardarUsuario(usuario);
	}

	public void escribirTweet(String mensaje) {
		try {
			usuario = getUsuario();
			if (usuario != null) {
				access = new AccessToken(usuario.getToken(),
						usuario.getSecretToken());
				twitter.setOAuthAccessToken(access);
				twitter.updateStatus(mensaje);
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
	}

	public String getAuthorizationURL() {
		try {
			token=twitter.getOAuthRequestToken();
			return token.getAuthorizationURL();
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void setAccessToken(AccessToken token) {
		access = token;
	}

	public void setPin(String pin) {
		try {
			setAccessToken(twitter.getOAuthAccessToken(token, pin));
		} catch (TwitterException e) {
			System.out.println("error en el pin");
			e.printStackTrace();
		}
	}

	public boolean existeUsuario() {
		return new Persistir().leerUsuarioTwitter() != null;
	}
	
	public List getHomeTimeLine(){
		try {
			User user=twitter.verifyCredentials();
			List statuses=twitter.getHomeTimeline();
			List tl=new ArrayList();
			for (int i=0; i<statuses.size();i++){
				Status status=(Status)statuses.get(i);
				tl.add(new Tweet(status.getUser().getScreenName(), status.getText()));
			}
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws TwitterException, IOException {

		Cliente c = new Cliente();
		if (c.existeUsuario()) {
			c.escribirTweet("existe usuario");
		} else {
			System.out.println(c.getAuthorizationURL());
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String pin=bf.readLine();
			c.setPin(pin);
			c.crearUsuario("usuario");
			c.escribirTweet("usuario nuevo");
		}
		
		List lista=c.getHomeTimeLine();
		for(int i=0; i<lista.size();i++){
			Tweet t=(Tweet)lista.get(i);
			System.out.println(t.getUsuario()+" "+t.getMensaje());
		}
		

	}
}

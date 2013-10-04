package twitter;

public class Tweet {

	private String usuario;
	private String mensaje;
	
	
	public Tweet(String usuario, String mensaje) {
		this.usuario = usuario;
		this.mensaje = mensaje;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}

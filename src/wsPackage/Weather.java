package wsPackage;

import java.awt.Image;

/**
 * @author nico moraes
 * @description bean que representa el estado del tiempo.
 * */
public class Weather {

	private String title;
	private String fcttext; 
	private String fcttext_metric;
	private Image urlImage;
	
	
	
	public Weather(String title, String fcttext, String fcttext_metric, Image urlImage) {

		this.title = title;
		this.fcttext = fcttext;
		this.fcttext_metric = fcttext_metric;
		this.urlImage = urlImage;
		

	}

	public Image getUrl() {
		return urlImage;
	}



	public void setUrl(Image url) {
		this.urlImage = url;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getFcttext() {
		return fcttext;
	}



	public void setFcttext(String fcttext) {
		this.fcttext = fcttext;
	}



	public String getFcttext_metric() {
		return fcttext_metric;
	}



	public void setFcttext_metric(String fcttext_metric) {
		this.fcttext_metric = fcttext_metric;
	}


	
	
	
}

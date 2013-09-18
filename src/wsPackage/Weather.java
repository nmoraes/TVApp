package wsPackage;

public class Weather {

	
	
	
	private String title;
	private String fcttext; 
	private String fcttext_metric;
	private String icon_url; 
	
	
	
	public Weather(String title, String fcttext, String fcttext_metric,String icon_url) {

		this.title = title;
		this.fcttext = fcttext;
		this.fcttext_metric = fcttext_metric;
		this.icon_url = icon_url;

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



	public String getIcon_url() {
		return icon_url;
	}



	public void setIcon_url(String icon_url) {
		this.icon_url = icon_url;
	}
	
	
	
	
	
}

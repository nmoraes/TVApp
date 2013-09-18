package wsPackage;


import java.awt.Image;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import wsPackage.org.json.me.JSONArray;
import wsPackage.org.json.me.JSONException;
import wsPackage.org.json.me.JSONObject;






public class JSONUtility {


	public static Weather[] getWeather() {
	URL url = null;
	Weather [] weatherCollection=null;
	//http://www.wunderground.com/
		try {
			url = new URL("http://api.wunderground.com/api/2f2b92287d8a6fd0/geolookup/conditions/forecast/q/Uruguay/Montevideo.json");
			InputStream response = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(response));
			String result="";

			for (String line; (line = reader.readLine()) != null;) {
			    result =result+line;
			}
			
			
			JSONObject json;
			JSONArray  arrayWeather=null;
			try {
				json = new JSONObject(result);
			
				
				JSONObject nodo0 = (JSONObject) json.get("forecast");
				
				JSONObject nodo1 = (JSONObject) nodo0.get("txt_forecast");
				
				arrayWeather = nodo1.getJSONArray("forecastday");
				
				//System.out.println(arrayWeather);
				
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	
			weatherCollection = new Weather[arrayWeather.length()];

			for (int i = 0; i < arrayWeather.length(); i++) {
				//html = null;
				//pic = null;
				
				
				try {
					JSONObject array = (JSONObject) arrayWeather.get(i);
					String title = array.getString("title");
					String fcttext = array.getString("fcttext");
					String fcttext_metric = array.getString("fcttext_metric");
					String icon_url = array.getString("icon_url");
					
					//System.out.println(title);
					//System.out.println(fcttext);
					//System.out.println(fcttext_metric);
					
					 URL urlIcon = new URL(icon_url);
					 Image image = ImageIO.read(urlIcon);   
					
					Weather weather= new Weather(title,fcttext,fcttext_metric,image);
					weatherCollection[i]=weather;
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				/*
				 URL url = new URL("http://www.digitalphotoartistry.com/rose1.jpg");
				Image image = ImageIO.read(url);   
				 */


			}
			
			
			
			
			
			//System.out.println(result);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return weatherCollection;
	
	}
	
	
	
	
}

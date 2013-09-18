package wsPackage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import wsPackage.org.json.me.JSONArray;
import wsPackage.org.json.me.JSONException;
import wsPackage.org.json.me.JSONObject;






public class JSONUtility {


	public static void getWeather() {
	URL url = null;
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


	


			for (int i = 0; i < arrayWeather.length(); i++) {
				//html = null;
				//pic = null;
				
				
				
				System.out.println("");
				System.out.println("");
				System.out.println("");
				try {
					JSONObject array = (JSONObject) arrayWeather.get(i);
					String title = array.getString("title");
					String fcttext = array.getString("fcttext");
					String fcttext_metric = array.getString("fcttext_metric");
					
					System.out.println(title);
					System.out.println(fcttext);
					System.out.println(fcttext_metric);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				

//				if (subtitle.equals("null")) {
//					subtitle = "";
//				} else
//					subtitle = subtitle + ".<br>";
//
//				price = array.getString("price");
//				// price=calculadoraDePrecio(price);
//				thumbnail = array.getString("thumbnail");
//				currency = array.getString("currency_id");
//				pic = thumbnail.replace("_v_I_f", "_v_T_f");
//				stop_time = array.getString("stop_time");
//				condition = estado(array.getString("condition"));
//				id = array.getString("id");

			}
			
			
			
			
			
			//System.out.println(result);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}
	
	
	
	
}

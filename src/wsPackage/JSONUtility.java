package wsPackage;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

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
			try {
				json = new JSONObject(result);
				System.out.println(json);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			

		//	 JSONObject json = (JSONObject) JSONSerializer.toJSON(result);

			 
			 /* 
			// String id = json.getString( "id" );
			site = json.getString("site_id");
			query = json.getString("query");
*/
			// Obtengo el array de items
//			JSONObject p = (JSONObject) json.get("forecastday");
//			String total = p.getString("icon");
//			System.out.println("Totala: " + total);

		//	JSONArray results = json.getJSONArray("results");
/*

			for (int i = 0; i < results.size(); i++) {
				html=null;
				pic=null;
				JSONObject array = (JSONObject) results.get(i);
				titles = array.getString("title");
				subtitle = array.getString("subtitle");

				if(subtitle.equals("null")){
					subtitle= "";
				}else
					subtitle = subtitle + ".<br>";

				price = array.getString("price");
				//price=calculadoraDePrecio(price);
				thumbnail = array.getString("thumbnail");
				currency = array.getString("currency_id");
				pic = thumbnail.replace("_v_I_f", "_v_T_f");
				stop_time = array.getString("stop_time");
				condition = estado(array.getString("condition"));
				id = array.getString("id"); 
			  
			  
			 */
			
			
			
			
			
			System.out.println(result);
		
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	
	}
	
	
	
	
}

package developer.swarnim.weather;

import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.*;


public class temperature {

	public static void main(String[] args){
		System.out.println("According to open weather map .ORG, temperature at your location is");

		URL locationURL,url;
		HttpURLConnection connection1,connection2;
		String result = "",locationResult="";
		InputStream is;
		InputStreamReader isr;

		try{
			locationURL = new URL("http://freegeoip.net/json/");
			connection1 = (HttpURLConnection) locationURL.openConnection();
			is = connection1.getInputStream();
			isr = new InputStreamReader(is);
			int data = isr.read();
			while(data != -1){
				char dataInChar = (char) data;
				locationResult += dataInChar;	
                        	data = isr.read();
			}	
			JSONObject locationObj = new JSONObject(locationResult);
			double lat = locationObj.getDouble("latitude");
			double lon = locationObj.getDouble("longitude");

			url = new URL("http://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=94e51970c830de16d0dce5ed50ac33d6");
			connection2 = (HttpURLConnection) url.openConnection();
			is = connection2.getInputStream();
			isr = new InputStreamReader(is);
			int data2 = isr.read();
			while(data2 != -1){
				char dataInChar = (char) data2;
				result += dataInChar;	
                        	data2 = isr.read();
			}	
			double tempInDeg = new temperature().getTempInDegrees(result); 
			double tempInCelsius = tempInDeg - 273.15;	
			double finalTemp = (double) Math.round(tempInCelsius * 100d)/100d;
			System.out.println(String.valueOf(finalTemp) +" degree celsius");
		} catch (Exception e){
			e.printStackTrace();
		}
	
	}

	private double getTempInDegrees(String dataToWork){
		try{
			JSONObject json = new JSONObject(dataToWork);
			JSONObject main = json.getJSONObject("main");
			double temperature = main.getDouble("temp");
			return temperature;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}

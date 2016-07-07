package com.utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.Normalizer;

public class Posicion {
	private float latitud;
	private float longitud;
	private String direccion;
	private String ciudad;
	
	/*public Posicion(Direccion d){
		this.latitud = d.getLatitud();
		this.longitud = d.getLongitud();
		this.direccion = d.getCalle()+" "+d.getNumeroDePuerta();
		this.ciudad = d.getCiudad();
	}*/
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
	public void getLatLongByDirCiu(String direccion, String ciudad) throws Exception {
		try{
			direccion = Normalizer.normalize(direccion, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
			ciudad = Normalizer.normalize(direccion, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
						
			String url = "http://nominatim.openstreetmap.org/search/?q=\""+direccion+","+ciudad+"\"&format=xml";
			url = url.replace(" ", "%20");
			
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			// optional default is GET
			con.setRequestMethod("GET");
	
			//add request header
			//con.setRequestProperty("User-Agent", USER_AGENT);
	
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
						
			BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	
			//print result
			System.out.println(response.toString());
			
			int aux = response.indexOf("lat='") + 5;
			String lat = response.substring(aux,response.indexOf("'",aux));
			System.out.println(lat);
			
			aux = response.indexOf("lon='") + 5;
			String lon = response.substring(aux,response.indexOf("'",aux));
			System.out.println(lon);
			
			this.setDireccion(direccion);
			this.setCiudad(ciudad);
			this.setLatitud(new Float(lat));
			this.setLongitud(new Float(lon));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void getDirCiuByLatLong(float latitud, float longitud) throws Exception {
		try{
			String url = "http://nominatim.openstreetmap.org/reverse?format=xml&lat="+latitud+"&lon="+longitud+"&zoom=18&addressdetails=1";	
					
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	
			// optional default is GET
			con.setRequestMethod("GET");
	
			//add request header
			//con.setRequestProperty("User-Agent", USER_AGENT);
	
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);
			
			BufferedReader in = new BufferedReader(
	        new InputStreamReader(con.getInputStream(),StandardCharsets.UTF_8));
			String inputLine;
			StringBuffer response = new StringBuffer();
	
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
	
			//print result
			System.out.println(response.toString());
			
			int aux = response.indexOf("<house_number>") + 14;
			String dire = response.substring(aux,response.indexOf("</house_number>",aux));
			int indexComma = 0;
			indexComma = dire.indexOf(',');
			if (indexComma > 0){
				dire = dire.substring(0, indexComma);
			}
			
			//System.out.println(dire);
			
			aux = response.indexOf("<road>") + 6;
			dire = response.substring(aux,response.indexOf("</road>",aux))+" "+dire;
			
			aux = response.indexOf("<city>") + 6;
			String ciud = response.substring(aux,response.indexOf("</city>",aux));
	
			
			this.setDireccion(dire);
			this.setCiudad(ciud);
			this.setLatitud(latitud);
			this.setLongitud(longitud);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
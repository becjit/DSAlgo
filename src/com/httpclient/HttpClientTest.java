package com.httpclient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.http.client.HttpClient;


public class HttpClientTest {

    public static void main(String[] args) {

        try {
            URL url = new URL ("http://BLRAMAZU139603:4512/content/geometrixx-outdoors/en.html");
            
            byte[] encoding = Base64.encodeBase64 ("admin:admin".getBytes());
            
           

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty  ("Authorization", "Basic " + new String(encoding));
            System.out.println(connection.getRequestProperty("Authorization"));
            InputStream content = (InputStream)connection.getInputStream();
            
            BufferedReader in   = 
                new BufferedReader (new InputStreamReader (content));
            String line;
            for (String header : connection.getHeaderFields().keySet()) {
            	   if (header != null) {
            	     for (String value : connection.getHeaderFields().get(header)) {
            	        System.out.println(header + ":" + value);
            	      }
            	   }
            	}
            while ((line = in.readLine()) != null) {
                //System.out.println(line);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
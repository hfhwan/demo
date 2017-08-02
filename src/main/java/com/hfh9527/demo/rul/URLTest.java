package com.hfh9527.demo.rul;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;


public class URLTest {

	public static void main(String[] args) {
		
		try {
			URL url = new URL("http://dev.czcb.com");
			
			String proxyIp = "10.128.176.200";
			int proxyPort = 8080;
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyIp, proxyPort));
			
			URLConnection urlConnection = url.openConnection(proxy);
			
			urlConnection.connect();
			
			Map<String, List<String>> headers = urlConnection.getHeaderFields();
			for (Entry<String, List<String>> head : headers.entrySet()) {
				String key = head.getKey();
				for (String value : head.getValue()) {
					System.out.println(key + ":" + value);
				}
			}
			System.out.println("---------------------------------");
			System.out.println("getAllowUserInteraction:" + urlConnection.getAllowUserInteraction());
			System.out.println("getConnectTimeout:" + urlConnection.getConnectTimeout());
			System.out.println("getContent:" + urlConnection.getContent());
			System.out.println("getContentEncoding:" + urlConnection.getContentEncoding());
			System.out.println("getContentLength:" + urlConnection.getContentLength());
			System.out.println("getContentType:" + urlConnection.getContentType());
			System.out.println("getDate:" + urlConnection.getDate());
			System.out.println("getDefaultUseCaches:" + urlConnection.getDefaultUseCaches());
			System.out.println("getDoInput:" + urlConnection.getDoInput());
			System.out.println("getDoOutput:" + urlConnection.getDoOutput());
			System.out.println("getExpiration:" + urlConnection.getExpiration());
			System.out.println("getIfModifiedSince:" + urlConnection.getIfModifiedSince());
			System.out.println("getLastModified:" + urlConnection.getLastModified());
			System.out.println("getReadTimeout:" + urlConnection.getReadTimeout());
			System.out.println("getUseCaches:" + urlConnection.getUseCaches());
			
			Scanner scanner = new Scanner(urlConnection.getInputStream());
			while( scanner.hasNextLine()){
				System.out.println(scanner.nextLine());
			}
			scanner.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

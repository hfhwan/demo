package com.hfh9527.demo.httpcomponent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClientProtocolException, IOException
    {
    	
        System.out.println( "Hello World!" );
        List<NameValuePair> paras = new ArrayList<NameValuePair>();
        paras.add(new BasicNameValuePair("isusp", "0"));
        paras.add(new BasicNameValuePair("loginname", "0"));
        paras.add(new BasicNameValuePair("loginpwd", "0"));
        paras.add(new BasicNameValuePair("servicecode", "njdh"));
        UrlEncodedFormEntity from = new UrlEncodedFormEntity(paras);
        HttpPost post = new HttpPost("http://puser.zjzwfw.gov.cn/sso/usp.do?action=ssoValidate");
        post.setEntity(from);
        HttpClient client = HttpClientBuilder.create().build();
        client.execute(post,new ResponseHandler<String>() {

			public String handleResponse(HttpResponse resp) throws ClientProtocolException, IOException {
				String str = EntityUtils.toString(resp.getEntity(), "utf8");
				System.out.println(str);
				return null;
			}
		});
    }
}

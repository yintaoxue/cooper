package org.ruogu.cooper.components.httpclient.gps;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Hello world!
 *
 */
public class GPS {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		
		HttpClient client = new DefaultHttpClient();
		String s = "http://api.map.baidu.com/geocoder/v2/?address=北京市海淀区中关村南大街27号&output=json&ak=SS7v9muaoCYlIy6atT8mQlOn&callback=showLocation";
		HttpGet httpget = new HttpGet(s);
		HttpEntity entity = null;

		HttpResponse response = client.execute(httpget);

		String pageContent = EntityUtils.toString(response.getEntity());
		System.out.println(pageContent);
	}
}

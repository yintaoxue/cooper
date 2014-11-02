package org.ruogu.cooper.components.httpclient.gps;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

/**
 * Hello world!
 *
 */
public class GPS {
	public static void main(String[] args) throws ClientProtocolException, IOException {

		HttpClient client = new DefaultHttpClient();
		String s = "http://api.map.baidu.com/geocoder/v2/?address=北京市海淀区中关村南大街27号&output=json&ak=SS7v9muaoCYlIy6atT8mQlOn";
		HttpGet httpget = new HttpGet(s);
		HttpEntity entity = null;

		HttpResponse response = client.execute(httpget);

		String pageContent = EntityUtils.toString(response.getEntity());
		System.out.println(pageContent);
		
//		String pageContent = "{\"status\":0,\"result\":{\"location\":{\"lng\":116.32483745351,\"lat\":39.957576482511},\"precise\":1,\"confidence\":80,\"level\":\"\u9053\u8def\"}}";

		GpsResult loc = JSON.parseObject(pageContent, GpsResult.class);
		
		
		
		System.out.println(loc);
	}
}

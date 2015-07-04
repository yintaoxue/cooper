package org.ruogu.cooper.components.memcached;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
 * MemcachedClient
 *
 * @author xueyintao 2015年7月4日 下午9:19:15
 */
public class MemcachedUseCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		testSet();
//		testGet();
		testReplace();
		
		
	}
	
	public static void testSet() {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"),
				new int[] { 1 });

		// 设置连接池大小，即客户端个数
		builder.setConnectionPoolSize(1);

		// 宕机报警
		builder.setFailureMode(true);

		// 使用二进制文件
		builder.setCommandFactory(new BinaryCommandFactory());

		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = builder.build();
			try {
				// 设置/获取
				memcachedClient.set("mycount", 36000, "19800");
				System.out.println("set mycount=19800");

				// 替换
//				memcachedClient.replace("zlex", 36000, "replace");

				// 移除
//				memcachedClient.delete("zlex");
				
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MemcachedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (memcachedClient != null) {
				try {
					memcachedClient.shutdown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	public static void testGet() {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"),
				new int[] { 1 });

		// 设置连接池大小，即客户端个数
		builder.setConnectionPoolSize(1);

		// 宕机报警
		builder.setFailureMode(true);

		// 使用二进制文件
		builder.setCommandFactory(new BinaryCommandFactory());

		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = builder.build();
			try {
				// 设置/获取
//				memcachedClient.set("mycount", 36000, "19800");

				// 替换
//				memcachedClient.replace("mycount", 36000, "240");
//				System.out.println();

				// 移除
//				memcachedClient.delete("zlex");
				
				String s = memcachedClient.get("mycount", 36000);
				System.out.println("get mycount:" + s);
				
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MemcachedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (memcachedClient != null) {
				try {
					memcachedClient.shutdown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void testReplace() {
		MemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("localhost:11211"),
				new int[] { 1 });

		// 设置连接池大小，即客户端个数
		builder.setConnectionPoolSize(1);

		// 宕机报警
		builder.setFailureMode(true);

		// 使用二进制文件
		builder.setCommandFactory(new BinaryCommandFactory());

		MemcachedClient memcachedClient = null;
		try {
			memcachedClient = builder.build();
			try {
				// 设置/获取
//				memcachedClient.set("mycount", 36000, "19800");

				// 替换
				memcachedClient.replace("mycount", 36000, "240");

				// 移除
//				memcachedClient.delete("zlex");
				
			} catch (TimeoutException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (MemcachedException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (memcachedClient != null) {
				try {
					memcachedClient.shutdown();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

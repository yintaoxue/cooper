/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ruogu.cooper.util;

import java.security.MessageDigest;

public class MD5Util {
	public final static String MD5Capital(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public final static String MD5(String str) {
		if (str == null) {
			return null;
		}
		byte newByte1[] = str.getBytes();
		try {
			MessageDigest messagedigest = MessageDigest.getInstance("MD5");
			byte newByte2[] = messagedigest.digest(newByte1);
			String cryptograph = "";
			for (int i = 0; i < newByte2.length; i++) {
				String temp = Integer.toHexString(newByte2[i] & 0x000000ff);
				if (temp.length() < 2)
					temp = "0" + temp;
				cryptograph += temp;
			}
			return cryptograph;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static void main(String[] args) {
		System.out.println(MD5Util.MD5("20121221"));
		System.out.println(MD5Util.MD5("http://tv.people.com.cn/n/2013/0102/c61600-20071709.html"));
	}
}

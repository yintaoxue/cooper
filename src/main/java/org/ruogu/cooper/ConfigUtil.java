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
package org.ruogu.cooper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigUtil {
	private static final Logger LOG = LoggerFactory.getLogger(ConfigUtil.class);

	String dataDir = "";

	@SuppressWarnings("serial")
	public static class ConfigException extends Exception {
		public ConfigException(String msg) {
			super(msg);
		}

		public ConfigException(String msg, Exception e) {
			super(msg, e);
		}
	}

	/**
	 * Parse a configuration file
	 * 
	 * @param path
	 *            the patch of the configuration file
	 * @throws ConfigException
	 *             error processing configuration
	 */
	public void parse(String path) throws ConfigException {
		File configFile = new File(path);

		LOG.info("Reading configuration from: " + configFile);

		try {
			if (!configFile.exists()) {
				throw new IllegalArgumentException(configFile.toString() + " file is missing");
			}

			Properties cfg = new Properties();
			FileInputStream in = new FileInputStream(configFile);
			try {
				cfg.load(in);
			} finally {
				in.close();
			}

			parseProperties(cfg);
		} catch (IOException e) {
			throw new ConfigException("Error processing " + path, e);
		} catch (IllegalArgumentException e) {
			throw new ConfigException("Error processing " + path, e);
		}
	}

	/**
	 * Parse config from a Properties.
	 * 
	 * @param Properties
	 *            to parse from.
	 * @throws IOException
	 * @throws ConfigException
	 */
	public void parseProperties(Properties prop) {
		for (Entry<Object, Object> entry : prop.entrySet()) {
			String key = entry.getKey().toString().trim();
			String value = entry.getValue().toString().trim();
			if (key.equals("dataDir")) {
				dataDir = value;
			}
		}
	}

}

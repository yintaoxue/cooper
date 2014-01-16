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

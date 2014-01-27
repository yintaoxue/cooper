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
package org.ruogu.cooper.file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CleanFile {
	private static final Logger LOG = LoggerFactory.getLogger(CleanFile.class);

	/**
	 * clean dir files
	 * 
	 * @param dataDir	the dir that has the logs
	 * @throws IOException
	 */
	public static void clean(File dataDir) throws IOException {

		class MyFileFilter implements FileFilter {
			private final String prefix;

			MyFileFilter(String prefix) {
				this.prefix = prefix;
			}

			public boolean accept(File f) {
				if (!f.getName().startsWith(prefix))
					return false;
				return true;
			}
		}
		// add all non-excluded log files
		List<File> files = new ArrayList<File>(Arrays.asList(dataDir.listFiles(new MyFileFilter("log."))));
		// remove the old files
		for (File f : files) {
			LOG.info("Removing file: " + DateFormat.getDateTimeInstance().format(f.lastModified()) + "\t"
					+ f.getPath());
			if (!f.delete()) {
				System.err.println("Failed to remove " + f.getPath());
			}
		}

	}
}

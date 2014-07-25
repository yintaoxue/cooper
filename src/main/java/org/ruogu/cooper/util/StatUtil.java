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

import java.util.Date;


public class StatUtil {
	
	public static String interval(Date start, Date stop) {
		String log = "";
		long seconds = (stop.getTime() - start.getTime()) / 1000;
		if (seconds <= 60) {
			log = "" + seconds + " seconds";
		}
		else if (seconds <= 60 * 60) {
		    int min = (int)(seconds / 60);
		    int rem = (int)(seconds % 60);
           log = "" + min + " min, " + rem + " rem, " + seconds + " seconds";
		}
		else if (seconds <= 60 * 60 * 24) {
		    int rem;
            int hour = (int)(seconds / (60 * 60));
            rem = (int)(seconds % (60 * 60)); 
            int min = rem / 60;
            rem = rem % 60;
            log = "" + hour + " hour, " + min + " min, " + rem + " rem, " + seconds + " seconds";
            }
		else {
            int rem;
            int days = (int)(seconds / (60 * 60 * 24));
            rem = (int)(seconds % (60 * 60 * 24));
            int hour = rem / (60 * 60);
            rem = rem % (60 * 60); 
            int min = rem / 60;
            rem = rem % 60;
            log = "" + days + " days, " + hour + " hour, " + min + " min, " + rem + " rem, " + seconds + " seconds";
            }
		
		return log;
	}
	
}

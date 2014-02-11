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
package org.ruogu.cooper.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class State {
	protected static final Logger LOG = LoggerFactory.getLogger(State.class);

	// 状态变量
	private boolean isFullRunning = false;
	private boolean isDeltaRunning = false;
	private boolean isFullContinue = true;
	private boolean isDeltaContinue = true;

	// 全量和增量是否互斥
	private boolean mutex = false;

	public void setRunning(Mode mode) {
		if (canRun(mode)) {
			if (mode == Mode.FULL) {
				isFullRunning = true;
			} else if (mode == Mode.DELTA) {
				isDeltaRunning = true;
			}
		} else {
			LOG.error("can't run mode: " + mode.name());
		}
	}

	/**
	 * 判断是否可以执行全量或增量
	 * 
	 * @param mode
	 * @return
	 */
	public boolean canRun(Mode mode) {
		boolean rs = false;
		if (mode == Mode.FULL) {
			if (mutex) {
				if (isFullRunning == false && isDeltaRunning == false) {
					rs = true;
				}
			} else {
				if (isFullRunning == false) {
					rs = true;
				}
			}
		} else if (mode == Mode.DELTA) {
			if (mutex) {
				if (isFullRunning == false && isDeltaRunning == false) {
					rs = true;
				}
			} else {
				if (isDeltaRunning == false) {
					rs = true;
				}
			}
		}
		return rs;
	}

	/**
	 * 判断是否继续执行
	 * 
	 * @param mode
	 * @return
	 */
	public boolean canContinue(Mode mode) {
		if (mode == Mode.FULL && isFullContinue) {
			return true;
		} else if (mode == Mode.DELTA && isDeltaContinue) {
			return true;
		} else {
			return false;
		}
	}
}

package org.ruogu.cooper.components.httpclient.gps;

import java.util.concurrent.TimeUnit;

import org.apache.http.conn.HttpClientConnectionManager;

/**
 * IdleConnectionMonitorThread
 *
 * @author xueyintao 2014年11月2日 下午5:50:18
 */
public class IdleConnectionMonitorThread extends Thread {
	private final HttpClientConnectionManager connMgr;
	private volatile boolean shutdown;

	public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
		super();
		this.connMgr = connMgr;
	}

	@Override
	public void run() {
		try {
			while (!shutdown) {
				synchronized (this) {
					wait(GpsConf.idleMonitorWait);
					// Close expired connections
					connMgr.closeExpiredConnections();
					// Optionally, close connections
					// that have been idle longer than 30 sec
					connMgr.closeIdleConnections(GpsConf.idleMonitorIdleTime, TimeUnit.SECONDS);
				}
			}
		} catch (InterruptedException ex) {
			// terminate
		}
	}
	
	public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}

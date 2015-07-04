package org.ruogu.cooper.core.executor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TestExecutors
 *
 * @author xueyintao 2014年11月1日 下午8:43:05
 */
public class TestExecutors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int poolSize = 2;
		ExecutorService pool = Executors.newFixedThreadPool(poolSize);
		for (int i = 0; i < 50; i++) {
			Job job = new Job("job" + i);
			pool.execute(job);
		}
	}

}

class Job implements Runnable {
	
	private String name = "Job";
	
	public Job() {
	}
	
	public Job(String name) {
		this.name = name;
	}

	/* 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("job:" + name);
	}
	
}
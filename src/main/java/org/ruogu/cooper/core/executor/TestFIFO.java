package org.ruogu.cooper.core.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * TestFIFO
 *
 * @author xueyintao 2015年7月1日 上午1:16:45
 */
public class TestFIFO {

	public static LinkedBlockingQueue<Entity> queue = new LinkedBlockingQueue<Entity>(10);;


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService pool = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++) {
			OutJob outjob = new OutJob("outjob" + i);
			pool.execute(outjob);
		}
		for (int i = 0; i < 50; i++) {
			try {
				queue.put(new Entity("e" + i));
				System.out.println("queue put e" + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class InJob implements Runnable {

	private String name = "Job";

	public InJob() {
	}

	public InJob(String name) {
		this.name = name;
	}

	/*
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("job:" + name);
	}

}

class OutJob implements Runnable {

	private String name = "Job";

	public OutJob() {
	}

	public OutJob(String name) {
		this.name = name;
	}

	/*
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		while (true) {
			try {
				Entity e = TestFIFO.queue.take();
				System.out.println(name + " - " + e.getEname());
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Entity {
	private String ename;

	public Entity(String n) {
		this.ename = n;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Entity [ename=" + ename + "]";
	}

}

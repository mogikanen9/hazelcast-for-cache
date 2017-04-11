package com.mogikanensoftware.cache.executorservice.task;

import java.io.Serializable;

public class EchoTask implements Runnable, Serializable {

	private static final long serialVersionUID = 1L;

	private final String msg;

	public EchoTask(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();	
		}
		System.out.println("echo:" + msg);
	}
}

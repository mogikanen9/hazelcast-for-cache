package com.mogikanensoftware.cache.executorservice.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecuteCalculation {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService execService = Executors.newFixedThreadPool(3);
		Future<Long> sum = execService.submit(new MyCallableCalculation());
		System.out.println("We are doing other stuff here ...");
		Thread.sleep(5000);
		System.out.println("More...");
		System.out.println(String.format("Result is %d", sum.get()));
		execService.shutdown();
	}
}

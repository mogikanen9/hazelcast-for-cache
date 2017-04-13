package com.mogikanensoftware.cache.executorservice.future;

import java.util.concurrent.Callable;

public class MyCallableCalculation implements Callable<Long> {

	@Override
	public Long call() throws Exception {

		System.out.println("Starting heavy calculation ...");

		long sum = 0;

		for (int i = 0; i < 100; i++) {
			sum += i;
			Thread.sleep(100);
			if (i % 10 == 0) {
				System.out.println(String.format("Already reached %d",sum));
			}
		}
		System.out.println("Done with calc, returning result.");
		return sum;
	}

}

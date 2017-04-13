package com.mogikanensoftware.cache.executorservice.callable;

import java.io.Serializable;
import java.util.concurrent.Callable;

public class FibonacciCallable implements Callable<Long>, Serializable {

	private static final long serialVersionUID = 1L;

	private final int input;

	public FibonacciCallable(int input) {
		this.input = input;
	}

	@Override
	public Long call() {
		return calculate(input);
	}

	private long calculate(int n) {
		if (n <= 1)
			return n;
		else
			return calculate(n - 1) + calculate(n - 2);
	}
}

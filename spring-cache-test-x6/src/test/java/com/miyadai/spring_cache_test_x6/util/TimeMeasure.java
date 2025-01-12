package com.miyadai.spring_cache_test_x6.util;

import java.util.function.Supplier;

public class TimeMeasure {

	public static void time(Supplier<?> supplier) {
		long start = System.currentTimeMillis();
		System.out.print(supplier.get());
		long end = System.currentTimeMillis();
		System.out.println(" [" + (end - start) + "msec]");
	}

}

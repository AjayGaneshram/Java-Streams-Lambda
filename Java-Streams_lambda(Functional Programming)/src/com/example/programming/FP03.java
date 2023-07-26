package com.example.programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FP03 {

	public static void main(String[] args) {
		int [] array= {1,2,3,45,6,78,9};
//		Arrays.stream(array).boxed().collect(Collectors.toList());
		System.out.println(Arrays.stream(array).boxed().collect(Collectors.toList()));
		IntStream.iterate(1,e->e+2).limit(10).peek(System.out::print).sum();
		System.out.println();
		System.out.println(IntStream.iterate(1,e->e+2).limit(10).peek(System.out::println).sum());
		System.out.println();
		System.out.println(IntStream.iterate(1,e->e+2).limit(10).sum());
		System.out.println();
		System.out.println(IntStream.rangeClosed(1,5).reduce(1, (x,y)->x*y));
		
		//BigInteger
		System.out.println(IntStream.rangeClosed(1,50).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE, BigInteger::multiply));
	}
}

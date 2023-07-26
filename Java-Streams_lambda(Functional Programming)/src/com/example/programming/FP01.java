package com.example.programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FP01 {

	public static void print(int a) {
		
		System.out.print(","+a);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers=List.of(1,2,3,45,6,7,7,4,53,5,6);
		//Lambda function
		numbers.stream().forEach((a)->System.out.print(a));
		System.out.println();
		//Method Reference
		numbers.stream().forEach(System.out::print);
		System.out.println();
		
		System.out.println("Print Method : ");
		numbers.stream().forEach(FP01::print);;
		System.out.println();
		
		System.out.println("Map");
		//map
		numbers.stream().map((a)->(a+2)).forEach(FP01::print);;
		//filter
		System.out.println();
		System.out.println("Filter");
		numbers.stream().filter(number->number%2==0).map(number->number*2).forEach(System.out::println);
		System.out.println();
		//distinct
		System.out.println(numbers);
		numbers.stream().distinct().map(number->(number+",")).forEach(System.out::print);
		System.out.println();
		//sort
		System.out.println("Sorting ");
		numbers.stream().sorted().distinct().filter(a->a%2==0).map(number->number+",").forEach(System.out::print);
		//Custom sorting
		System.out.println();
		numbers.stream().sorted(Comparator.reverseOrder()).distinct().map(number->number+",").forEach(System.out::print);
		System.out.println();
		List.of("a","abc","abcd","abcde","b").stream().sorted(Comparator.comparing(str->str.length())).distinct().map(number->number+",").forEach(System.out::print);
		
		System.out.println();
		System.out.println("-------Reduce-----");
		System.out.println(List.of("1",34,3).stream().reduce((x,y)->x+"-"+y));
		System.out.println();
		
		System.out.println(List.of(1,34,3).stream().reduce(0,Integer::sum));;
		System.out.println();
		List<Integer> collectorList=numbers.stream().sorted().distinct().filter(a->a%2==0).collect(Collectors.toList());
		System.out.println(collectorList);
	}
}

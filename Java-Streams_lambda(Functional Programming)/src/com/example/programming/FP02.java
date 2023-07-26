package com.example.programming;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP02 {

	public static void main(String[] args) {
		//how to do this local variable
		/*
		 * 
		 * select the condition inside the map,filter,distinct
		 * right click --refactor --extract local variable
		 * add Integer,String to consumer local variable (instead of ? )
		 * */
		Predicate<Integer> predicateFilter = x->x%2==0;
		
		Function<Integer,Integer> mapper = x->x*2;
		
		Consumer<Integer> consumerAction = System.out::println;
		
		List.of(1,2,34,4,3).stream().filter(predicateFilter).map(mapper).forEach(consumerAction);
		
		
		
		//Behaviour parameterization
		//Sending the logic as an arguments to the function  like (x->x%2==0, x->x%2!=0)
		/*
		 * 
		 * 
		 * select the piece of code and right click
		 * refactor -- extract method
		 * 
		 * 
		 * For selecting the inline declaration , select the variable 
		 * refactor --inline
		 */
		List<Integer> numbers=List.of(1,2,3,4,5,6,7,8,9,10);
		
		filterAndPrint(System.out::print, x->x%2!=0, numbers);
		
		filterAndPrint(System.out::print, x->x%2==0, numbers);
		
		System.out.println();
		//supplier
		//no input but returns something
		System.out.println("supplier");
		Supplier<Integer> supplier=()->10*3;
		System.out.println(supplier.get());
		
		/*
		 * UnaryOperator
		 * to do the operation with single input
		 *  */
		UnaryOperator<Integer> operator=(x)->x*3;
		operator.apply(9);
		System.out.println();
		BiPredicate<Integer, String> biPredicate= (number,string)->
		{
			if(number>10 && string.length()>10) 
				return true;
			
			return false;
		};
		System.out.println(biPredicate.test(14, "ganeshram R.K."));;
		System.out.println(biPredicate.test(9, "ganeshram R.K."));;
		
		System.out.println("BiFunction");
		BiFunction<Integer,Integer,String> bifunction=(num1,num2)->{
			return num1+":"+num2;
		};
		System.out.println(bifunction.apply(10, 10));
		
		System.out.println("Biconsumer");
		BiConsumer<String, String> biConsumer=(s1,s2)->{
			System.out.println(s1);
			System.out.println(s2);
		};
		biConsumer.accept("GaneshRam", "Ajay");
	}

	private static void filterAndPrint(Consumer<Integer> consumerAction, Predicate<Integer> oldNumber,
			List<Integer> numbers) {
		numbers.stream().filter(oldNumber).forEach(consumerAction);
	}
}

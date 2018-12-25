package com.cocoa.java.lambda;

import java.io.File;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test1_Create{
	public static void main(String[] args)throws Exception{
		// create stream use Stream static method of
		Stream stream1 = Stream.of(1,2,3,4);
		Stream stream2 = Stream.of(1);
		stream1.forEach(System.out::println);
		stream2.forEach(System.out::println);

		  
		// create stream use java.util.Collection method stream()
		// the Collections is interface, we can use its implemention ,like  List , Set , Queue 
		// create stream use Stream use List stream 
		String[] arr = {"1","2"};
		List<String> list = Arrays.asList(arr);
		Stream stream3 = list.stream();
		stream3.forEach(System.out::println);
		
		// use int ,long ,double Stream
		IntStream intStream = IntStream.range(0,10);
		intStream.forEach(System.out::print);		
		System.out.println("");		
		
		// use Arrays.stream
		int[] intArray = {1,2,3};
		IntStream stream5 = Arrays.stream(intArray);
		stream5.forEach(System.out::print);
                System.out.println("");
		
		// Files.lines
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		dir = dir+File.separator + Test1_Create.class.getPackage().getName().replaceAll("\\.","\\/")+File.separator+"TestItem.java";
		// use Files.line
		Stream<String> lineStream = Files.lines(Paths.get(dir));
		lineStream.forEach(System.out::println);


	}	

}

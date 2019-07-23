package com.company;
import java.util.Optional;
import java.lang.reflect.Array;
import java.util.Arrays;
//http://www.importnew.com/11908.html#optional
public class Main {

    public static void main(String[] args) {

        Arrays.asList(1,3,4,5,7).forEach(e -> System.out.println(e));

		Optional<String> optional = Optional.ofNullable(null);
		
		System.out.println(optional.isPresent());
    }

}

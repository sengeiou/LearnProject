package com.cocoa.lambda;

import org.junit.Test;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrallelTest {

    @Test
    public void test() {
        Long current = System.currentTimeMillis();
        Stream.iterate(0L, (x) -> x + 1).limit(100000).reduce(0L, Long::sum);
        System.out.println(System.currentTimeMillis() - current);


        current = System.currentTimeMillis();
        Long sum = 0L;
        for (int i = 0; i < 100000; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - current);


        current = System.currentTimeMillis();
        Stream.iterate(0L, (x) -> x + 1).limit(100000).parallel().reduce(0L, Long::sum);
        System.out.println(System.currentTimeMillis() - current);


        current = System.currentTimeMillis();
        LongStream.rangeClosed(0L, 100000L).reduce(0L, Long::sum);
        System.out.println(System.currentTimeMillis() - current);


    }

}

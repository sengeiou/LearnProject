package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int code = getCode();
    }


    public static int getCode(){
        try {
            return  0;
        }finally {
            System.out.println("123");
        }
    }
}

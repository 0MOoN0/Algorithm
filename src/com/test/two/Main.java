package com.test.two;

public class Main {

    public static void main(String[] args) {
    	int sum = 1000;
    	for(int i=0; i<9; i++) {
    		int rand = (int)Math.random()*sum;
    		System.out.println("法师"+(i+1)+"分得 "+rand);
    		sum = sum - rand;
    	}
    }
}

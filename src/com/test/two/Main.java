package com.test.two;

public class Main {

    public static void main(String[] args) {
    	int sum = 1000;
    	for(int i=0; i<9; i++) {
    		int rand = (int)Math.random()*sum;
    		System.out.println("��ʦ"+(i+1)+"�ֵ� "+rand);
    		sum = sum - rand;
    	}
    }
}

package com.test.two;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>(10);
		Integer integer = list.get(11);
		System.out.println(integer);
	}

}

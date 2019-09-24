package com.test.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	
	public static void main(String[] args) {
		Integer i = new Integer(200);
		Integer k = new Integer(200);
		int j = 200;
		System.out.println(i==j);
		System.out.println(i.equals(j));
		System.out.println(k==i);
		System.out.println(i.equals(k));
	}

}

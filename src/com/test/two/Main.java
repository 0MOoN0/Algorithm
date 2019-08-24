package com.test.two;

public class Main {
	
	private static int a = 0;
	
	public static int b = 0;

	public static void main(String[] args) {
		Main.a = 10;
		Main main = new Main();
		main.a = 11;	
		String str = "abc";
		String[] split = str.split("abc");
		System.out.println(split.length-1);
		
	}

}

package com.test.two;

public class Main {
	
	private static int a = 0;

	public static void main(String[] args) {
		Main.a = 10;
		Main main = new Main();
		main.a = 11;	
	}

}

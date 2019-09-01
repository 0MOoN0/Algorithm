package com.test.two;

public class Main {
	
	public static void main(String[] args) {
		Main m = new Main();
		Integer a = 300;
		System.out.println(a);
		m.add(a);
		System.out.println(a);
		char[] c = {'h','e','l','l','o'};
		StringBuilder sb = new StringBuilder(new String(c));
		sb.reverse().toString().toCharArray();
	}
	
	public void add(Integer a) {
		a++;
	}

}

class User{
	
}

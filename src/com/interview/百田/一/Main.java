package com.interview.百田.一;

public class Main {

	public static void main(String[] args) {
		System.out.println(findStr("google".toCharArray()));
	}
	
	// 假设字符数组只有a-z
	public static char findStr(char[] cs) {
		char [] record = new char[26];
		for(int i=0; i<cs.length; i++) {
			record[cs[i]-'a']+=1;
		}
		for(int i=0; i<cs.length; i++) {
			if(record[cs[i]-'a'] == 1) {
				return cs[i];
			}
		}
		return ' ';
	}

}

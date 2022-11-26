package com.interview.网易.eight_字符迷阵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int testSize = Integer.parseInt(reader.readLine());
		ArrayList<char[][]> arr= new ArrayList();
		ArrayList<char[]> partten = new ArrayList();
		int x=0, y=0;
		char strMatrx[][];
		char[] chars;
		for(int i=0; i<testSize; i++) {
			String[] split = reader.readLine().split(" ");
			x = Integer.parseInt(split[0]);	// 行数
			y = Integer.parseInt(split[1]); // 列数
			strMatrx = new char[x][y];
			for(int j=0;j<x;j++) {
				strMatrx[j] = reader.readLine().toCharArray();
			}
			chars = reader.readLine().toCharArray();
			int result = 0;
			for(int j=0; j<strMatrx.length; j++) {
				for(int k=0; k<strMatrx[0].length; k++) {
					result += march(strMatrx, chars, j, k);
				}
			}
			System.out.println(result);
		}
	}
	
	public static int march(char [][]strs, char[] partten, int x, int y) {
		int X = x, Y = y;
		int result = 0;
		boolean flag = true;
		if(strs[x][y] == partten[0] && (strs[0].length-y>partten.length-1 || strs.length-x>partten.length-1)) {
			if(strs[0].length-y>partten.length-1) {
				Y++;
				for(int i=1;i<partten.length; i++) {
					if(strs[X][Y]!=partten[i]){
						flag = false;
						break;
					}
					Y++;
				}
				if(flag) {
					result ++;
				}
			}
			flag = true;
			X = x;
			Y = y;
			if(strs.length-x>partten.length-1) {
				X++;
				for(int i=1;i<partten.length; i++) {
					if(strs[X][Y]!=partten[i]){
						flag = false;
						break;
					}
					X++;
				}
				if(flag) {
					result ++;
				}
			}
			flag = true;
			X = x;
			Y = y;
			if(strs.length-x>partten.length-1 && strs[0].length-y>partten.length-1) {
				X++;
				Y++;
				for(int i=1;i<partten.length; i++) {
					if(strs[X][Y]!=partten[i]){
						flag = false;
						break;
					}
					Y++;
					X++;
				}
				if(flag) {
					result ++;
				}
			}
		}
		return result;
	}

}

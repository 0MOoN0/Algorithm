package com.interview.校招_2019编程题.十七_将满二叉树转换为求和树;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * wrong
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		//录入数据
		String[] preStr = reader.readLine().split(" ");
		String[] inStr = reader.readLine().split(" ");
		int[] pre = new int[preStr.length];
		int[] in = new int[inStr.length];
		// 数据转换
		for(int i=0; i<pre.length; i++) {
			pre[i] = Integer.parseInt(preStr[i]);
			in[i] = Integer.parseInt(inStr[i]);
		}
		int [] result = new int[in.length];
		System.arraycopy(in, 0, result, 0, in.length);
		int right = fracture(result, 0, result.length/2, result.length/2);
		int left = fracture(result, result.length/2, result.length-1, result.length/2);
		System.out.println(right+left);
		
	}
	public static int fracture(int [] arr, int begin, int end, int index) {
		// 到数组末尾
		if(end - begin <=1) {
			return 0;
		}
		int nextIndex = begin+end/2;
		int left = fracture(arr, 0, index-1, nextIndex);
		int right = fracture(arr, index+1, arr.length-1, nextIndex);
		// 重新给当前位置赋值
		arr[index] = left+right;
		// 一并返回当前值
		return right+left+arr[index];
	}
	

}

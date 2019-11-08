package com.interview.百田.二;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public static List<List<Integer>> printSum(int a[], int m){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		// 校验数据
		if(a==null) {
			return null;
		}
		for(int i=0;i<a.length; i++) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			if(i<m) {
				temp.add(a[i]);
				helper(a, m, a[i], i+1, temp);
			}
		}
		return result;
	}
	
	public static void helper(int a[], int m,int value,  int index, List<Integer> result){
		if(value + a[index]>m) {
			return ;
		}
		if(value + a[index] == m) {
			result.add(index);
			// 结束递归
			return ;
		}
		if(value + a[index] < m) {
			if(index+1 < a.length) {
				for(int i=index+1; i<a.length; i++) {
					result.add(a[i]);
					value += a[i];
					helper(a, m, value, i, result);
				}
			}
		}
	}

}

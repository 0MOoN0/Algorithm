package com.interview.校招_2019编程题.十六_获得最多的奖金;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * 从前后两边开始找相同大小的数字
 * 
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		String[] line = reader.readLine().split(" ");
		ArrayList<Long> result = new ArrayList<Long>();
		int [] arr = new int[line.length];
		for(int i=0; i<line.length; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		int begin =0, end =  arr.length-1;
		long beginCount = arr[begin], endCount = arr[end];
		while(begin<end) {
			// 判断结果是否相等
			if(beginCount == endCount) {
				// 如果相等，添加记录，移动坐标
				result.add(beginCount);
				beginCount += arr[++begin];
				endCount += arr[--end];
				continue;
			}else {
				// 如果不相等，移动坐标
				long temp = beginCount - endCount;
				if(temp<0) {
					beginCount += arr[++begin];
				}else {
					endCount += arr[--end];
				}
			}
		}
		if(result.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(result.get(result.size()-1));
		}
	}
}

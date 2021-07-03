package com.interview.校招_2019编程题.二十六_合并数组;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner reader = new Scanner(System.in);
		String str = reader.nextLine();
		String [] line1 = str.split(",");
		long [] arr1 = new long[line1.length];
		for(int i=0; i<line1.length; i++) {
			arr1[i] = Long.parseLong(line1[i]);
		}
        if (!reader.hasNext()) {
            System.out.println(str);
            return;
        }
		String[] line2 = reader.nextLine().split(",");
		long [] arr2 = new long[line2.length];
		for(int i=0; i<line2.length; i++) {
			arr2[i] = Long.parseLong(line2[i]);
		}
		long result [] = new long[arr1.length + arr2.length];
		if(result.length==0) {
			System.out.println(0);
		}
		long[] merge = merge(result, arr1, arr2);
		for(int i=0;i<merge.length; i++) {
			if(i!=merge.length-1) {
				System.out.print(merge[i]+",");
			}else {
				System.out.print(merge[i]);
			}
			
		}
		
	}
	
	public static long [] merge(long [] result, long []arr1, long [] arr2) {
		int arr1End = arr1.length-1;
		int arr2End = arr2.length-1;
		int resultEnd = result.length-1;
		while(arr1End>=0 || arr2End>=0) {
			if(arr1End<0) {
				result[resultEnd] = arr2[arr2End--];
				resultEnd --;
				continue;
			}else if(arr2End<0) {
				result[resultEnd] = arr1[arr1End--];
				resultEnd --;
				continue;
			}
			result[resultEnd] = arr1[arr1End]>arr2[arr2End]?arr1[arr1End--]:arr2[arr2End--];
			resultEnd --;
		}
		
		return result;
	}
	

}

package com.interview.算法.utils;

import java.util.Arrays;
import java.util.Random;

import com.interview.算法.common.Node;

public class Utils {
	
	/**
	 *  生成一个随机数组，规模小于给定参数规模
	 * @return
	 */
	public static int[] arrayGenerator(int size) {
		Random random = new Random();
		int length = new Double(Math.random()*size+1).intValue();
		int[] arr = new int[length];
		for(int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt();
		}
		return arr;
	}
	
	
	/**
	 * 拷贝数组
	 * @param arr
	 * @return
	 */
	public static int[] arrayCopy(int[] arr) {
		int[] target = new int [arr.length];
		System.arraycopy(arr, 0, target, 0, arr.length);
		return target;
	}
	
	
	/**
	 * 比较两个数组是否相等
	 * @param arr1	数组1
	 * @param arr2	数组2
	 * @param printBreakPoint	是否打印错误位置
	 * @return
	 */
	public static boolean arrayCompare(int[] arr1, int[] arr2, boolean printBreakPoint) {
		if(arr1.length == arr2.length) {
			int size = arr1.length;
			for(int i=0; i<size; i++) {
				if(arr1[i]!=arr2[i]) {
					if(printBreakPoint) {
						System.out.println("======breakpoint in :"+i);
						System.out.println("=====array1: "+Arrays.toString(arr1));
						System.out.println("=====array2: "+Arrays.toString(arr2));
					}
					return false;
				}
				return true;
			}
		}
		if(printBreakPoint) {
			System.out.println("======breakpoint in : 数组长度不相等");
		}
		return false;
	}
	
	/**
	 * 打印链表
	 * @param p
	 */
	public static void printLinkedList(Node p) {
		while(p != null) {
			System.out.print(p.value + " ");
			p = p.next;
		}
		System.out.println();
	}
	
	
}

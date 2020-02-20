package com.interview.�㷨.utils;

import java.util.Arrays;
import java.util.Random;

import com.interview.�㷨.common.Node;

public class Utils {
	
	/**
	 *  ����һ��������飬��ģС�ڸ���������ģ
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
	 * ��������
	 * @param arr
	 * @return
	 */
	public static int[] arrayCopy(int[] arr) {
		int[] target = new int [arr.length];
		System.arraycopy(arr, 0, target, 0, arr.length);
		return target;
	}
	
	
	/**
	 * �Ƚ����������Ƿ����
	 * @param arr1	����1
	 * @param arr2	����2
	 * @param printBreakPoint	�Ƿ��ӡ����λ��
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
			System.out.println("======breakpoint in : ���鳤�Ȳ����");
		}
		return false;
	}
	
	/**
	 * ��ӡ����
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

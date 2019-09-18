package com.interview.leetcode.Ò»Îå_threeSum;

public class Driver {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		int [] a = new int[] {-1,0,1,2,-1,-4};
		int [] b = new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		int [] c = new int[] {0,0,0};
		System.out.println(s.threeSum(b));
	}

}

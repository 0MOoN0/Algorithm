package com.interview.剑指offer.六_旋转数组的最小数字.二分查找;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int test [] = new int[] {1,0,1,1,1,1};
		int inRotateArray = s.minNumberInRotateArray(test);
		System.out.println(inRotateArray);

	}

}

package com.interview.算法.三.Q1;

/**
 * 给定一个数组，求如果排序之后，相邻两数的最大差值，要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 * 非比较的排序：捅排，基数排；使用捅排的思想是排除答案来自同一个桶内部的可能性，答案可能来自空桶间，也可能来自两个桶之间的差值
 * 输入:[1,2,3,6,7,8]
 * 输出：3
 * @author Peter
 *
 */
public class MaxGap {

	
	// for test
	public static void main(String[] args) {
		
		int [] nums = new int[] {1,3,2,6,8,7};
		int num = maxGap(nums);
		System.out.println(num);
	}
	
	/**
	 * 基于捅排的思想
	 * @param nums
	 * @return
	 */
	public static int maxGap(int [] nums) {
		// 判断测试用例是否符合条件
		if(nums==null || nums.length<2) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int len = nums.length;
		// 找出数组中的最大值和最小值
		for(int i=0; i<len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		// 如果最小值和最大值相等，说明数组里面的数的都相等，最大差距为0
		if(min == max) {
			return 0;
		}
		// 定义桶
		boolean[] hasNum = new boolean[len+1];
		int [] maxs = new int[len+1];
		int [] mins = new int[len+1];
		
		int bid = 0;	// 当前数所在的桶的下标
		// 将每个数都进行比较和入桶
		for(int i=0; i<len; i++) {
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true; 
		}
		
		int res = 0;
		int lastMax = maxs[0];
		for(int i=1; i<len; i++) {
			// 判断是否为空桶
			if(hasNum[i]) {
				// 用当前最小值减去上一个非空桶的最大值
				res = Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	
	/**
	 * 算出所在数所对应的下标
	 * 相当于：( (num-min) / (max-min) ) * len
	 * (num-min) / (max-min) 表示在数轴上，num到min的位置与max到min的比值
	 * ( (num-min) / (max-min) ) * len 表示如果将(max-min)分成len份，(num-min)能占到几份，也就是在第几个桶
	 * @param num
	 * @param len
	 * @param min
	 * @param max
	 * @return
	 */
	public static int bucket(long num, long len, long min, long max) {
		return (int) ((num-min) * len / (max-min));
	}
}

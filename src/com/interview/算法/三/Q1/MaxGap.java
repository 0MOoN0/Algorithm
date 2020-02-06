package com.interview.�㷨.��.Q1;

/**
 * ����һ�����飬���������֮����������������ֵ��Ҫ��ʱ�临�Ӷ�O(N)����Ҫ�����÷ǻ��ڱȽϵ�����
 * �ǱȽϵ�����ͱ�ţ������ţ�ʹ��ͱ�ŵ�˼�����ų�������ͬһ��Ͱ�ڲ��Ŀ����ԣ��𰸿������Կ�Ͱ�䣬Ҳ������������Ͱ֮��Ĳ�ֵ
 * ����:[1,2,3,6,7,8]
 * �����3
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
	 * ����ͱ�ŵ�˼��
	 * @param nums
	 * @return
	 */
	public static int maxGap(int [] nums) {
		// �жϲ��������Ƿ��������
		if(nums==null || nums.length<2) {
			return 0;
		}
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int len = nums.length;
		// �ҳ������е����ֵ����Сֵ
		for(int i=0; i<len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}
		// �����Сֵ�����ֵ��ȣ�˵��������������Ķ���ȣ������Ϊ0
		if(min == max) {
			return 0;
		}
		// ����Ͱ
		boolean[] hasNum = new boolean[len+1];
		int [] maxs = new int[len+1];
		int [] mins = new int[len+1];
		
		int bid = 0;	// ��ǰ�����ڵ�Ͱ���±�
		// ��ÿ���������бȽϺ���Ͱ
		for(int i=0; i<len; i++) {
			bid = bucket(nums[i], len, min, max);
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true; 
		}
		
		int res = 0;
		int lastMax = maxs[0];
		for(int i=1; i<len; i++) {
			// �ж��Ƿ�Ϊ��Ͱ
			if(hasNum[i]) {
				// �õ�ǰ��Сֵ��ȥ��һ���ǿ�Ͱ�����ֵ
				res = Math.max(res, mins[i]-lastMax);
				lastMax = maxs[i];
			}
		}
		return res;
	}
	
	/**
	 * �������������Ӧ���±�
	 * �൱�ڣ�( (num-min) / (max-min) ) * len
	 * (num-min) / (max-min) ��ʾ�������ϣ�num��min��λ����max��min�ı�ֵ
	 * ( (num-min) / (max-min) ) * len ��ʾ�����(max-min)�ֳ�len�ݣ�(num-min)��ռ�����ݣ�Ҳ�����ڵڼ���Ͱ
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

package com.interview.剑指offer.九_变态跳台阶;

/**
 * 每层楼梯都有跳和不跳两种选择，一共有n-1层
 * AC - 15ms
 * @author Peter
 *
 */
public class Solution2 {
	public int JumpFloorII(int target) {
		if (target <= 0)
			return 0;
		return 1 << (target - 1);
	}
}
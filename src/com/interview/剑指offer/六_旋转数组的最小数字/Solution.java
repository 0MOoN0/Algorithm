package com.interview.剑指offer.六_旋转数组的最小数字;
import java.util.ArrayList;
/**
 * 暴力查找
 * @author Peter
 *
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	int min = Integer.MAX_VALUE;
    	for (int i : array) {
			min = Math.min(i, min);
		}
    	return min;
    }
}
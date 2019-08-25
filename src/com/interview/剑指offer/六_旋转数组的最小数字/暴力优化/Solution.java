package com.interview.剑指offer.六_旋转数组的最小数字.暴力优化;
import java.util.ArrayList;
/**
 * 暴力查找优化
 * @author Peter
 *
 */
public class Solution {
    public int minNumberInRotateArray(int [] array) {
    	int min = Integer.MAX_VALUE;
    	if(array.length==0) return 0;
    	for(int i=array.length-1; 0<i; i--) {
    		if(array[i]<array[i-1]) {
    			return array[i];
    		}
    	}
    	return min;
    }
}
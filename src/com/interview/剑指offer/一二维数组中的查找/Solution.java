package com.interview.剑指offer.一二维数组中的查找;

import java.util.Arrays;
/**
 * 使用二分查找对每一行进行查找
 * @author Peter
 *
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i=0; i<array.length; i++) {
        	int index = Arrays.binarySearch(array[i], target);
        	if(index>=0) {
        		return true;
        	}
        }
    	return false;
    }
}
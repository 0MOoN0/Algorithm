package com.interview.剑指offer.一_二维数组中的查找.soution2;

import java.util.Arrays;

public class Solution {
    public boolean Find(int target, int [][] array) {
        for(int i=array.length-1; 0<=i&&array[0].length>0; i--) {
        	if(array[i][0]==target) {
        		return true;
        	}else if(target<array[i][0]) {
        		continue;
        	}
        	if(Arrays.binarySearch(array[i], target) >= 0) {
        		return true;
        	}
        }
    	return false;
    }
    
}
package com.interview.��ָoffer.��_��ת�������С����.�����Ż�;
import java.util.ArrayList;
/**
 * ���������Ż�
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
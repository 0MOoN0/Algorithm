package com.interview.��ָoffer.һ��ά�����еĲ���;

import java.util.Arrays;
/**
 * ʹ�ö��ֲ��Ҷ�ÿһ�н��в���
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
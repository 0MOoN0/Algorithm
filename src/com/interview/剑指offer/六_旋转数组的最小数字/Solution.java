package com.interview.��ָoffer.��_��ת�������С����;
import java.util.ArrayList;
/**
 * ��������
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
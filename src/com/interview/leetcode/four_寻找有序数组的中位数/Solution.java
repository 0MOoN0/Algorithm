package com.interview.leetcode.four_Ѱ�������������λ��;
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int mergeLength = nums1.length + nums2.length;
    	int q = 0, p = 0;
    	// ��ʼ���ϲ����鳤��
    	int [] mergeArray = new int [mergeLength];
    	// Ŀ��������
    	int targetIndex = mergeLength / 2 ;
    	// ������λ��
    	for(int i=0; i <= targetIndex; i++) {
    		if(! (nums1.length > q)) {
    			mergeArray[i] = nums2[p++];
    		}else if(!(nums2.length > p)) {
    			mergeArray[i] = nums1[q++];
    		}else {
    			mergeArray[i] = nums1[q] < nums2[p] ? nums1[q++] : nums2[p++];
    		}
    	}
    	if(mergeLength % 2 ==0) {
    		// ż��
    		return ((float)mergeArray[targetIndex] + mergeArray[targetIndex-1])/2;
    	}else {
    		// ����
    		return mergeArray[targetIndex];
    	}
    }
    
    public static void main(String[] args) {
		Solution solution = new Solution();
		int nums1[]= {1,3};
		int nums2[]= {2};
		
		System.out.println(solution.findMedianSortedArrays(nums1, nums2));;
	}
    
}
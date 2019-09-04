package com.interview.leetcode.һһ��_�������;
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>(numRows);
        // numRowsΪ�����ѭ����
        for(int i=1; i<=numRows; i++){
            ArrayList<Integer> innerList = new ArrayList<Integer>();
            for(int j=0; j<i; j++){
                if(j==0 || j==i-1){
                    innerList.add(1);
                }else{
                    int sum = list.get(i-2).get(j-1)+list.get(i-2).get(j);
                    innerList.add(sum);
                }
            }
            list.add(innerList);
            
        }
        return list;
    }
}
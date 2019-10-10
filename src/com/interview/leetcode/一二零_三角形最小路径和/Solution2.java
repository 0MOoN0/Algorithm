package com.interview.leetcode.һ����_��������С·����;

import java.util.List;

/**
 ʹ��˫��ѭ��-AC-6ms
1. ÿ�е����ֶ�ֻ��ʹ��һ��
2. ��(x, y)��������С·�� = Min ( (x+1, y) , (x+1, y+1) )
���ϣ����Բ������µĿռ��ҳ���С·���ͣ����ǻ��ԭ�����޸�
 * @author Peter
 *
 */
class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // ��һ�е����ֵ����ж�
        if(triangle.size()==1){
            return triangle.get(0).get(0);
        }
        for(int i=triangle.size()-2; i>=0; i--){
            List<Integer> row = triangle.get(i);
            int col = row.size();

            for(int j=0; j<col; j++){
                int colNum = row.get(j);
                int left = colNum+triangle.get(i+1).get(j);
                int right = colNum+triangle.get(i+1).get(j+1);
                row.set(j, Math.min(left, right));
            }
        } 
        return triangle.get(0).get(0);
    }
}
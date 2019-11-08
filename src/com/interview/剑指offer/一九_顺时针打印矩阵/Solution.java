package com.interview.��ָoffer.һ��_˳ʱ���ӡ����;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int size = matrix.length * matrix[0].length;
        int counter = 1;
        int col = matrix[0].length;
        int row = matrix.length;
        int xStart = 0, xEnd = col-1, yStart = 0, yEnd = row-1;
        ArrayList<Integer> result = new ArrayList<Integer>();
        while(counter <= size){
            // ��������
            for(int i=xStart; i<=xEnd && counter <= size ;i++){
                result.add(matrix[yStart][i]);
                counter++;
            }
            // ��������
            for(int i=yStart+1; i<=yEnd && counter <= size; i++){
                result.add(matrix[i][xEnd]);
                counter++;
            }
            // ��������
            for(int i=xEnd-1; xStart<=i && counter <= size; i--){
                result.add(matrix[yEnd][i]);
                counter++;
            }
            // ���µ���
            yStart++;
            for(int i=yEnd-1; i>=yStart && counter <= size; i--){
                result.add(matrix[i][xStart]);
                counter++;
            }
            // �ı�����
            xStart++;xEnd--;yEnd--;
        }
        return result;
    }
}
package com.interview.У��_2019�����.ʮ��_���ľ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //�����ľ�Ŀ�ߵĶ�ά����
        int[][] bricks = new int[n][2];
        String[] strs;
        for (int i = 0; i < n; i++) {
            strs = bf.readLine().split(" ");
            bricks[i][0] = Integer.parseInt(strs[0]);
            bricks[i][1] = Integer.parseInt(strs[1]);
        }
        if (n==1){
            System.out.println(1);
            return;
        }
        //���տ��������,Ȼ���󳤶ȵ������������
        Arrays.sort(bricks, (a, b) -> a[0] - b[0]);
        /**
         * ���ǰ��տ�ȴ�С����� bricks ����������
         * dp�����д洢������ľ�ĳ��ȣ�����һ�����������飬�������ܱ�֤��ľ�Ĳ��
         */
        int[] dp = new int[n];
        int count = 0;//����
        for (int i = 0; i < n; i++) {
            if (count == 0 || bricks[i][1] >= dp[count - 1]) {
                //����ǰ��ľ�ĳ��� >= dp�����б��������ľ���ȣ������Ǿͽ������뵽 dp ������,���Ҳ�����һ
                dp[count] = bricks[i][1];
                count++;
            }else {
                /**
                 * �������һ�£������Ǽ���Ļ�ľ bricks[i][1],���ĳ���С��dp�е���󳤶�
                 * ������Ҫ������dp���ҵ� <= bricks[i][1] ��ӽ���ֵ������ index�������滻�����ڵĳ��� bricks[i][1]
                 * ΪʲôҪ�滻: dp�����л�ľ�Ŀ�ȶ���С�� bricks[i]�ģ���ľbricks[i]�Ŀ�ȱ�dp[index]��ȴ�
                 * ����bricks[i]�ĳ��� >= dp[index],�ڶѻ�ľ����£���Ȼ������ѡ���Ⱥͳ��ȸ���Ļ�ľ��
                 */
            	//ע�����������޷�AC�������WA
//                int index = lowerBound(dp, 0, count, bricks[i][1]);
//                dp[index] = bricks[i][1];
            }
        }
        System.out.println(count);
    }

}

package com.interview.校招_2019编程题.十八_搭积木;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        //保存积木的宽高的二维数组
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
        //按照宽进行排序,然后求长度的最长上升子序列
        Arrays.sort(bricks, (a, b) -> a[0] - b[0]);
        /**
         * 我们按照宽度从小到大对 bricks 进行了排序
         * dp数组中存储的数积木的长度，它是一个上升的数组，这样才能保证积木的层叠
         */
        int[] dp = new int[n];
        int count = 0;//层数
        for (int i = 0; i < n; i++) {
            if (count == 0 || bricks[i][1] >= dp[count - 1]) {
                //当当前积木的长度 >= dp数组中保存的最大积木长度，那我们就将它加入到 dp 数组中,并且层数加一
                dp[count] = bricks[i][1];
                count++;
            }else {
                /**
                 * 这里解释一下：当我们加入的积木 bricks[i][1],它的长度小于dp中的最大长度
                 * 我们需要在数组dp中找到 <= bricks[i][1] 最接近的值的索引 index，将它替换成现在的长度 bricks[i][1]
                 * 为什么要替换: dp数组中积木的宽度都是小于 bricks[i]的，积木bricks[i]的宽度比dp[index]宽度大，
                 * 而且bricks[i]的长度 >= dp[index],在堆积木情况下，当然是优先选择宽度和长度更大的积木。
                 */
            	//注释下面两句无法AC，会出现WA
//                int index = lowerBound(dp, 0, count, bricks[i][1]);
//                dp[index] = bricks[i][1];
            }
        }
        System.out.println(count);
    }

}

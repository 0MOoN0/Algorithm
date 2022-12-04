package com.other.算法.merge_sort.small_sum;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;

/**
 * 求小和
 * 在一个数组中。一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子: [1.3.4.2.5]
 * 1左边比1小的数:没有
 * 3左边比3小的数: 1
 * 4左边比4小的数: 1、3
 * 2左边比2小的数: 1
 * 5左边比5小的数: 1.、3、4、2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 */
class Solution {
    public int smallSum(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int result = 0;
        // 步长
        int K = 1;
        int N = arr.length; // 数组长度
        while (K < N) {
            // 每次内部比较都是从头开始
            int L = 0;
            // 当剩下的元素小于K时，剩下的元素已经有序，不用再比较
            while (N - L > K) {
                // 左边数组的终点
                int M = L + K - 1;
                // 右边数组的终点，选择剩余长度和步长的较小者
                // 剩余长度的计算方法：总长度减去左边数组下标，再减一，获得右边数组开始下标
                int R = M + Math.min(N - M - 1, K);
                result += merge(arr, L, M, R);
                L = R + 1;
            }
            if (K > N / 2) {
                break;
            }
            K <<= 1;
        }
        return result;
    }

    public int merge(int[] arr, int L, int M, int R) {
        int sum = 0;
        int[] temp = new int[R - L + 1];
        int N = M + 1;
        int P = 0;
        while (L <= M && N <= R) {
            if (arr[L] < arr[N]) {
                sum += (arr[L] * (R - N + 1));
            }
            temp[P++] = arr[L] < arr[N] ? arr[L++] : arr[N++];
        }
        while (L <= M) {
            temp[P++] = arr[L++];
        }
        while (N <= R) {
            temp[P++] = arr[N++];
        }
        while (P > 0) {
            arr[R--] = temp[--P];
        }
        return sum;
    }

    // 校验算法
    public static void main(String[] args) {
        Solution smallSum = new Solution();
        for (int i = 0; i < 5000; i++) {
            int[] sourceArr = RandomUtil.randomInts(RandomUtil.randomInt(1, 1000));
            int[] copyArr = new int[sourceArr.length];
            ArrayUtil.copy(sourceArr, copyArr, sourceArr.length);
            int result = smallSum.smallSum(sourceArr);
            int resultN = smallSum.normalSolution(copyArr);
            Assert.equals(resultN, result);
        }
    }

    /**
     * 简单的实现方式
     *
     * @param arr
     */
    public int normalSolution(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i]) {
                    result += arr[j];
                }
            }
        }
        return result;
    }

}

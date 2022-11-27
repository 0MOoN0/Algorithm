package com.leetcode.sort.九一二_排序数组;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.Arrays;

/**
 * 归并排序，非递归写法
 */
class Solution2_MergeSort {
    public int[] sortArray(int[] nums) {
        // 归并排序-非递归
        return nums;
    }

    public void process(int[] arr) {
        int size = arr.length;
        int K = 1;
        // 外层循环，步长不停增加的过程中，不停试探
        while (K < size) {
            // 每一次内部的合并的左边都是从0开始
            int L = 0;
            while (L < size) {
                if (L + K > size) {
                    break;
                }
                // 左边数组的终点，
                int M = L + K - 1;
                // 右边数组的起点
                int N = M + 1;
                // 右边数组的终点，选择步长和剩余长度的较小者
                int R = M + Math.min(K, size - M - 1);
                // 临时数组的大小等于当前比较范围的大小
                int[] temp = new int[R - L + 1];
                int P = 0;
                // 合并数组
                while (L <= M && N <= R) {
                    temp[P++] = arr[L] < arr[N] ? arr[L++] : arr[N++];
                }
                while (L <= M) {
                    temp[P++] = arr[L++];
                }
                while (N <= R) {
                    temp[P++] = arr[N++];
                }
                int Q = R;
                while (P > 0) {
                    arr[Q--] = temp[--P];
                }
                L = R + 1;
            }
            if (K > size / 2) {
                break;
            }
            K <<= 1;
        }
    }


    public static void main(String[] args) {
        Solution2_MergeSort solution2_mergeSort = new Solution2_MergeSort();
        for (int k = 0; k < 20; k++) {
            ThreadUtil.execute(() -> {
                for (int i = 0; i < 2500; i++) {
                    int[] ints = RandomUtil.randomInts(RandomUtil.randomInt(1, 1000));
                    int[] copyArray = new int[ints.length];
                    ArrayUtil.copy(ints, copyArray, ints.length);
                    Arrays.sort(ints);
                    solution2_mergeSort.process(copyArray);
                    boolean equals = ArrayUtil.equals(ints, copyArray);
                    Assert.isTrue(equals);
                }
            });
        }
        System.out.println(true);
    }

}

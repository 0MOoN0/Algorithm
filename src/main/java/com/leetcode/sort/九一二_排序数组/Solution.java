package com.leetcode.sort.九一二_排序数组;


/**
 * 归并排序-递归写法
 */
class Solution {
    public int[] sortArray(int[] nums) {
        // 归并排序-递归
        // 注：长度为0 - length-1
        process(nums, 0, nums.length - 1);
        return nums;
    }

    public void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        // 算出中间点 (R+L) / 2 可能溢出
        // 注2：运算顺序 >> 小于 +- ，括号最优先
        int M = ((R - L) >> 1) + L;
        // 递归调用，分隔数组
        process(arr, L, M);
        process(arr, M + 1, R);
        // 合并数组
        merge(arr, L, M, R);
    }

    public void merge(int[] arr, int L, int M, int R) {
        // 临时数组
        int size = R - L + 1;
        int[] temp = new int[size];
        int N = M + 1;
        int P = 0;
        // 注4：l为左边界，回写数组时需要使用左边界判断指针是否越界
        int l = L;
        // 注3： M 和 R为终点，因此需要判断是否等于M和R
        while (L <= M && N <= R) {
            temp[P++] = arr[L] < arr[N] ? arr[L++] : arr[N++];
        }
        while (L <= M) {
            temp[P++] = arr[L++];
        }
        while (N <= R) {
            temp[P++] = arr[N++];
        }
        while (size - 1 >= 0) {
            arr[R--] = temp[--size];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
        Solution solution = new Solution();
        solution.sortArray(nums);

    }

}

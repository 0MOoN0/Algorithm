package com.leetcode.三一_下一个排列;

/**
 * 1. 我们希望下一个数 比当前数大，这样才满足 “下一个排列” 的定义。因此只需要 将后面的「大数」与前面的「小数」交换，就能得到一个更大的数。比如 123456，将 5 和 6 交换就能得到一个更大的数 123465。
 * 2. 我们还希望下一个数 增加的幅度尽可能的小，这样才满足“下一个排列与当前排列紧邻“的要求。为了满足这个要求，我们需要：
 * 2.1 在尽可能靠右的低位 进行交换，需要 从后向前 查找
 * 2.2 将一个 尽可能小的「大数」 与前面的「小数」交换。比如 123465，下一个排列应该把 5 和 4 交换而不是把 6 和 4 交换
 * 2.3 将「大数」换到前面后，需要将「大数」后面的所有数 重置为升序，升序排列就是最小的排列。以 123465 为例：首先按照上一步，交换 5 和 4，得到 123564；然后需要将 5 之后的数重置为升序，得到 123546。显然 123546 比 123564 更小，123546 就是 123465 的下一个排列
 * 以上就是求 “下一个排列” 的分析过程。
 *
 * 算法过程
 * 标准的 “下一个排列” 算法可以描述为：
 *
 * 1. 从后向前 查找第一个 相邻升序 的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
 * 2. 在 [j,end) 从后向前 查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
 * 3. 将 A[i] 与 A[k] 交换
 * 4. 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
 * 5. 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 *
 */
class Solution {
    public void nextPermutation(int[] nums) {
        // 找到第一个降序的i，为较小数
        int i = nums.length - 2;
        // nums[i] 不能等于 nums[i+1]，i一定要是降序的
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        // 如果存在降序的i，则i后面的数都是降序，所以一定会存在一个大于i的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // 使剩余数组升序
        reverse(nums, i + 1);
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start > end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        Solution solution = new Solution();
        solution.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

}
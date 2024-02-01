package com.leetcode.三二二_零钱兑换;

import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();

    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        return findway(coins, amount);
    }

    public int findway(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        if (memo.get(amount) != null) {
            return memo.get(amount);
        }
        int res = -1;
        for (int i = 0; i < coins.length; i++) {
            int curRes = findway(coins, amount - coins[i]);
            if (curRes >= 0) {
                res = res == -1 ? curRes : res;
                res = Math.min(res + 1, curRes + 1);
            }
        }
        memo.put(amount, res);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {2, 5, 10, 1};
        int amount = 27;
        System.out.println(solution.coinChange(coins, amount)); // 3
    }
}
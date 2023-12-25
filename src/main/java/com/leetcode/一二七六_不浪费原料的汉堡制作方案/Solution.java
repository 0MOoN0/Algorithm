package com.leetcode.一二七六_不浪费原料的汉堡制作方案;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：数学题
 * 假设有x个巨无霸汉堡，y个小皇堡，T表示tomatoSlices，C表示cheeseSlices，有如下方程
 * 1. 4x + 2y = T
 * 2. x + y = C
 * 同时需要满足不等式：x >= 0 && y >= 0，由此可解
 */
class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<Integer>();
        if(tomatoSlices%2 != 0 || tomatoSlices < 2*cheeseSlices || 4*cheeseSlices < tomatoSlices){
            return res;
        }
        res.add(tomatoSlices / 2 - cheeseSlices);
        res.add(2*cheeseSlices - tomatoSlices/2);
        return res;
    }
}
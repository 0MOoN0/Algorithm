package com.leetcode.二六九六_删除子串后的字符串最小长度;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {

    public int minLength(String s) {
        // 用栈
        List<Character> list = new ArrayList<Character>();
        for (int i = 0; i < s.length(); i++) {
            list.add(s.charAt(i));
            int size = list.size();
            if (size >= 2 && ((list.get(size - 1) == 'B' && list.get(size - 2) == 'A') || list.get(size - 1) == 'D' && list.get(size - 2) == 'C')) {
                list.remove(size - 1);
                list.remove(size - 2);
            }
        }
        return list.size();
    }

}

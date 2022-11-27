package com.leetcode.五五一_学生出勤记录;

/**
 * @author Leon
 */
public class Solution {

    int Atimes = 0;
    int Ltimes = 0;
    int result = 0;
    int days = 0;


    public int checkRecord(int n) {
        days = n;
        check(0);
        return result;
    }

    private void check(int n) {
        if (n < days) {
            check(n + 1);
            // 如果缺勤次数或迟到次数无法再增加，说明接下来不用再计算，这条路走不通了
            if (Atimes + 1 >= 2 && Ltimes + 1 >= 3) {
                return;
            }
            if (Atimes + 1 < 2) {  // 缺勤
                Atimes += 1;
                // 在下一轮可以重新再迟到
                int temp = Ltimes;
                Ltimes = 0;
                check(n + 1);
                // 将迟到的状态回退
                Ltimes = temp;
                Atimes -= 1;
            }
            if (Ltimes + 1 < 3) {  // 无法再迟到
                // 模拟迟到
                Ltimes += 1;
                check(n + 1);
                Ltimes -= 1;
            }
        } else {
            result %= 1000000007;
            result++;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.checkRecord(4));
    }

}

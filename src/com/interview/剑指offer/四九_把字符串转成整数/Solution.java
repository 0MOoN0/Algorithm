package com.interview.½£Ö¸offer.ËÄ¾Å_°Ñ×Ö·û´®×ª³ÉÕûÊı;
// µİ¹é+¶ÌÂ·
public class Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        // Ê¹ÓÃ¶ÌÂ·ÖÕÖ¹µİ¹é
        boolean flag = ((n>0) && (sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
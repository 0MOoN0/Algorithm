package com.other.cy.二四;

/**
 * @author Leon
 */
public class Solution {

    //24
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 100; i <= 200; i++) {
            if ((i % 5 == 0) && (i % 6 == 0)) {
                continue;
            }
            if (i % 5 == 0) {
                sb.append(i + " ");
                continue;
            }
            if (i % 6 == 0) {
                sb.append(i + " ");
                continue;
            }
        }
        String[] s = sb.toString().split(" ");
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]+" ");
            if((i+1)%10==0){
                System.out.println();
            }
        }
    }

}

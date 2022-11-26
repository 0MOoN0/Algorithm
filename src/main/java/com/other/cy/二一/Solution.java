package com.other.cy.二一;

import java.util.*;

/**
 * @author Leon
 */
public class Solution {

    public static void main(String[] args) {
        // 定义结果集
        Set<Integer> result = new HashSet<>();
        Scanner s = new Scanner(System.in);
        System.out.println("请输入第一个数字列表(元素使用空格分割,以回车结束)");
        String str1 = s.nextLine();
        String[] s1 = str1.split(" ");
        // 求并集
        Arrays.stream(s1).forEach(str->result.add(Integer.parseInt(str)));
        System.out.println("请输入第二个数字列表(元素使用空格分割,以回车结束)");
        String str2 = s.nextLine();
        String[] s2 = str1.split(" ");
        // 求并集
        Arrays.stream(s2).forEach(str->result.add(Integer.parseInt(str)));
        Iterator<Integer> iterator = result.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next() +" ");
        }
    }


}

package com.other.cy.二二;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Leon
 */
public class Solution {

    // 22
    public static void main(String[] args) {
        // 容器
        Map<Integer, Integer> map = new HashMap<>();
        // 获取一百个随机数
        for (int i=0;i<100;i++){
            int ran = (int)(Math.random()*10);
            map.put(ran,map.getOrDefault(ran,0)+1);
        }
        // 遍历map
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        System.out.println("Num\ttimes");
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            System.out.println(next.getKey()+"\t"+next.getValue());
        }
    }

}

package com.test;

import com.interview.leetcode.一零零_相同的树.TreeNode;
import com.interview.leetcode.五八_最后一个单词的长度.Solution2;

import java.lang.reflect.Constructor;
import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Stream;

class Test {
    public static void main(String[] args) throws Exception {
        Class<Singleton> clazz = Singleton.class;
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : declaredConstructors){
            constructor.setAccessible(true);
            Object o1 = constructor.newInstance();
            Object o2 = constructor.newInstance();
            System.out.println(o1==o2);
            System.out.println(o1);
            System.out.println(o2);
        }
    }
}

class Singleton {
    private volatile static Singleton uniqueSingleton;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == uniqueSingleton) {
            synchronized (Singleton.class) {
                if (null == uniqueSingleton) {
                    uniqueSingleton = new Singleton();
                }
            }
        }
        return uniqueSingleton;
    }
}

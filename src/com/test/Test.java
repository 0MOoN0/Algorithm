package com.test;

class Test {
    public static void main(String[] args) throws Exception {
        String str1 = new String("a");
        String str2 = new String("a");
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);
        System.out.println(str1.hashCode() == str2.hashCode());
    }
}

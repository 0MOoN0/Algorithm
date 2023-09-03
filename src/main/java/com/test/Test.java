package com.test;


class Test {
    public static void main(String[] args) throws Exception {
//        Long.valueOf("100.00"); // NumberFormatException
        System.out.println(test());
        Test.class.getDeclaredConstructor().newInstance();
    }

    public static int test(){
        try {
            throw new RuntimeException("e1");
        }catch (Exception e){
            throw new RuntimeException("e2");
        }finally {
            return 100;
        }
    }
}


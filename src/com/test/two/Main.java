package com.test.two;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNextLine()) {
    		// 输入格式： 体重 身高
    		String[] data = s.nextLine().split(" ");
    		// BIM
    		double BIM = Double.parseDouble(data[0]) / Math.pow(Double.parseDouble(data[1]), 2);
    		// 判断国内
    		if(BIM < 18.5) {
    			System.out.println("国内标准指数：偏瘦");
    		}else if(BIM < 24) {
    			System.out.println("国内标准指数：正常");
    		}else if(BIM < 28) {
    			System.out.println("国内标准指数：偏胖");
    		}else if(BIM >= 28) {
    			System.out.println("国内标准指数：肥胖");
    		}
    		// 判断国际
    		if(BIM < 18.5) {
    			System.out.println("国际标准指数：偏瘦");
    		}else if(BIM < 25) {
    			System.out.println("国际标准指数：正常");
    		}else if(BIM < 30) {
    			System.out.println("国际标准指数：偏胖");
    		}else if(BIM >= 30) {
    			System.out.println("国际标准指数：肥胖");
    		}    		
    		
    	}
    }

}

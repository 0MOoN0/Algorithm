package com.test.two;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	while(s.hasNextLine()) {
    		// �����ʽ�� ���� ���
    		String[] data = s.nextLine().split(" ");
    		// BIM
    		double BIM = Double.parseDouble(data[0]) / Math.pow(Double.parseDouble(data[1]), 2);
    		// �жϹ���
    		if(BIM < 18.5) {
    			System.out.println("���ڱ�׼ָ����ƫ��");
    		}else if(BIM < 24) {
    			System.out.println("���ڱ�׼ָ��������");
    		}else if(BIM < 28) {
    			System.out.println("���ڱ�׼ָ����ƫ��");
    		}else if(BIM >= 28) {
    			System.out.println("���ڱ�׼ָ��������");
    		}
    		// �жϹ���
    		if(BIM < 18.5) {
    			System.out.println("���ʱ�׼ָ����ƫ��");
    		}else if(BIM < 25) {
    			System.out.println("���ʱ�׼ָ��������");
    		}else if(BIM < 30) {
    			System.out.println("���ʱ�׼ָ����ƫ��");
    		}else if(BIM >= 30) {
    			System.out.println("���ʱ�׼ָ��������");
    		}    		
    		
    	}
    }

}

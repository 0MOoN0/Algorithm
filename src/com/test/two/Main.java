package com.test.two;

import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String target = in.nextLine();
        String[] split = target.split(" ");
        StringBuffer sb = new StringBuffer();
        for(int i=split.length-1; i>0; i--) {
        	if(i!=0) {
        		sb.append(split[i]+" ");
        	}else {
        		sb.append(split[i]);
        	}
        }
        System.out.println(sb.toString());
    }

}

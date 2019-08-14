package com.interview.校招_2019编程题.two_被3整除;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long begin = sc.nextLong();
		long end = sc.nextLong();
		StringBuffer num = new StringBuffer();
		long count = 0;
		for(long i=1;i<=end;i++) {
			num.append(i);
			if(i >= begin) {
				BigDecimal bigDecimal = new BigDecimal(num.toString());
				BigDecimal[] result = bigDecimal.divideAndRemainder(BigDecimal.valueOf(3));
				if (result != null && result[1].toString().equals("0")) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}

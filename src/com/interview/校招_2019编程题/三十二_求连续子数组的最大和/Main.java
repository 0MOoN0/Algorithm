package com.interview.У��_2019�����.��ʮ��_�����������������;

import java.util.Scanner;

/**
 * ��leetcode��53.����������ͬ��ʹ�ö�̬�滮˼·���
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		// ����
		Scanner sc = new Scanner(System.in);
		String[] split = sc.nextLine().split(",");
		int ans=0, max=0;
		for(int i=0; i<split.length; i++) {
			int num = Integer.parseInt(split[i]);
			// ѡ���Ƿ��ؿ���ʼ����
			if(num>max+num) {
				max = num;
			}else {
				max = max + num;
			}
			ans = Math.max(ans, max);
		}
		System.out.println(ans);
	}

}

package com.interview.У��_2019�����.ʮһ_����;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ʹ�ö��ֲ��ҷ����
 * Arrays�Դ�binarySearch���൱����
 * 1. ������ҵ��������鷶Χ�ڣ��򷵻��Դ���Ҫ���ҵ���������(���������һ����ֵ�������������е�
 * λ���ǣ�Math.abs(index)-1)
 * 2. ��������������ķ�Χ�ڣ�����-1
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pileSize = sc.nextInt();	// �ѵ�����
		int [] piles = new int[pileSize];
		piles[0] = sc.nextInt();
		for(int j=1; j<pileSize; j++) {
			piles[j] = piles[j-1]+sc.nextInt();
		}
		int questSize = sc.nextInt();
		for(int i=0; i<questSize; i++) {
			int index = Arrays.binarySearch(piles, sc.nextInt());
			if(index == -1) {
				System.out.println(1);
			}else if(index<0) {
				System.out.println(Math.abs(index));
			}else {
				System.out.println(index+1);
			}
		}
	}
}

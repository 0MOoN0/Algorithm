package com.interview.У��_2019�����.ʮ_�˯;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int classSize = sc.nextInt();
		int qx = sc.nextInt();
		int [][] split = new int[classSize][2];
		int result = 0;
		int qxPointBase = 0;
		for(int i=0; i<classSize; i++) {
			split[i][0] = sc.nextInt();
		}
		for(int i=0; i<classSize; i++) {
			split[i][1] = sc.nextInt();
			// �����ǰ����Ϊ���ѣ������qxPoint�ܺ�
			if(split[i][1]==1) {
				qxPointBase += split[i][0];
			}
		}
		// �ٴα�������
		for(int i=0; i<classSize; i++) {
			// �жϵ�ǰ�����Ƿ�����
			if(split[i][1]!=1) {
				// ��������ѣ����жϽ���һ�ο������Ӷ���qxPoint
				int qxMax = qxPointBase;
				int step = 0;
				for(int j=i; j<classSize && step<qx; j++,step++) {
					// �жϽ����Ժ�ĵ�ǰ���Ƿ�ΪqxPoint;
					if(split[j][1]==1) {
						continue;
					}
					// �����ΪqxPoint�������qxPoint
					qxMax += split[j][0];
				}
				result = Math.max(qxMax, result);
			}
		}
		System.out.println(result);
	}

}

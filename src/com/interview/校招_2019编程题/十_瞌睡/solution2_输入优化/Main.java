package com.interview.У��_2019�����.ʮ_�˯.solution2_�����Ż�;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int classSize = Integer.parseInt(line[0]);
		int qx = Integer.parseInt(line[1]);
		int [][] split = new int[classSize][2];
		int result = 0;
		int qxPointBase = 0;
		line = reader.readLine().split(" ");
		for(int i=0; i<classSize; i++) {
			split[i][0] = Integer.parseInt(line[i]);
		}
		line = reader.readLine().split(" ");
		for(int i=0; i<classSize; i++) {
			split[i][1] = Integer.parseInt(line[i]);
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

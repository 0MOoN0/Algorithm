package com.interview.У��_2019�����.ʮ��_��;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] line = reader.readLine().split(" ");
		int times = Integer.parseInt(line[1]);
		int [][]tower = new int[Integer.parseInt(line[0])][2];
		ArrayList<int[]> result = new ArrayList<int[]>();
		// ��ֵ
		String[] towers = reader.readLine().split(" ");
		for(int i=0; i<tower.length; i++) {
			tower[i][0]=Integer.parseInt(towers[i]);
			tower[i][1]=i;
		}
		for(int i=0; i<times; i++) {
			// ����
			Arrays.sort(tower,(x, y)->x[0]-y[0]);
			// �Ƚϴ�С
			if(tower[tower.length-1][0]-tower[0][0]<2) {
				break;
			}
			// ���ڲ�ֵ
			tower[0][0]++;
			tower[tower.length-1][0]--;
			result.add(new int []{tower[tower.length-1][1],tower[0][1]});
		}
		// ���
		System.out.println(tower[tower.length-1][0] - tower[0][0]  + " "+ result.size());
		// �������
		for (int [] arr : result) {
			System.out.println(arr[0]+1+" "+(arr[1]+1));
		}
	}
}




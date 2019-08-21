package com.interview.У��_2019�����.ʮ��_������Ľ���;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * ��ǰ�����߿�ʼ����ͬ��С������
 * 
 * @author Peter
 *
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		String[] line = reader.readLine().split(" ");
		ArrayList<Long> result = new ArrayList<Long>();
		int [] arr = new int[line.length];
		for(int i=0; i<line.length; i++) {
			arr[i] = Integer.parseInt(line[i]);
		}
		int begin =0, end =  arr.length-1;
		long beginCount = arr[begin], endCount = arr[end];
		while(begin<end) {
			// �жϽ���Ƿ����
			if(beginCount == endCount) {
				// �����ȣ���Ӽ�¼���ƶ�����
				result.add(beginCount);
				beginCount += arr[++begin];
				endCount += arr[--end];
				continue;
			}else {
				// �������ȣ��ƶ�����
				long temp = beginCount - endCount;
				if(temp<0) {
					beginCount += arr[++begin];
				}else {
					endCount += arr[--end];
				}
			}
		}
		if(result.isEmpty()) {
			System.out.println(0);
		}else {
			System.out.println(result.get(result.size()-1));
		}
	}
}

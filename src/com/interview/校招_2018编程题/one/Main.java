package com.interview.У��_2018�����.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		reader.readLine();
		String[] split = reader.readLine().split(" ");
		ArrayList<Long> zs = new ArrayList();
		ArrayList<Long> fs = new ArrayList();
		Long temp = 0l;
		for(int i=0;i<split.length;i++) {
			temp = Long.parseLong(split[i]);
			if(temp>0) {
				zs.add(temp);
			}else {
				fs.add(temp);
			}
		}
		// ����������
		Collections.sort(zs);
		Collections.sort(fs);
		
		// ���� or ����һ��
		if(zs.size()>=3) {
			if(fs.size() >= 2){
				System.out.println(
						Math.max((zs.get(zs.size()-1) * zs.get(zs.size()-2) * zs.get(zs.size()-3)),(zs.get(zs.size()-1) * fs.get(0) * fs.get(1)))
				);
			}
			System.out.println(zs.get(zs.size()-1) * zs.get(zs.size()-2) * zs.get(zs.size()-3));
		// ����һ�� or ����һ��
		}else if(zs.size() >= 2) {
			if(fs.size() >= 2) {
				System.out.println(
						Math.max(zs.get(zs.size()-1)*fs.get(0)*fs.get(1), zs.get(0)*zs.get(1)*fs.get(fs.size()-1))
						);
			}
			System.out.println(zs.get(0)*zs.get(1)*fs.get(fs.size()-1));
		// ����һ��
		}else if(zs.size()==1) {
			System.out.println(zs.get(0)*fs.get(0)*fs.get(1));
		// ����
		}else {
			System.out.println(fs.get(0)*fs.get(1)*fs.get(2));
		}
		
	}

}

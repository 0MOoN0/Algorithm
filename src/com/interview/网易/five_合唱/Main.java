package com.interview.ÍøÒ×.five_ºÏ³ª;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int Num = in.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>(Num);
		for(int i=0; i<Num; i++) {
			a.add(in.nextInt());
		}
//		Collections.sort(a);
		Integer sum = a.parallelStream().reduce(0, (x,y) -> x+y);
		Integer avg = sum / a.size();
		List<Integer> min = a.parallelStream().filter(x -> x<=avg).collect(Collectors.toList());
		List<Integer> bigger = a.parallelStream().filter(x -> x>avg).collect(Collectors.toList());
		int temp = 0;
		sum = 0;
		for(int i=0; i<min.size()-1; i++) {
			temp = Math.abs(min.get(i+1) - min.get(i));
			sum += temp;
			
		}
		for(int i=0; i<bigger.size()-1; i++) {
			temp = Math.abs(bigger.get(i+1) - bigger.get(i));
			sum += temp;
			
		}
		
		System.out.println(sum);
	}

}

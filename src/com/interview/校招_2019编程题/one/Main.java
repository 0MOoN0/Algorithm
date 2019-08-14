package com.interview.校招_2019编程题.one;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int taskSize = sc.nextInt();
		int personSize = sc.nextInt();
		Task tasks []  = new Task[taskSize];
		Long ablity [] = new Long[personSize];
		for(int i=0;i<taskSize;i++) {
			tasks[i] = new Task(sc.nextLong(),sc.nextLong());
		}
		Arrays.sort(tasks, new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {
				if(o1.level<o2.level) {
					return -1;
				}else if(o1.level>o2.level) {
					return 1;
				}else {
					// 比较薪酬
					if(o1.reward>o2.reward) {
						return -1;
					}else if(o1.reward<o2.reward) {
						return 1;
					}else {
						return 0;
					}
				}
			}
		});
		int tempNum = 0;
		long max = 0;
		for(int i=0; i<personSize; i++) {
			ablity[i] = sc.nextLong();
			while(tempNum < taskSize ) {
				if (tasks[tempNum].level <= ablity[i] /* && tasks[tempNum].reward>max */) {
					max = tasks[tempNum].reward;
				}
				tempNum++;
			}
			System.out.println(max+" ");
			max = 0;
			tempNum = 0;
		}
	}
	
}

class Task{
	Long level;
	Long reward;
	public Task() {};
	public Task(Long level, Long reward) {
		this.level = level;
		this.reward = reward;
	}
}

package com.test.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
//		List<Integer> listOne = Arrays.asList(70,70,70,70);
//		List<Integer> listTwo = Arrays.asList(70,70,80,70);
		List<Integer> listOne = new ArrayList<Integer>();
		listOne.add(70);
		listOne.add(70);
		listOne.add(70);
		List<Integer> listTwo = new ArrayList<Integer>();
		listTwo.add(70);
		listTwo.add(80);
		listTwo.add(70);
		
		int score = findSecondScore(listOne, listTwo);
		System.out.println(score);
	}
	
	public static int findSecondScore(List<Integer> classOneScore, List<Integer> classTwoScore){
		int max=0;
		int sec=0;
		int classOneSize = classOneScore.size()-1;
		int classTwoSize = classTwoScore.size()-1;
		while(classOneSize>=0 || classTwoSize>=0){
			// 判断班级一，如果不为空，则取出并与第一第二比较 
			if(classOneSize>=0){
				int tempScore = classOneScore.get(classOneSize);
				if(tempScore >= max){
					max = tempScore;
				} else if(tempScore >= sec){
					sec = tempScore;
				}
			}
			// 判断班级一，如果不为空，则取出并与第一第二比较
			if(classTwoSize>=0){
				int tempScore = classTwoScore.get(classTwoSize);
				if(tempScore >= max){
					max = tempScore;
				} else if(tempScore >= sec){
					sec = tempScore;
				}
			}
			classOneSize--;
			classTwoSize--;
		}
		if(sec==0){
			return -1;
		} else{
			return sec;
		}
	}
	
}


package com.interview.À„∑®.πÈ≤¢≈≈–Ú;

import java.util.Arrays;

import com.interview.À„∑®.utils.Utils;

public class SolutionChecker {
	
	public static int times = 100000;
	public static int size = 1000000;

	public static void main(String[] args) {
		int[] arrayGenerator = Utils.arrayGenerator(size);
		int[] arrayCopy1 = Utils.arrayCopy(arrayGenerator);
		int[] arrayCopy2 = Utils.arrayCopy(arrayGenerator);
		Solution solution = new Solution();
		solution.sort(arrayCopy1, 0, arrayCopy1.length-1);
		rightSort(arrayCopy2);
		
		boolean check = check(arrayCopy1, arrayCopy2, true);
		if(check) {
			System.out.println("Nice");
			return ;
		}
		System.out.println("Fuck!");
	}
	
	public static void rightSort(int[] arr) {
		Arrays.sort(arr);
	}
	
	public static boolean check(int[] a, int [] b, boolean isPrint) {
		if(a.length != b.length) {
			return false;
		}
		for(int i=0; i<a.length; i++){
			if(a[i]!=b[i]) {
				if(isPrint) {
					System.out.println("My: "+ Arrays.toString(a));
					System.out.println("Right: "+Arrays.toString(b));
					System.out.println("deffrient in "+i);
				}
				return false;
			}
		}
		return true;
	}

}

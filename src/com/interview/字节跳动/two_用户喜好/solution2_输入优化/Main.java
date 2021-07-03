package com.interview.字节跳动.two_用户喜好.solution2_输入优化;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		InputReader inputReader = new InputReader(System.in);
		/*
		 * StreamTokenizer in = new StreamTokenizer(new BufferedReader( new
		 * InputStreamReader(System.in)));
		 */
//		Scanner sc = new Scanner(System.in);
		int userSize = inputReader.nextInt();
		int [] arr = new int[userSize+1];
		for(int i=1; i<arr.length; i++) {
			arr[i] = inputReader.nextInt();
		}
		int range = inputReader.nextInt();
		int result = 0;
		for(int j=0; j<range; j++) {
			int rangeBegin = inputReader.nextInt();
			int rangeEnd = inputReader.nextInt();
			int target = inputReader.nextInt();
			for(; rangeBegin<=rangeEnd; rangeBegin++) {
				if(arr[rangeBegin]==target) {
					result++;
				}
			}
			System.out.println(result);
			result = 0;
		}
	}
	static class InputReader {
		public BufferedReader reader;
		public StringTokenizer tokenizer;
		
		public InputReader(InputStream stream) {
			reader = new BufferedReader(new InputStreamReader(stream), 32768);
			tokenizer = null;
		}
		
		public String next() {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				try {
					tokenizer = new StringTokenizer(reader.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return tokenizer.nextToken();
		}
		
		public int nextInt() {
			return Integer.parseInt(next());
		}
	}
}


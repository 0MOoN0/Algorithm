package com.interview.leetcode.six_整数反转;

class Solution {
	public int reverse(int x) {

		int i = 0;
		String strx = x + "";
		StringBuffer buffer = new StringBuffer();
		// 处理负号
		if(strx.charAt(0) == '-') {
			buffer.append(strx, 1, strx.length());
			// 反转
			buffer.reverse();
			// 添加负号
		}else {
			buffer.append(strx);
			// 反转
			buffer.reverse();
		}

		try {
			i = Integer.parseInt(buffer.toString());
		}catch(NumberFormatException e) {
			return 0;
		}
		if(x<0) {
			return -i;
		}
		return i;
	}
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(120));
	}
	
}
package com.interview.�㷨;

public class ���Լ��_��С������ {
	// �ݹ鷨�����Լ��
	public static int maxCommonDivisor2(int m, int n) {
		if (m < n) {// ��֤m>n,��m<n,��������ݽ���
			int temp = m;
			m = n;
			n = temp;
		}
		if (m % n == 0) {// ������Ϊ0,�������Լ��
			return n;
		} else { // ����,���еݹ�,��n����m,����������n
			return maxCommonDivisor2(n, m % n);
		}
	}

	// ���Լ��
	public static int maxCommonDivisor(int m, int n) {
 
		if (m < n) {// ��֤m>n,��m<n,��������ݽ���
			int temp = m;
			m = n;
			n = temp;
		}
		while (m % n != 0) {// ����������Ϊ0ʱ,����ѭ��
			int temp = m % n;
			m = n;
			n = temp;
		}
		return n;// �������Լ��
	}
	
	// ����С������
	public static int minCommonMultiple(int m, int n) {
		return m * n / maxCommonDivisor(m, n);
	}
}

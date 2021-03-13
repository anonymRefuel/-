package a2015;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 9.������
��ʥatm�����������������ӣ����ǰ�����һ��������һ���ϱߣ���������ŤŤ��Ҫ�ݳɷ����塣
�������ڹ۲죬atm �������ȶ����ӵİ��أ���Щ���ֵ������Żụ���ų⣡
���������淶һ�����ӣ�1 �Ķ����� 4��2 �Ķ����� 5��3 �Ķ����� 6��
������ m �黥������ÿ���е����������ֵ��������һ�����ӾͲ����ȶ����������� atm�����һ���ж����ֲ�ͬ�Ŀ��ܵ������ӷ�ʽ��
���������ӷ�ʽ��ͬ�����ҽ��������ַ�ʽ�ж�Ӧ�߶ȵ����ӵĶ�Ӧ���ֵĳ�����ͬ��
���ڷ��������ܹ��࣬�����ģ 10^9 + 7 �Ľ����
��ҪС���� atm ����������Ŷ��
�������ʽ��
��һ���������� n m
n��ʾ������Ŀ
������ m �У�ÿ���������� a b ����ʾ a �� b ���ܽ�����һ��
�������ʽ��
һ��һ��������ʾ��ģ 10^9 + 7 �Ľ����
���������롹
2 1
1 2
�����������
544
�����ݷ�Χ��
���� 30% �����ݣ�n <= 5
���� 60% �����ݣ�n <= 100
���� 100% �����ݣ�0 < n <= 10^9, m <= 36
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��

����:dp+������+���������
 */
public class a9_03_������_������ {
	//����
	static int[][] matrix = new int[6][6];
	static final int MOD = (int) (Math.pow(10, 9)+7);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); 
		
	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			matrix[i][j]=1;
		}
	}
	
		for (int i = 0; i <m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			matrix[opp(a)-1][b-1] = 0;
			matrix[opp(b)-1][a-1] = 0;
		}
		
		int[][] ans = new int[6][6];
		int count = 0;
		ans =f1(matrix, n-1);
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j <6; j++) {
				count = (count + ans[i][j]) % MOD;
			}
		}
		System.out.println(count*f2(n));
	}
	
	/**
	 * 
	 * @param m ����������ĳ˷�
	 * @return
	 */
	static int[][] f1(int[][] m , int n) {	
		//��ʼ��ansΪ��λ����
		int[][] ans = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				if(i==j) ans[i][j] = 1;
				else     ans[i][j] = 0;
					
			}
		}
		
		while(n != 0) {
			if((n & 1) == 1) ans =matrixMultiply(ans, m);
			m =matrixMultiply(m,m);
			n >>= 1;
			}
		return ans;
	}
	
	static int[][] matrixMultiply(int[][] m,int[][] n) {
		int[][] s = new int[6][6];
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				s[i][j] = 0;
				for (int k = 0; k < 6; k++) {
					s[i][j] =( s[i][j] + m[i][k]*n[k][j]) % MOD;
				}
			}
		}
		return s;
	}
	
	static long f2(int n) {
		//�����ݣ���4��n�η�
		long ans = 1;
		long tmp = 4;
		long   p = n;
		
		while(p != 0) {
			if((p & 1) == 1) ans = (ans * tmp) % MOD;
			tmp = (tmp * tmp) % MOD;
			p >>= 1;
			}
		return ans;
	}
	
	static int opp(int point) {
		switch (point) {
		case 1:return 4;
		case 2:return 5;
		case 3:return 6;
		case 4:return 1;
		case 5:return 2;
		case 6:return 3;
		default:return -1;
		}
	}
}

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
public class a9_02_������_dp {
	//�洢���ֵ���ụ���ų��
	static int dir[]= new int[7];
	static long[][] dp = new long[2][7];
	static long count=0;
	static final int MOD = (int) (Math.pow(10, 9)+7);
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); 
		for (int i = 0; i <m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dir[a] = b;
			dir[b] = a;
		}
		
			for (int i = 1; i <= 6; i++) {
				dp[0][i] = 1;
			}
	
			int cur = 0;
			//��������
			for (int lever = 2; lever <= n; lever++) {
				cur = 1 - cur;
				//���Խ�6������ڵ�ǰһ�㳯�ϵķ���
				for (int i = 1; i <= 6; i++) {
					dp[cur][i] = 0;
					//����op[j]����ͻ����һ�������������ۼ�����
					for (int j = 1; j <= 6; j++) {					
						if (dir[opp(i)] == j) continue;//��ͻ���泯���ǲ���ȡ��
						dp[cur][i] = (dp[cur][i] + dp[1-cur][j]) % MOD;	
						System.out.println(Arrays.deepToString(dp));
					}
				}
				
			}
			
//			long sum = 0;
			for (int k = 1; k <= 6; k++) {
				count = (count + dp[cur][k]) % MOD;
			}
			
			//�����ݣ���4��n�η�
			long ans = 1;
			long tmp = 4;
			long   p = n;
			
			while(p != 0) {
				if((p & 1) == 1) ans = (ans * tmp) % MOD;
				tmp = (tmp * tmp) % MOD;
				p >>= 1;
				}
			
		System.out.println((count*ans) % MOD);
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

package a2014;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 10.���⣺��������
    �۲�������У�
    1 3 0 2 -1 1 -2 ...
    ��������к�һ�����Ǳ�ǰһ������2���߼���3��
    �������������кܺ��棬����֪������Ϊ n ��Ϊ s ���Һ�һ�����Ǳ�ǰһ������a���߼���b���������п����ж������أ�
�����ݸ�ʽ��
    ����ĵ�һ�а����ĸ����� n s a b��������ǰ��˵����
    ���һ�У�����һ����������ʾ���������ķ�����������������ܴ����������������100000007��������
���磬���룺
4 10 2 3
����Ӧ�������
2
������˵����
���������зֱ���2 4 1 3��7 4 1 -2��
�����ݹ�ģ��Լ����
����10%�����ݣ�1<=n<=5��0<=s<=5��1<=a,b<=5��
����30%�����ݣ�1<=n<=30��0<=s<=30��1<=a,b<=30��
����50%�����ݣ�1<=n<=50��0<=s<=50��1<=a,b<=50��
����70%�����ݣ�1<=n<=100��0<=s<=500��1<=a, b<=50��
����100%�����ݣ�1<=n<=1000��-1,000,000,000<=s<=1,000,000,000��1<=a, b<=1,000,000��
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
 */
public class a91_�������� {
	static int a;//��һ�����Ǳ�ǰһ������a
	static int b;//��һ�����Ǳ�ǰһ�����b
	static int s;//��Ϊ s 
	static int n;//����Ϊ n
	static BigInteger counts =BigInteger.ZERO;
	static BigInteger MOD = new BigInteger("" + 100000007);
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	  n  = sc.nextInt();
	  s  = sc.nextInt();
	  a  = sc.nextInt();
	  b  = sc.nextInt();
	  int x1=(s-a*n*(n-1)/2)/n-1;
	  int x2=(s+b*n*(n-1)/2)/n+1;
	for (int x = x1; x<=x2; x++) {
		for (int ta =0; ta <=n*(n-1)/2; ta++) {
			int m = n*x + ta*a-(n*(n-1)/2-ta)*b;
//			System.out.println("x:"+x+"  i:" +ta + "  a:" +a+"  b:"+b +"  m:"+m);
			if (m!=s) continue;   //7 4 1 -2
//			System.out.println(m);//2 4 1 3
			dfs(x, 1, x,0);
		}
	}  
	System.out.println(counts);
}

public static void dfs(int x,int count,int sum,int i) {
	if(count >= n) {
		if (sum == s) {
//			System.out.println("i:"+i);
			counts=counts.add(BigInteger.ONE).mod(MOD);
			}
		return;
	}
	dfs(x+a,count+1,sum+x+a,i+1);
	dfs(x-b,count+1,sum+x-b,i);
}
}

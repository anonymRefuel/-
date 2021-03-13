package a2014;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
/*
 * 9.���⣺쳲�����
    쳲��������д�Ҷ��ǳ���Ϥ�����Ķ����ǣ�
    f(x) = 1                    .... (x=1,2)
    f(x) = f(x-1) + f(x-2)      .... (x>2)
    ���ڸ��������� n �� m������ϣ�������
    f(1) + f(2) + ... + f(n)  ��ֵ�������ֵ���ܷǳ����������ǰ����� f(m) ȡģ��
    ��ʽ�μ���ͼ1.png��
    �����������Ȼ�ܴ�������Ҫ�ٶ� p ��ģ��
�����ݸ�ʽ��
����Ϊһ���ÿո�ֿ������� n m p (0 < n, m, p < 10^18)
���Ϊ1������
���磬������룺
2 3 5
����Ӧ�������
0
�����磬���룺
15 11 29
����Ӧ�������
25
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
 */
public class a9_3_쳲�����_���� {
	public static void main(String[] args) {
		long n,m,p;
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		m = sc.nextLong();
		p = sc.nextLong();
		BigInteger pBig = new BigInteger("" + p);
      if(n+2<m) {
		System.out.println(fun(n+2).subtract(BigInteger.ONE));
      }else {
		System.out.println(fun(n+2).subtract(BigInteger.ONE).mod(fun(m)).mod(pBig));
	}
}
 
	static BigInteger fun(long n) {
		BigInteger[][] a={
				{BigInteger.ZERO,BigInteger.ONE},
				{BigInteger.ONE,BigInteger.ONE}
			};
		BigInteger[][] c = matrixPower(a,n);
		return c[1][0];
	}
	
	static BigInteger[][] matrixPower(BigInteger[][] a,long n){
		BigInteger[][] sum={
				{BigInteger.ONE,BigInteger.ZERO},
				{BigInteger.ZERO,BigInteger.ONE}
			};
		while(n != 0) {
			if((n & 1) == 1) sum =power(sum,a);
			a = power(a, a);
			n>>=1;
		}
		return sum;
	}
	
	static BigInteger[][] power(BigInteger[][] a,BigInteger[][] b){
		BigInteger[][] sum={
				{BigInteger.ZERO,BigInteger.ZERO},
				{BigInteger.ZERO,BigInteger.ZERO}
			};
		sum[0][0]=(a[0][0].multiply(b[0][0])).add(a[0][1].multiply(b[1][0]));
		sum[0][1]=(a[0][0].multiply(b[0][1])).add(a[0][1].multiply(b[1][1]));
		sum[1][0]=(a[1][0].multiply(b[0][0])).add(a[1][1].multiply(b[1][0]));
		sum[1][1]=(a[1][0].multiply(b[0][1])).add(a[1][1].multiply(b[1][1]));
		return sum;
	}
}

package a2014;

import java.math.BigInteger;
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

��f(n)=f(n+2)-1
�����õ���
��ģ�ܴ����ݺܴ�
����쳲�����<--��������<--���پ��������㣨lognʱ�临�Ӷȣ�
mod���뵽����˷��У�ÿ�γ˺�ÿ�μӣ����Խ������ģ����->��������LL�ķ�Χ��
�������ٳ˷������ڳ˷��м���ģ����
 */
public class a9_2_쳲�����_�Ż��� {
//	  f(x) = f(x-1) + f(x-2) 
//->>f(x+1) = f(x) + f(x-1) 
//->>  f(x) =f(x+1)- f(x-1) 
	
//	 f(1) +    f(2)   +   f(3)    +   f(4)    +    f(5)   + ...... +    f(n-1)   +      f(n)
//	   1  + f(3)-f(1) + f(4)-f(2) + f(5)-f(3) + f(6)-f(4) + ...... + f(n)-f(n-2) + f(n+1)-f(n-1)
//	��f(n)=f(n) +    f(n+1)   -1
//	��f(n)=f(n) + f(n+2)-f(n) -1
//	��f(n)=f(n+2)-1
	public static void main(String[] args) {
		long n,m,p;
		Scanner sc = new Scanner(System.in);
		n = sc.nextLong();
		m = sc.nextLong();
		p = sc.nextLong();
		BigInteger pBig = new BigInteger("" + p);
//		BigInteger sum =fun(n+2).subtract(BigInteger.ONE);
//		if(n+2<m) {
//		System.out.println(sum.mod(pBig));
//	}else {
//		System.out.println((sum.mod(fun(m))).mod(pBig));
//	}
		BigInteger sum =fun2(n+2).subtract(BigInteger.ONE);
		if(n+2<m) {
		System.out.println(sum.mod(pBig));
	}else {
		System.out.println((sum.mod(fun2(m))).mod(pBig));
	}
		System.out.println(fun(16));
	}	
	
	public static BigInteger fun(long x) {
		BigInteger sum;
		if(x==1||x==2) {
			 sum =BigInteger.ONE;
			return sum;
		}
		return fun(x-1).add(fun(x-2));
	}
	
	private static BigInteger fun2(long x) {
		 int a = 1;
		 int b = 1;
		 int i = 0;
		 if(x<=2)return BigInteger.ONE;
		 for (i = 0; i < x/2-1; i++)
		 {
		  a = a + b;
		  b = b + a;

		 }
		 if(x%2==1) {
		return BigInteger.valueOf(a+b);
		 }else {
			return BigInteger.valueOf(b);
		}
	}
}

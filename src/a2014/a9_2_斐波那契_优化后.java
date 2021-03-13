package a2014;

import java.math.BigInteger;
import java.util.Scanner;

/*
 * 9.标题：斐波那契
    斐波那契数列大家都非常熟悉。它的定义是：
    f(x) = 1                    .... (x=1,2)
    f(x) = f(x-1) + f(x-2)      .... (x>2)
    对于给定的整数 n 和 m，我们希望求出：
    f(1) + f(2) + ... + f(n)  的值。但这个值可能非常大，所以我们把它对 f(m) 取模。
    公式参见【图1.png】
    但这个数字依然很大，所以需要再对 p 求模。
【数据格式】
输入为一行用空格分开的整数 n m p (0 < n, m, p < 10^18)
输出为1个整数
例如，如果输入：
2 3 5
程序应该输出：
0
再例如，输入：
15 11 29
程序应该输出：
25
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。

Σf(n)=f(n+2)-1
尽量用迭代
规模很大，数据很大
快速斐波那契<--矩阵运算<--快速矩阵幂运算（logn时间复杂度）
mod带入到矩阵乘法中，每次乘和每次加，都对结果进行模运算->运算数在LL的范围内
整数快速乘法，并在乘法中加入模运算
 */
public class a9_2_斐波那契_优化后 {
//	  f(x) = f(x-1) + f(x-2) 
//->>f(x+1) = f(x) + f(x-1) 
//->>  f(x) =f(x+1)- f(x-1) 
	
//	 f(1) +    f(2)   +   f(3)    +   f(4)    +    f(5)   + ...... +    f(n-1)   +      f(n)
//	   1  + f(3)-f(1) + f(4)-f(2) + f(5)-f(3) + f(6)-f(4) + ...... + f(n)-f(n-2) + f(n+1)-f(n-1)
//	Σf(n)=f(n) +    f(n+1)   -1
//	Σf(n)=f(n) + f(n+2)-f(n) -1
//	Σf(n)=f(n+2)-1
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

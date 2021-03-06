package a2014;

import java.math.BigInteger;
import java.util.Arrays;
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
 */
public class a9_3_斐波那契_矩阵 {
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

package a2015;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 9.垒骰子
赌圣atm晚年迷恋上了垒骰子，就是把骰子一个垒在另一个上边，不能歪歪扭扭，要垒成方柱体。
经过长期观察，atm 发现了稳定骰子的奥秘：有些数字的面贴着会互相排斥！
我们先来规范一下骰子：1 的对面是 4，2 的对面是 5，3 的对面是 6。
假设有 m 组互斥现象，每组中的那两个数字的面紧贴在一起，骰子就不能稳定的垒起来。 atm想计算一下有多少种不同的可能的垒骰子方式。
两种垒骰子方式相同，当且仅当这两种方式中对应高度的骰子的对应数字的朝向都相同。
由于方案数可能过多，请输出模 10^9 + 7 的结果。
不要小看了 atm 的骰子数量哦～
「输入格式」
第一行两个整数 n m
n表示骰子数目
接下来 m 行，每行两个整数 a b ，表示 a 和 b 不能紧贴在一起。
「输出格式」
一行一个数，表示答案模 10^9 + 7 的结果。
「样例输入」
2 1
1 2
「样例输出」
544
「数据范围」
对于 30% 的数据：n <= 5
对于 60% 的数据：n <= 100
对于 100% 的数据：0 < n <= 10^9, m <= 36
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 2000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。

考点:dp+快速幂+矩阵快速幂
 */
public class a9_03_垒骰子_快速幂 {
	//矩阵
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
	 * @param m 求两个矩阵的乘法
	 * @return
	 */
	static int[][] f1(int[][] m , int n) {	
		//初始化ans为单位矩阵
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
		//快速幂，求4的n次方
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

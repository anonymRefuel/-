package a2016;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 9.交换瓶子
有N个瓶子，编号 1 ~ N，放在架子上。
比如有5个瓶子：
2 1 3 5 4
要求每次拿起2个瓶子，交换它们的位置。
经过若干次后，使得瓶子的序号为：
1 2 3 4 5
对于这么简单的情况，显然，至少需要交换2次就可以复位。
如果瓶子更多呢？你可以通过编程来解决。
输入格式为两行：
第一行: 一个正整数N（N<10000）, 表示瓶子的数目
第二行：N个正整数，用空格分开，表示瓶子目前的排列情况。
输出数据为一行一个正整数，表示至少交换多少次，才能完成排序。
例如，输入：
5
3 1 2 5 4
程序应该输出：
3
再例如，输入：
5
5 4 3 2 1
程序应该输出：
2
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。

贪心，复杂度O(n^2),1w的数据还凑合把
 */
public class a9_交换瓶子 {
	
	static int N;
	static int[] arr;
	static int ans =0;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	  N = sc.nextInt();
	  arr = new int[N+1];
	  for (int i = 1; i < N+1; i++) {
		  arr[i] = sc.nextInt();
	}
	  fun(arr);
	System.out.println(ans);
}
/**
 * 
 * @param arr 数组
 * @param n	  交换的次数
 * @param k  当前位置与其他位置交换
 */
static void fun(int[] arr) {
	System.out.println(Arrays.toString(arr));
  for (int i = 1; i < arr.length; i++) {
	if(arr[i]!=i) {
		int a,b;
		a=arr[i];
		b=arr[arr[i]];	
		arr[arr[i]] =a;	
		arr[i] =b;	
		System.out.println(Arrays.toString(arr));
		ans++;
	}
  }
}

}

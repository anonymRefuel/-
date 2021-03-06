package a2013;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 8.标题：带分数
    100 可以表示为带分数的形式：100 = 3 + 69258 / 714
    还可以表示为：100 = 82 + 3546 / 197
    注意特征：带分数中，数字1~9分别出现且只出现一次（不包含0）。
    类似这样的带分数，100 有 11 种表示法。
题目要求：
从标准输入读入一个正整数N (N<1000*1000)
程序输出该数字用数码1~9不重复不遗漏地组成带分数表示的全部种数。
注意：不要求输出每个表示，只统计有多少表示法！
例如：
用户输入：
100
程序输出：
11
再例如：
用户输入：
105
程序输出：
6
资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 3000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class a8_带分数 {
	
public static int N=0;
public static int sum=0;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
     N = sc.nextInt();
	int[] arr = {1,2,3,4,5,6,7,8,9};
	fun(arr,0);
	System.out.println(sum);
}
/**
 * 求全排列方法一
 * @param arr
 * @param k
 */
public static void fun(int[] arr , int k) {
	if(k == arr.length) {
		check(arr);
//		System.out.println(Arrays.toString(arr));
	}
	for (int i = k; i < arr.length; i++) {
		int t = arr[i];
		arr[i] = arr[k];
		arr[k] = t;
		
		fun(arr, k+1);
		
		t = arr[i];
		arr[i] = arr[k];
		arr[k] = t;
	}
}
public static void fun2(int[] vis , int k) {
	
}
public static void check(int[] arr) {
	//i、j表示截取的长度
	for (int i = 1; i < arr.length-1; i++) { //至少需要留一个除号位置
		int a1 = toInt(arr,0,i);
		if(a1>N)continue;
		for (int j = 1; j < arr.length-i-1; j++) {
			int a2 = toInt(arr, i, j);
			int a3 = toInt(arr, i+j,arr.length-i-j);
			if(a2%a3==0 && a1+ (a2/a3)== N)sum++;
		}
	}
}

private static int toInt(int[] arr,int begin,int length) {
	int a=0;
	int b=1;
	int lastindex=begin+length-1;
	for (int i =lastindex; i >= begin; i--) {
		a+=arr[i]*b;
		b*=10;
	}
	return a;
}
}

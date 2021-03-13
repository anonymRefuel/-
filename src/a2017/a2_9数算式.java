package a2017;

import java.util.HashSet;

/*
2.标题：9数算式
观察如下的算式：
9213 x 85674 = 789314562
左边的乘数和被乘数正好用到了1~9的所有数字，每个1次。
而乘积恰好也是用到了1~9的所有数字，并且每个1次。
请你借助计算机的强大计算能力，找出满足如上要求的9数算式一共有多少个？
注意：
1. 总数目包含题目给出的那个示例。
2. 乘数和被乘数交换后作为同一方案来看待。

答案:1625,全排+枚举乘号位置+哈希查重
 */
public class a2_9数算式 {
	static int count=0;
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7,8,9};
	fullArray(arr,0);
	//，由于乘数与被乘数不会相等，所以总个数=count/2
	System.out.println(count/2);
}

/**
 * 求全排列
 * @param arr  初始数组
 * @param i	   当前需要交换的元素的下标
 */
public static void fullArray(int[] arr,int i) {
	if (i==arr.length) {
		fun(arr);
		return;
	}
	for (int j = i; j < arr.length; j++) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		fullArray(arr, i+1);
		
		temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

/**
 * 求满足要求的算式的个数（未去重）
 * @param arr 全排列的数组
 */
public static void fun(int[] arr) {
//	System.out.println(java.util.Arrays.toString(arr));
	String s1="";
	String s2="";
	for (int i = 0; i < arr.length-1; i++) {
		s1 = s1+arr[i];
		for (int j = i+1; j <arr.length; j++) {
			s2=s2+arr[j];
		}
		
//		System.out.println("s1:"+s1+"    s2:"+s2);
		int a1=Integer.parseInt(s1);
		int a2=Integer.parseInt(s2);
		s2="";										//将s2字符串清空，然后再移动s1的结束位置下标
		long sum=a1*a2;
		if (Math.ceil(Math.log10(sum))!=9) {
			continue;
		}
		String sum2=""+sum;
		HashSet<Character> sum3=new HashSet<Character>();
		for (int k = 0; k < sum2.length(); k++) {
			if(sum2.charAt(k)!='0')sum3.add(sum2.charAt(k));
		}
		if (sum3.size()==9) {
			count++;
			System.out.println(a1+"*"+a2+"="+sum);
		}
	}
}
}

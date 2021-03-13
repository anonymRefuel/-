package a2015;

import java.util.Arrays;

/*
 * 3.九数分三组
1~9的数字可以组成3个3位数，设为：A,B,C,  现在要求满足如下关系：
B = 2 * A
C = 3 * A
请你写出A的所有可能答案，数字间用空格分开，数字按升序排列。
注意：只提交A的值，严格按照格式要求输出。

答案:192 219 273 327,写个全排
 */
public class a3_九数分三组 {
public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6,7,8,9};
	fun(arr,0);
}
public static void fun(int[] arr,int i) {
	if(i==arr.length) {
		fun2(arr);
		return;
		}
	for (int j = i; j < arr.length; j++) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
		
		fun(arr, i+1);
		
		temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
}

public static void fun2(int[] arr) {
	String a1="" +arr[0]+arr[1]+arr[2];
	String b1="" +arr[3]+arr[4]+arr[5];
	String c1=""+ arr[6]+arr[7]+arr[8];
//	int a =Integer.valueOf(a1).intValue();
	int a = Integer.parseInt(a1);
	int b = Integer.parseInt(b1);
	int c = Integer.parseInt(c1);
	if(b==a*2&&c==a*3) {
//	System.out.println("a:"+a+ " " + "  b:"+b+"  c:"+c);
	System.out.print(a+" ");
	}
}
}

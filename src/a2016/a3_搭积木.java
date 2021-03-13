package a2016;

import java.util.Arrays;

/*
 * 3.搭积木
小明最近喜欢搭数字积木，
一共有10块积木，每个积木上有一个数字，0~9。
搭积木规则：
每个积木放到其它两个积木的上面，并且一定比下面的两个积木数字小。
最后搭成4层的金字塔形，必须用完所有的积木。
下面是两种合格的搭法：
   0
  1 2
 3 4 5
6 7 8 9

   0
  3 1
 7 5 2
9 8 6 4    
请你计算这样的搭法一共有多少种？
请填表示总数目的数字。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

答案:768,写个全排,把限制条件,变成剪枝,逻辑更清楚
 */
public class a3_搭积木 {
	static int count;
public static void main(String[] args) {
	int[] arr = {0,1,2,3,4,5,6,7,8,9};
	fun(arr,0);
	System.out.println(count);
}

public static void fun(int[] arr,int i) {
	if (i==arr.length) {
		fun2(arr);
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
	if(arr[1]>arr[0]&&arr[2]>arr[0]&&arr[3]>arr[1]&&arr[4]>arr[1]&&arr[4]>arr[2]&&arr[5]>arr[2]) {
		if(arr[6]>arr[3]&&arr[7]>arr[3]&&arr[7]>arr[4]&&arr[8]>arr[4]&&arr[8]>arr[5]&&arr[9]>arr[5])
			count++;
	}
}
}

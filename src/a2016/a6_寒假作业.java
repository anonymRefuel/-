package a2016;
/*
 * 6.寒假作业
现在小学的数学题目也不是那么好玩的。
看看这个寒假作业：
   □ + □ = □
   □ - □ = □
   □ × □ = □
   □ ÷ □ = □ 
   (如果显示不出来，可以参见【图1.jpg】)  
每个方块代表1~13中的某一个数字，但不能重复。
比如：
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
以及： 
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
就算两种解法。（加法，乘法交换律后算不同的方案）
你一共找到了多少种方案？
请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

答案:64,2^13,需要提前剪枝才能跑出答案
 */
public class a6_寒假作业 {
	static int count=0;
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	fun(arr,0);
	System.out.println(count);
}

public static void fun(int[] arr,int i) {
	if (i==arr.length) {
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
	if(arr[0]+arr[1]==arr[2]&&arr[3]-arr[4]==arr[5]&&arr[6]*arr[7]==arr[8]&&arr[9]/arr[10]==arr[11]&&arr[9]%arr[10]==0) {
		System.out.println(arr[0]+"+"+arr[1]+"="+arr[2]+" "+arr[3]+"-"+arr[4]+"="+arr[5]+" "+arr[6]+"*"+arr[7]+"="+arr[8]+" "+arr[9]+"/"+arr[10]+"="+arr[11]);
		count++;
	}
}
}

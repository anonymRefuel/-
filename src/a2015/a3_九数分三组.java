package a2015;

import java.util.Arrays;

/*
 * 3.����������
1~9�����ֿ������3��3λ������Ϊ��A,B,C,  ����Ҫ���������¹�ϵ��
B = 2 * A
C = 3 * A
����д��A�����п��ܴ𰸣����ּ��ÿո�ֿ������ְ��������С�
ע�⣺ֻ�ύA��ֵ���ϸ��ո�ʽҪ�������

��:192 219 273 327,д��ȫ��
 */
public class a3_���������� {
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

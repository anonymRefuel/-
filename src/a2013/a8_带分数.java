package a2013;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 8.���⣺������
    100 ���Ա�ʾΪ����������ʽ��100 = 3 + 69258 / 714
    �����Ա�ʾΪ��100 = 82 + 3546 / 197
    ע���������������У�����1~9�ֱ������ֻ����һ�Σ�������0����
    ���������Ĵ�������100 �� 11 �ֱ�ʾ����
��ĿҪ��
�ӱ�׼�������һ��������N (N<1000*1000)
�������������������1~9���ظ�����©����ɴ�������ʾ��ȫ��������
ע�⣺��Ҫ�����ÿ����ʾ��ֻͳ���ж��ٱ�ʾ����
���磺
�û����룺
100
���������
11
�����磺
�û����룺
105
���������
6
��ԴԼ����
��ֵ�ڴ����ģ���������� < 64M
CPU����  < 3000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.6�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
 */
public class a8_������ {
	
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
 * ��ȫ���з���һ
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
	//i��j��ʾ��ȡ�ĳ���
	for (int i = 1; i < arr.length-1; i++) { //������Ҫ��һ������λ��
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

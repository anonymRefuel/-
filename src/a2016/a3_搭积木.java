package a2016;

import java.util.Arrays;

/*
 * 3.���ľ
С�����ϲ�������ֻ�ľ��
һ����10���ľ��ÿ����ľ����һ�����֣�0~9��
���ľ����
ÿ����ľ�ŵ�����������ľ�����棬����һ���������������ľ����С��
�����4��Ľ������Σ������������еĻ�ľ��
���������ֺϸ�Ĵ��
   0
  1 2
 3 4 5
6 7 8 9

   0
  3 1
 7 5 2
9 8 6 4    
������������Ĵһ���ж����֣�
�����ʾ����Ŀ�����֡�
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�

��:768,д��ȫ��,����������,��ɼ�֦,�߼������
 */
public class a3_���ľ {
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

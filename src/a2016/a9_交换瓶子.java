package a2016;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 9.����ƿ��
��N��ƿ�ӣ���� 1 ~ N�����ڼ����ϡ�
������5��ƿ�ӣ�
2 1 3 5 4
Ҫ��ÿ������2��ƿ�ӣ��������ǵ�λ�á�
�������ɴκ�ʹ��ƿ�ӵ����Ϊ��
1 2 3 4 5
������ô�򵥵��������Ȼ��������Ҫ����2�ξͿ��Ը�λ��
���ƿ�Ӹ����أ������ͨ������������
�����ʽΪ���У�
��һ��: һ��������N��N<10000��, ��ʾƿ�ӵ���Ŀ
�ڶ��У�N�����������ÿո�ֿ�����ʾƿ��Ŀǰ�����������
�������Ϊһ��һ������������ʾ���ٽ������ٴΣ������������
���磬���룺
5
3 1 2 5 4
����Ӧ�������
3
�����磬���룺
5
5 4 3 2 1
����Ӧ�������
2
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��

̰�ģ����Ӷ�O(n^2),1w�����ݻ��պϰ�
 */
public class a9_����ƿ�� {
	
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
 * @param arr ����
 * @param n	  �����Ĵ���
 * @param k  ��ǰλ��������λ�ý���
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

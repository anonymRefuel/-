package a2017;

import java.util.HashSet;

/*
2.���⣺9����ʽ
�۲����µ���ʽ��
9213 x 85674 = 789314562
��ߵĳ����ͱ����������õ���1~9���������֣�ÿ��1�Ρ�
���˻�ǡ��Ҳ���õ���1~9���������֣�����ÿ��1�Ρ�
��������������ǿ������������ҳ���������Ҫ���9����ʽһ���ж��ٸ���
ע�⣺
1. ����Ŀ������Ŀ�������Ǹ�ʾ����
2. �����ͱ�������������Ϊͬһ������������

��:1625,ȫ��+ö�ٳ˺�λ��+��ϣ����
 */
public class a2_9����ʽ {
	static int count=0;
public static void main(String[] args) {
	int[] arr = {1,2,3,4,5,6,7,8,9};
	fullArray(arr,0);
	//�����ڳ����뱻����������ȣ������ܸ���=count/2
	System.out.println(count/2);
}

/**
 * ��ȫ����
 * @param arr  ��ʼ����
 * @param i	   ��ǰ��Ҫ������Ԫ�ص��±�
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
 * ������Ҫ�����ʽ�ĸ�����δȥ�أ�
 * @param arr ȫ���е�����
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
		s2="";										//��s2�ַ�����գ�Ȼ�����ƶ�s1�Ľ���λ���±�
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

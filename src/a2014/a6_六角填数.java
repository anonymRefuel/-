package a2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *    ��ͼ��1.png����ʾ�������У�����1~12�����֡�
    ʹ��ÿ��ֱ���ϵ�����֮�Ͷ���ͬ��
    ͼ�У��Ѿ����������3�����֣���������Ǻ�λ��������������Ƕ��٣�
��ͨ��������ύ�𰸣���Ҫ��д��������ݡ�

���뵱�����е��������ģ���������Ҳ̫���ˣ����ϸ�����ȫ�Ű�
����Ҫ�����Ǳ��,���ϵ������Ұѣ��������ң����˾�ͷ����
ע�⣬����д��ȫ�ź�����ʼ��һ��Ҫ��˳�򣬲�Ȼȫ�Ÿ����Ͳ���n����
���Դӵ�һ����ʼ�ݹ飬�ȱ�̶���Ŀ����1��8��3
��������Ϊif����
 */
public class a6_�������� {
	
	static List<Integer[]> list;
	static int m=0;
public static void main(String[] args) {
	int arr[] = {2,4,5,6,7,9,10,11,12};
	list = new ArrayList<Integer[]>();
	fun(arr,0);
	for (int i = 0; i < list.size(); i++) {
		Integer[] temp = list.get(i);
		int sum = 8 + temp[1] + temp[2] + temp[3];
		if (8+temp[4] + temp[7] +3 != sum) continue;
		if(temp[3] + temp[5] + temp[8]+3!=sum) continue;
		if(1+temp[1]+temp[4]+temp[6]!=sum)continue;
		if(1+temp[2]+temp[5]+temp[9]!=sum)continue;
		if(temp[6]+temp[7]+temp[8]+temp[9]!=sum)continue;
		System.out.println(Arrays.toString(temp));
	}
}

public static void fun(int[] arr,int i) {
	if(i==arr.length) {
		Integer[] array =new Integer[arr.length+1];
		for (int j = 0; j < arr.length; j++) {
			array[j+1]=arr[j];
		}
		list.add(array);
		}
	
	for (int j = i; j < arr.length; j++) {
		int temp =arr[i];
		arr[i] = arr[j] ;
		arr[j] = temp;
		fun(arr, i+1);
		temp = arr[i];
		arr[i] = arr[j] ;
		arr[j] = temp;
	}
}
//10
}

package a2016;
/*
 * 6.������ҵ
����Сѧ����ѧ��ĿҲ������ô����ġ�
�������������ҵ��
   �� + �� = ��
   �� - �� = ��
   �� �� �� = ��
   �� �� �� = �� 
   (�����ʾ�����������Բμ���ͼ1.jpg��)  
ÿ���������1~13�е�ĳһ�����֣��������ظ���
���磺
 6  + 7 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
�Լ��� 
 7  + 6 = 13
 9  - 8 = 1
 3  * 4 = 12
 10 / 2 = 5
�������ֽⷨ�����ӷ����˷������ɺ��㲻ͬ�ķ�����
��һ���ҵ��˶����ַ�����
����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�

��:64,2^13,��Ҫ��ǰ��֦�����ܳ���
 */
public class a6_������ҵ {
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

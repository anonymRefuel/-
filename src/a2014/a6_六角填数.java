package a2014;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *    如图【1.png】所示六角形中，填入1~12的数字。
    使得每条直线上的数字之和都相同。
    图中，已经替你填好了3个数字，请你计算星号位置所代表的数字是多少？
请通过浏览器提交答案，不要填写多余的内容。

还想当生活中的数独做的，不过给的也太少了，先上个暴力全排把
首先要给他们编号,从上到下左到右把，不容易乱，乱了就头疼了
注意，这样写的全排函数初始化一定要有顺序，不然全排个数就不是n！，
所以从第一个开始递归，先别固定题目给的1，8，3
把他们作为if条件
 */
public class a6_六角填数 {
	
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

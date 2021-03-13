package a2016;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * �硾ͼ1.jpg��, ��12������һ���12��Ф����Ʊ��
������Ҫ���м���5������Ҫ����������ŵġ�
����������һ���ǲ���������
���磬��ͼ2.jpg������ͼ3.jpg���У��ۺ�ɫ��ʾ���־��Ǻϸ�ļ�ȡ��

������㣬һ���ж����ֲ�ͬ�ļ�ȡ������

����д��ʾ������Ŀ��������
ע�⣺���ύ��Ӧ����һ����������Ҫ��д�κζ�������ݻ�˵�������֡�

��:116������+��ͨ�飬ȫ��+set����Ӧ��Ҳ�У������ܸ��ӣ�����Ѷ�άתΪһά�����ڴ���
 */
public class a7_����Ʊ {
	static int[] g = {0,0,0,0,0,0,0,1,1,1,1,1};
	static int ans=0;
	static Set<String> set = new HashSet<>();
public static void main(String[] args) {
	f(g,1);
//	set.forEach((e)->System.out.println(e));
//	for (String s : set) {
//		System.out.println(s);
//	}
//	set.forEach(System.out::println);
//	System.out.println(set.size());
	for (String s : set) {
		char[] a=s.toCharArray();
		int[]  b = new int[s.length()];
		for (int i = 0; i < b.length; i++) {
			b[i] = Integer.parseInt(""+a[i]);
		}
		int[][] c = new int[3][4];
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 4; l++) {
				if(b[k*4+l]==1)c[k][l]=1;		
			}
		}
		
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 4; l++) {
				if(c[k][l]==1) {
					dfs(c, k, l);
					ans++;
				}
			}
		}
	}
	System.out.println(ans);
}

static void f(int[] arr,int i) {
	if(i==arr.length) {
		String s = "";
		for (int j = 0; j < arr.length; j++) {
			s+=arr[j];
		}
		System.out.println(Arrays.toString(arr));
		set.add(s);
		ans++;
	}
	for (int j = i; j < arr.length; j++) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
		f(arr, i+1);
		
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}

static void dfs(int[][] g,int i,int j) {
	g[i][j]=0;
	if(i+1<=2 && g[i+1][j]==1)dfs(g, i+1, j);
	if(i-1>=0 && g[i-1][j]==1)dfs(g, i-1, j);
	if(j+1<=3 && g[i][j+1]==1)dfs(g, i, j+1);
	if(j-1>=0 && g[i][j-1]==1)dfs(g, i, j-1);
}
}

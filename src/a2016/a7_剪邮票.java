package a2016;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 如【图1.jpg】, 有12张连在一起的12生肖的邮票。
现在你要从中剪下5张来，要求必须是连着的。
（仅仅连接一个角不算相连）
比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。

请你计算，一共有多少种不同的剪取方法。

请填写表示方案数目的整数。
注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。

答案:116，搜索+联通块，全排+set查重应该也行，不过很复杂，这里把二维转为一维，便于处理
 */
public class a7_剪邮票 {
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

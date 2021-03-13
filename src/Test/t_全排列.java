package Test;

import java.util.Arrays;

public class t_È«ÅÅÁÐ {
	static int[] a = {1,1,3,4,5};
	static int m =1;
	static boolean[] vis = new boolean[a.length];
public static void main(String[] args) {
	int[] path = new int[a.length];
	for (boolean i : vis) {
		i=false;
	}
	Arrays.sort(a);
	fun(0,path);
}

static void fun(int i,int[] path) {
	
	if(i==a.length) {
		System.out.println(Arrays.toString(path));
	}
	
	for (int j = 0; j < a.length; j++) {
		if(j>0 && a[j] == a[j-1] && !vis[j-1]) continue;
		if(!vis[j]) {
		vis[j] = true;
		path[i] = a[j];
		fun(i+1, path);
		//»ØËÝ
		vis[j] = false;
		}
	}
}
}

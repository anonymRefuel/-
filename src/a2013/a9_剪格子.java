package a2013;

import java.util.Scanner;

/*
 * 9.标题：剪格子
    如图p1.jpg所示，3 x 3 的格子中填写了一些整数。
    我们沿着图中的红色线剪开，得到两个部分，每个部分的数字和都是60。
    本题的要求就是请你编程判定：对给定的m x n 的格子中的整数，是否可以分割为两个部分，使得这两个区域的数字和相等。
    如果存在多种解答，请输出包含左上角格子的那个区域包含的格子的最小数目。   
    如果无法分割，则输出 0
程序输入输出格式要求：
程序先读入两个整数 m n 用空格分割 (m,n<10)
表示表格的宽度和高度
接下来是n行，每行m个正整数，用空格分开。每个整数不大于10000
程序输出：在所有解中，包含左上角的分割区可能包含的最小的格子数目。
例如：
用户输入：
3 3
10 1 52
20 30 1
1 2 3
则程序输出：
3
再例如：
用户输入：
4 3
1 1 1 1
1 30 80 2
1 1 1 100
则程序输出：
10
(参见p2.jpg)
资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 5000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class a9_剪格子 {
	public static int[][] g;//矩阵
	public static int[][] tag;//标记以访问
	public static int m;//列数
	public static int n;//行数
	public static int tatal;//总数
	public static int ans = Integer.MAX_VALUE;
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	m = sc.nextInt();
	n = sc.nextInt();
	g = new int[n][m];
	tag = new int[n][m];
	for (int i = 0; i < n; i++) {
		for (int j = 0; j <m; j++) {
			g[i][j] = sc.nextInt();
			 tatal += g[i][j];
		}
	}
	dfs(0, 0, 0, 0);
	System.out.println(ans);
	
}

public static void dfs(int i,int j,int steps,int sum) {//应先判断sum是否等于tatal/2，再判断将要走的位置是否走得通
	if(sum == tatal/2) {
		ans = Math.min(ans, steps);
		return;}
	
	if(sum > tatal/2||steps>ans)return;
	
	if(i<0 || i==n || j<0 || j==m || tag[i][j]==1) return;//走出边界或以访问
	
	tag[i][j] = 1;
	dfs(i-1, j, steps + 1, sum + g[i][j]);//上移
	dfs(i+1, j, steps + 1, sum + g[i][j]);//下移
	dfs(i, j-1, steps + 1, sum + g[i][j]);//左移
	dfs(i, j+1, steps + 1, sum + g[i][j]);//右移
	tag[i][j]=0;
}
}

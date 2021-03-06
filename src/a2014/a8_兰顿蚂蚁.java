package a2014;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 8.标题：兰顿蚂蚁
    兰顿蚂蚁，是于1986年，由克里斯·兰顿提出来的，属于细胞自动机的一种。
    平面上的正方形格子被填上黑色或白色。在其中一格正方形内有一只“蚂蚁”。
    蚂蚁的头部朝向为：上下左右其中一方。
    蚂蚁的移动规则十分简单：
    若蚂蚁在黑格，右转90度，将该格改为白格，并向前移一格；
    若蚂蚁在白格，左转90度，将该格改为黑格，并向前移一格。
    规则虽然简单，蚂蚁的行为却十分复杂。刚刚开始时留下的路线都会有接近对称，像是会重复，
    但不论起始状态如何，蚂蚁经过漫长的混乱活动后，会开辟出一条规则的“高速公路”。
    蚂蚁的路线是很难事先预测的。
    你的任务是根据初始状态，用计算机模拟兰顿蚂蚁在第n步行走后所处的位置。
【数据格式】
输入数据的第一行是 m n 两个整数（3 < m, n < 100），表示正方形格子的行数和列数。
接下来是 m 行数据。
每行数据为 n 个被空格分开的数字。0 表示白格，1 表示黑格。
接下来是一行数据：x y s k, 其中x y为整数，表示蚂蚁所在行号和列号（行号从上到下增长，列号从左到右增长，都是从0开始编号）。
s 是一个大写字母，表示蚂蚁头的朝向，我们约定：上下左右分别用：UDLR表示。k 表示蚂蚁走的步数。
输出数据为两个空格分开的整数 p q, 分别表示蚂蚁在k步后，所处格子的行号和列号。
例如, 输入：
5 6
0 0 0 0 0 0
0 0 0 0 0 0
0 0 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
2 3 L 5
程序应该输出：
1 3

再例如, 输入：
3 3
0 0 0
1 1 1
1 1 1
1 1 U 6
程序应该输出：
0 0
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class a8_兰顿蚂蚁 {
	static int m,n;		//行和列
	static int x,y;		//蚂蚁坐标
	static int k;		//蚂蚁还需要走的步数
	static short[][] arr;
	//d==1表示向上
	//d==2表示向右
	//d==3表示向下
	//d==4表示向左
	static int d;       //当前坐标下标
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new short[m][n];
		
		for (int i = 0; i <m; i++) {
			for (int j = 0; j <n; j++) {
				arr[i][j]=sc.nextShort();
			}
		}
		
		x= sc.nextInt();
		y = sc.nextInt();
		String s=sc.next(); //蚂蚁起始坐标
		k =sc.nextInt();
		if(s.contains("U"))d=1;
		if(s.contains("D"))d=3;	
		if(s.contains("L"))d=4;
		if(s.contains("R"))d=2;
//		System.out.println(Arrays.deepToString(arr));
//		System.out.println(x + "  " + y + " " + s + " " + k);
		fun(x, y, k);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
	}
	
	private static void fun(int x,int y,int k) {
		if (k==0) {
			System.out.println(x + " " +y);
			return;
		}
		if(arr[x][y]==0) {
			d=(d-1+4)%4;
			if(d ==0)d=4;
			arr[x][y]=1;
		}else {
			d=(d+1)%4;
			if (d==0) d=4;
			arr[x][y]=0;
		}
//		System.out.println(x + "  " + y + " " + d + " " + k);
		
		//d==1表示向上
		//d==2表示向右
		//d==3表示向下
		//d==4表示向左
		if(d==1)fun(x-1, y, --k);
		if(d==2)fun(x, y+1, --k);
		if(d==3)fun(x+1, y, --k);
		if(d==4)fun(x, y-1, --k);
	}
}

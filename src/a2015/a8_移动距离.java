package a2015;

import java.util.Scanner;
import static java.lang.Math.*;
/*
 * 8.移动距离
X星球居民小区的楼房全是一样的，并且按矩阵样式排列。其楼房的编号为1,2,3...
当排满一行时，从下一行相邻的楼往反方向排号。
比如：当小区排号宽度为6时，开始情形如下：
1  2  3  4  5  6
12 11 10 9  8  7
13 14 15 .....
我们的问题是：已知了两个楼号m和n，需要求出它们之间的最短移动距离（不能斜线方向移动）
输入为3个整数w m n，空格分开，都在1到10000范围内
w为排号宽度，m,n为待计算的楼号。
要求输出一个整数，表示m n 两楼间最短移动距离。
例如：
用户输入：
6 8 2
则，程序应该输出：
4
再例如：
用户输入：
4 7 20
则，程序应该输出：
5
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。

10000的数据规模模拟肯定是不行的，
所以这题需要推导出数学公式，很好想到除w得到行的值，
求模得列的值，如果他们行的差是奇数那么其他一个列的值就需要反转了，
最后求一下曼哈顿距离
 */
public class a8_移动距离 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int w = sc.nextInt();
	int m = sc.nextInt();
	int n = sc.nextInt();
	int m1=(int)m%w;
	int n1=(int)n%w;
	int row =(int) abs(ceil((double)m/w)-ceil((double)n/w));
	if(ceil((double)m/w)%2==0)m1=w-(m%w)+1;
	if(ceil((double)n/w)%2==0)n1=w-(n%w)+1;
	int column=abs(m1-n1);
	if(m1==0)m1=w;
	if(n1==0)n1=w;
	System.out.println(row+column);
}
}

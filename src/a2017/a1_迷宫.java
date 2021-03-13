package a2017;
/*
 * 1.标题：迷宫
X星球的一处迷宫游乐场建在某个小山坡上。
它是由10x10相互连通的小房间组成的。

房间的地板上写着一个很大的字母。
我们假设玩家是面朝上坡的方向站立，则：
L表示走到左边的房间，
R表示走到右边的房间，
U表示走到上坡方向的房间，
D表示走到下坡方向的房间。

X星球的居民有点懒，不愿意费力思考。
他们更喜欢玩运气类的游戏。这个游戏也是如此！

开始的时候，直升机把100名玩家放入一个个小房间内。
玩家一定要按照地上的字母移动。

迷宫地图如下：
------------
UDDLUULRUL
UURLLLRRRU
RRUURLDLRD
RUDDDDUUUU
URUDLLRRUU
DURLRLDLRL
ULLURLLRDU
RDLULLRDDD
UUDDUDUDLL
ULRDLUURRR
------------

请你计算一下，最后，有多少玩家会走出迷宫? 
而不是在里边兜圈子。

请提交该整数，表示走出迷宫的玩家数目，不要填写任何多余的内容。

如果你还没明白游戏规则，可以参看一个简化的4x4迷宫的解说图：
p1.png

“把100名玩家放入一个个小房间内”意思就是每个格子有一个玩家，不然不仔细看题还不知道玩家在哪儿呢qaq
这题很简单，就是对每一个格子作一次搜索，能在有效次数内走去迷宫的就++，因为不在有效次数内说明有循环嘛，
当然也可以vis[][]数组标记下重复路径(大材小用),或者换成递归写法传入父亲的坐标（上一个节点）,这里用的是迭代，答案:31
相似题:[蓝桥杯][2014年第五届真题]兰顿蚂蚁
 */
public class a1_迷宫 {
	static String[] s= new String[10];
	static boolean[][] tag;
	static int count=0;
public static void main(String[] args) {
	s[0]="UDDLUULRUL";
	s[1]="UURLLLRRRU";
	s[2]="RRUURLDLRD";
	s[3]="RUDDDDUUUU";
	s[4]="URUDLLRRUU";
	s[5]="DURLRLDLRL";
	s[6]="ULLURLLRDU";
	s[7]="RDLULLRDDD";
	s[8]="UUDDUDUDLL";
	s[9]="ULRDLUURRR";
	for (int i = 0; i <s.length; i++) {
		for (int j = 0; j <s[1].length(); j++) {
			tag=new boolean[10][10];
			dfs(i,j,tag);
		}
	}
	System.out.println(count);
}
/*
L表示走到左边的房间，
R表示走到右边的房间，
U表示走到上坡方向的房间，
D表示走到下坡方向的房间。
 */
public static void dfs(int i,int j,boolean[][] tag) {
	if(i<0||i>9||j<0||j>9) {
		count++;
		return;
		}
	if(tag[i][j]) return;
	tag[i][j]=true;
	switch (s[i].charAt(j)) {
	case 'U':dfs(i-1, j, tag);break;
	case 'D':dfs(i+1, j, tag);break;
	case 'L':dfs(i, j-1, tag);break;
	case 'R':dfs(i, j+1, tag);break;
	}
}
}

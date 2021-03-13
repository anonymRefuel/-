package a2013;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 10.标题：大臣的旅费
    很久以前，T王国空前繁荣。为了更好地管理国家，王国修建了大量的快速路，用于连接首都和王国内的各大城市。
    为节省经费，T国的大臣们经过思考，制定了一套优秀的修建方案，使得任何一个大城市都能从首都直接或者通过其他大城市间接到达。
    同时，如果不重复经过大城市，从首都到达每个大城市的方案都是唯一的。
  J是T国重要大臣，他巡查于各大城市之间，体察民情。所以，从一个城市马不停蹄地到另一个城市成了J最常做的事情。
    他有一个钱袋，用于存放往来城市间的路费。
    聪明的J发现，如果不在某个城市停下来修整，在连续行进过程中，他所花的路费与他已走过的距离有关，
    在走第x千米到第x+1千米这一千米中（x是整数），他花费的路费是x+10这么多。
    也就是说走1千米花费11，走2千米要花费23。
  J大臣想知道：他从某一个城市出发，中间不休息，到达另一个城市，所有可能花费的路费中最多是多少呢？
输入格式：
输入的第一行包含一个整数n，表示包括首都在内的T王国的城市数
城市从1开始依次编号，1号城市为首都。
接下来n-1行，描述T国的高速路（T国的高速路一定是n-1条）
每行三个整数Pi, Qi, Di，表示城市Pi和城市Qi之间有一条高速路，长度为Di千米。
输出格式:
输出一个整数，表示大臣J最多花费的路费是多少。
样例输入:
5
1 2 2
1 3 1
2 4 5
2 5 4
样例输出:
135
样例说明:
大臣J从城市4到城市5要花费135的路费。
根据资源限制尽可能考虑支持更大的数据规模。
资源约定：
峰值内存消耗（含虚拟机） < 64M
CPU消耗  < 5000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.6及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class a91_大臣的旅费 {
	private static int n;		    //城市的数量
	private static List<node>[] g;  //建立邻接表
	private static int max=-1;      //存储最长路径
	private static int pnt=-1; 		//存储边最长的叶子节点
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	g = new List[n+1];
	for (int i = 1; i <= n; i++) {
		g[i] = new ArrayList<node>();
	}
	for (int i = 0; i <n-1; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		g[a].add(new node(b,c));
		g[b].add(new node(a,c));
	}
	dfs(1,1,0);
	dfs(pnt, pnt, 0);
	System.out.println(dis2money(max));
}

/**
 * 
 * @param from  从哪个节点来的
 * @param num	当前节点
 * @param dis	Math.max(当前节点到叶子节点的最远距离 ,  max_dis)
 */
private static void dfs(int from,int num, int dis) {
	boolean isLeaf = true;//x先假设是叶子节点
	List<node> neighbors = g[num];
	for (int i = 0; i < neighbors.size(); i++) {
		node neighbor = neighbors.get(i);
		if (neighbor.num == from) continue;
		//没有执行continue表明当前还有子节点
		isLeaf = false;
		dfs(num, neighbor.num, dis+neighbor.dis);
	}
	if(isLeaf&&dis>max) {//如果是叶子节点
		max = dis;
		pnt =num;
	}
	
}

public static int dis2money(int dis) {
	return 11*dis + dis*(dis-1)/2;
	
}

static class node{
	int num;    //存储狐头(即下一个要走的节点)
	int dis;   //存储边的长度
	public node(int num, int dis) {
		this.num = num;
		this.dis = dis;
	}
	
}
}

package a2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.xml.crypto.Data;

/*
 * 10.灾后重建
Pear市一共有N（<=50000）个居民点，居民点之间有M（<=200000）条双向道路相连。
这些居民点两两之间都可以通过双向道路到达。这种情况一直持续到最近，一次严重的地震毁坏了全部M条道路。
震后，Pear打算修复其中一些道路，修理第i条道路需要Pi的时间。
不过，Pear并不打算让全部的点连通，而是选择一些标号特殊的点让他们连通。
Pear有Q（<=50000）次询问，每次询问，他会选择所有编号在[l,r]之间，并且 编号 mod K  = C 的点，
修理一些路使得它们连通。由于所有道路的修理可以同时开工，所以完成修理的时间取决于花费时间最长的一条路，即涉及到的道路中Pi的最大值。
你能帮助Pear计算出每次询问时需要花费的最少时间么？这里询问是独立的，也就是上一个询问里的修理计划并没有付诸行动。
【输入格式】
第一行三个正整数N、M、Q，含义如题面所述。
接下来M行，每行三个正整数Xi、Yi、Pi，表示一条连接Xi和Yi的双向道路，修复需要Pi的时间。可能有自环，可能有重边。1<=Pi<=1000000。
接下来Q行，每行四个正整数Li、Ri、Ki、Ci，表示这次询问的点是[Li,Ri]区间中所有编号Mod Ki=Ci的点。保证参与询问的点至少有两个。
【输出格式】
输出Q行，每行一个正整数表示对应询问的答案。
【样例输入】
7 10 4
1 3 10
2 6 9
4 1 5
3 7 4
3 6 9
1 5 8
2 7 4
3 2 10
1 7 6
7 6 9
1 7 1 0
1 7 3 1
2 5 1 0
3 7 2 1
【样例输出】
9
6
8
8
【数据范围】
对于20%的数据，N,M,Q<=30
对于40%的数据，N,M,Q<=2000
对于100%的数据，N<=50000,M<=2*10^5,Q<=50000. Pi<=10^6. Li,Ri,Ki均在[1,N]范围内，Ci在[0,对应询问的Ki)范围内。
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 5000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
注意：主类的名字必须是：Main，否则按无效代码处理。
最小生成树，并查集
 */
public class a91_灾后重建 {
	static int N,M,Q;
	static Edge[] edges;
	static List<Edge>[] g;
	static int[][] ff;  //ff[i][j]指i号节点往根节点方向走2^j次后达到的节点编号
	static int[] depth;	//节点的深度
	static int[][] mm;	//mm[i][j]指i号节点往根节点方向走2^j次的过程中的最大权重
	static SegTree[] segTrees;
	static int[] data=new int[50001]; //最多50000个节点
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	M = sc.nextInt();
	Q = sc.nextInt();
	edges = new Edge[M];
	g = new ArrayList[N+1];
	
	for (int i = 0; i < N+1; i++) {
		g[i] = new ArrayList<Edge>();
	}
	
	for (int i = 0; i < M; i++) {
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		 edges[i] = new Edge(a, b, c);
	}
	
	buildMST();
	prelca();
	
	int threshold = Math.min(70, N/3);
	segTrees = new SegTree[threshold*(threshold+1)/2 + 1]; //初始化线段树的数组
	int index = 1;
	for (int mod = 1; mod <= threshold; mod++) {
		for (int re = 0; re < mod; re++) {
			//生成原始数据并确定树的左右区间
			int i = 0;
			for (; (i+1)*mod+re <= N; i++) {
				data[i+1] = maxUsingLco(i*mod+re,(i+1)*mod+re);
			}
			segTrees[index++]=buildSegTree(1,i);
		}
	}
	
	for (int i = 0; i < Q; i++) {
		int l = sc.nextInt();
		int r = sc.nextInt();
		int mod = sc.nextInt();
		int c = sc.nextInt();
		if(mod<=threshold) {
			SegTree segTree = segTrees[mod*(mod-1)/2 +1+c];
			int p1;
			if(l<c)p1=1;
			else  p1=((l-c)%mod)==0?((l-c)/mod+1):((l-c)/mod+2);
			int p2=(r-c)/mod;
			int ans = querySegTree(segTree,p1,p2);
			System.out.println(ans);
		}else {
			//当余数大于threshold时，直接用lca来查
			int ans = -1;
			int start = l - l%mod + c;
			if(start<l) start+=mod;
			for (; start+mod<=r; start+=mod) {
				ans=Math.max(ans, maxUsingLco(start, start+mod));
			}
		}
	}
	
}

static int querySegTree(SegTree segTree,int p1,int p2) {
	int l = segTree.l;
	int r = segTree.r;
	if(p1<=l && p2>=r)return segTree.m;
	int mid = (l+r)/2;
	int ans = -1;
	if(p1<=mid) ans=Math.max(ans,querySegTree(segTree.lson, p1, p2));
	if(p2>mid)  ans=Math.max(ans,querySegTree(segTree.rson, p1, p2));
	return ans;
}

/**
 * 
 * @param l  左端点
 * @param r  右端点
 * @return
 */
static SegTree buildSegTree(int l,int r) {
	SegTree segTree = new SegTree(l,r);
	if(l==r) {
		segTree.m =data[l];
		return segTree;
		}
	int mid=(l+r)/2;
	SegTree lson = buildSegTree(l, mid);
	SegTree rson = buildSegTree(mid+1, r);
	segTree.lson = lson;
	segTree.rson = rson;
	segTree.m = Math.max(lson.m, rson.m);
	return segTree;
}
/*
 * 给点两个点，倍增法求lca，在此过程中，求得两点连通中的最大权
 */
static int maxUsingLco(int a,int b) {
	int ans = -1;
	if(depth[a]<depth[b]) {
		int t =0;
		a = b;
		b = t;
	}
	int k = depth[a] - depth[b];
	for (int i = 0; (1<<i) <= k; i++) {  // 1<<i与2^i相等
		if(((1<<i)&k) == 0)continue;
			ans = Math.max(ans, mm[0][i]);
			a=ff[a][i];
	}
	
	if(a!=b) {
		//ab分别到达lca的下一层
		for (int i = 16; i >= 0; i--) {
			if(ff[a][i]==ff[b][i]) continue;
			ans=Math.max(ans, mm[a][i]);
			ans=Math.max(ans, mm[b][i]);
			a=ff[a][i];
			b=ff[b][i];
		}
		//再跳一步
		ans=Math.max(ans, mm[a][0]);
		ans=Math.max(ans, mm[b][0]);
		a=ff[a][0];
		b=ff[b][0];
	}
	return ans;
}

static void prelca() {
	ff = new int[N+1][17];  //n<50000 (10^16 < n < 10^17)
	depth = new int[N+1];
	ff[1][0] = 1;
	mm[1][0] = 0;
	dfs(1,1,0);
}

static void dfs(int u,int father,int d) {
	depth[u] = d+1;
	for (int i = 1; i < 17; i++) {
		ff[u][i] = ff[ff[u][i-1]][i-1];
		mm[u][i] = Math.max(mm[u][i-1], mm[ff[u][i-1]][i-1]);
	}
	for (int i = 0; i < g[u].size(); i++) {
		Edge child = g[u].get(i);
		if(child.to == father) continue;
//		System.out.println(child);
		ff[child.to][0]=u;
		mm[child.to][0]=child.cost;
		dfs(child.to, u, d+1);
	}
}

static void buildMST() {
	Arrays.sort(edges);
	//点的坐标从1开始计数
	UnionFind uf = new UnionFind(N+1);
	for (int i = 0; i < edges.length; i++) {
		Edge edge = edges[i];
		int from = edge.from;
		int to = edge.to;
		if(uf.find(from) == uf.find(to))continue;
		uf.merge(from, to);
		g[from].add(edge);
		g[to].add(new Edge(to, from, edge.cost));
	}
}

static class Edge implements Comparable<Edge>{

	int from;
	int to;
	int cost;
	
	public Edge(int from, int to, int cost) {
		super();
		this.from = from;
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		if(o == null) return 0;
		else if (this.cost > o.cost) {
			return 1;
		}else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", cost=" + cost + "]";
	}
	
	
}

static class UnionFind{
	UFNode[] ufNodes;
	
	public UnionFind(int n) {
		ufNodes = new UFNode[n];
		for (int i = 0; i < n; i++) {
			ufNodes[i] = new UFNode();
		}
	}
	
	UFNode find(int i) {
		UFNode node = ufNodes[i];
		if(node.parent == null) return node;
		Set<UFNode> set = new HashSet<UFNode>();
		while(node.parent != null) {
			set.add(node);
			node = node.parent;
		}
		//压缩路径，缩为一层
		for (UFNode n: set) {
			n.parent = node;
		}
		return node;
	}
	
	void merge(int a,int b) {
		find(b).parent = find(a);
	}
	static class UFNode{
	UFNode parent;
}
}

static class SegTree{
	int l;  //左区间
	int r;  //右区间
	int m;  //维护max
	
	SegTree lson;
	SegTree rson;
	public SegTree(int l, int r) {
		this.l = l;
		this.r = r;
	}
	
}
}




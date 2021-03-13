package a2015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import javax.xml.crypto.Data;

/*
 * 10.�ֺ��ؽ�
Pear��һ����N��<=50000��������㣬�����֮����M��<=200000����˫���·������
��Щ���������֮�䶼����ͨ��˫���·����������һֱ�����������һ�����صĵ���ٻ���ȫ��M����·��
���Pear�����޸�����һЩ��·�������i����·��ҪPi��ʱ�䡣
������Pear����������ȫ���ĵ���ͨ������ѡ��һЩ�������ĵ���������ͨ��
Pear��Q��<=50000����ѯ�ʣ�ÿ��ѯ�ʣ�����ѡ�����б����[l,r]֮�䣬���� ��� mod K  = C �ĵ㣬
����һЩ·ʹ��������ͨ���������е�·���������ͬʱ������������������ʱ��ȡ���ڻ���ʱ�����һ��·�����漰���ĵ�·��Pi�����ֵ��
���ܰ���Pear�����ÿ��ѯ��ʱ��Ҫ���ѵ�����ʱ��ô������ѯ���Ƕ����ģ�Ҳ������һ��ѯ���������ƻ���û�и����ж���
�������ʽ��
��һ������������N��M��Q������������������
������M�У�ÿ������������Xi��Yi��Pi����ʾһ������Xi��Yi��˫���·���޸���ҪPi��ʱ�䡣�������Ի����������رߡ�1<=Pi<=1000000��
������Q�У�ÿ���ĸ�������Li��Ri��Ki��Ci����ʾ���ѯ�ʵĵ���[Li,Ri]���������б��Mod Ki=Ci�ĵ㡣��֤����ѯ�ʵĵ�������������
�������ʽ��
���Q�У�ÿ��һ����������ʾ��Ӧѯ�ʵĴ𰸡�
���������롿
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
�����������
9
6
8
8
�����ݷ�Χ��
����20%�����ݣ�N,M,Q<=30
����40%�����ݣ�N,M,Q<=2000
����100%�����ݣ�N<=50000,M<=2*10^5,Q<=50000. Pi<=10^6. Li,Ri,Ki����[1,N]��Χ�ڣ�Ci��[0,��Ӧѯ�ʵ�Ki)��Χ�ڡ�
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 5000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
��С�����������鼯
 */
public class a91_�ֺ��ؽ� {
	static int N,M,Q;
	static Edge[] edges;
	static List<Edge>[] g;
	static int[][] ff;  //ff[i][j]ָi�Žڵ������ڵ㷽����2^j�κ�ﵽ�Ľڵ���
	static int[] depth;	//�ڵ�����
	static int[][] mm;	//mm[i][j]ָi�Žڵ������ڵ㷽����2^j�εĹ����е����Ȩ��
	static SegTree[] segTrees;
	static int[] data=new int[50001]; //���50000���ڵ�
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
	segTrees = new SegTree[threshold*(threshold+1)/2 + 1]; //��ʼ���߶���������
	int index = 1;
	for (int mod = 1; mod <= threshold; mod++) {
		for (int re = 0; re < mod; re++) {
			//����ԭʼ���ݲ�ȷ��������������
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
			//����������thresholdʱ��ֱ����lca����
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
 * @param l  ��˵�
 * @param r  �Ҷ˵�
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
 * ���������㣬��������lca���ڴ˹����У����������ͨ�е����Ȩ
 */
static int maxUsingLco(int a,int b) {
	int ans = -1;
	if(depth[a]<depth[b]) {
		int t =0;
		a = b;
		b = t;
	}
	int k = depth[a] - depth[b];
	for (int i = 0; (1<<i) <= k; i++) {  // 1<<i��2^i���
		if(((1<<i)&k) == 0)continue;
			ans = Math.max(ans, mm[0][i]);
			a=ff[a][i];
	}
	
	if(a!=b) {
		//ab�ֱ𵽴�lca����һ��
		for (int i = 16; i >= 0; i--) {
			if(ff[a][i]==ff[b][i]) continue;
			ans=Math.max(ans, mm[a][i]);
			ans=Math.max(ans, mm[b][i]);
			a=ff[a][i];
			b=ff[b][i];
		}
		//����һ��
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
	//��������1��ʼ����
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
		//ѹ��·������Ϊһ��
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
	int l;  //������
	int r;  //������
	int m;  //ά��max
	
	SegTree lson;
	SegTree rson;
	public SegTree(int l, int r) {
		this.l = l;
		this.r = r;
	}
	
}
}




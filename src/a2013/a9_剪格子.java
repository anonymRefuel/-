package a2013;

import java.util.Scanner;

/*
 * 9.���⣺������
    ��ͼp1.jpg��ʾ��3 x 3 �ĸ�������д��һЩ������
    ��������ͼ�еĺ�ɫ�߼������õ��������֣�ÿ�����ֵ����ֺͶ���60��
    �����Ҫ������������ж����Ը�����m x n �ĸ����е��������Ƿ���Էָ�Ϊ�������֣�ʹ����������������ֺ���ȡ�
    ������ڶ��ֽ��������������ϽǸ��ӵ��Ǹ���������ĸ��ӵ���С��Ŀ��   
    ����޷��ָ����� 0
�������������ʽҪ��
�����ȶ����������� m n �ÿո�ָ� (m,n<10)
��ʾ���Ŀ�Ⱥ͸߶�
��������n�У�ÿ��m�����������ÿո�ֿ���ÿ������������10000
��������������н��У��������Ͻǵķָ������ܰ�������С�ĸ�����Ŀ��
���磺
�û����룺
3 3
10 1 52
20 30 1
1 2 3
����������
3
�����磺
�û����룺
4 3
1 1 1 1
1 30 80 2
1 1 1 100
����������
10
(�μ�p2.jpg)
��ԴԼ����
��ֵ�ڴ����ģ���������� < 64M
CPU����  < 5000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.6�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��
 */
public class a9_������ {
	public static int[][] g;//����
	public static int[][] tag;//����Է���
	public static int m;//����
	public static int n;//����
	public static int tatal;//����
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

public static void dfs(int i,int j,int steps,int sum) {//Ӧ���ж�sum�Ƿ����tatal/2�����жϽ�Ҫ�ߵ�λ���Ƿ��ߵ�ͨ
	if(sum == tatal/2) {
		ans = Math.min(ans, steps);
		return;}
	
	if(sum > tatal/2||steps>ans)return;
	
	if(i<0 || i==n || j<0 || j==m || tag[i][j]==1) return;//�߳��߽���Է���
	
	tag[i][j] = 1;
	dfs(i-1, j, steps + 1, sum + g[i][j]);//����
	dfs(i+1, j, steps + 1, sum + g[i][j]);//����
	dfs(i, j-1, steps + 1, sum + g[i][j]);//����
	dfs(i, j+1, steps + 1, sum + g[i][j]);//����
	tag[i][j]=0;
}
}

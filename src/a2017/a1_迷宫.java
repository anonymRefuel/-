package a2017;
/*
 * 1.���⣺�Թ�
X�����һ���Թ����ֳ�����ĳ��Сɽ���ϡ�
������10x10�໥��ͨ��С������ɵġ�

����ĵذ���д��һ���ܴ����ĸ��
���Ǽ���������泯���µķ���վ������
L��ʾ�ߵ���ߵķ��䣬
R��ʾ�ߵ��ұߵķ��䣬
U��ʾ�ߵ����·���ķ��䣬
D��ʾ�ߵ����·���ķ��䡣

X����ľ����е�������Ը�����˼����
���Ǹ�ϲ�������������Ϸ�������ϷҲ����ˣ�

��ʼ��ʱ��ֱ������100����ҷ���һ����С�����ڡ�
���һ��Ҫ���յ��ϵ���ĸ�ƶ���

�Թ���ͼ���£�
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

�������һ�£�����ж�����һ��߳��Թ�? 
����������߶�Ȧ�ӡ�

���ύ����������ʾ�߳��Թ��������Ŀ����Ҫ��д�κζ�������ݡ�

����㻹û������Ϸ���򣬿��Բο�һ���򻯵�4x4�Թ��Ľ�˵ͼ��
p1.png

����100����ҷ���һ����С�����ڡ���˼����ÿ��������һ����ң���Ȼ����ϸ���⻹��֪��������Ķ���qaq
����ܼ򵥣����Ƕ�ÿһ��������һ��������������Ч��������ȥ�Թ��ľ�++����Ϊ������Ч������˵����ѭ���
��ȻҲ����vis[][]���������ظ�·��(���С��),���߻��ɵݹ�д�����븸�׵����꣨��һ���ڵ㣩,�����õ��ǵ�������:31
������:[���ű�][2014����������]��������
 */
public class a1_�Թ� {
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
L��ʾ�ߵ���ߵķ��䣬
R��ʾ�ߵ��ұߵķ��䣬
U��ʾ�ߵ����·���ķ��䣬
D��ʾ�ߵ����·���ķ��䡣
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

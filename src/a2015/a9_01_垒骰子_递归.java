package a2015;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 9.������
��ʥatm�����������������ӣ����ǰ�����һ��������һ���ϱߣ���������ŤŤ��Ҫ�ݳɷ����塣
�������ڹ۲죬atm �������ȶ����ӵİ��أ���Щ���ֵ������Żụ���ų⣡
���������淶һ�����ӣ�1 �Ķ����� 4��2 �Ķ����� 5��3 �Ķ����� 6��
������ m �黥������ÿ���е����������ֵ��������һ�����ӾͲ����ȶ����������� atm�����һ���ж����ֲ�ͬ�Ŀ��ܵ������ӷ�ʽ��
���������ӷ�ʽ��ͬ�����ҽ��������ַ�ʽ�ж�Ӧ�߶ȵ����ӵĶ�Ӧ���ֵĳ�����ͬ��
���ڷ��������ܹ��࣬�����ģ 10^9 + 7 �Ľ����
��ҪС���� atm ����������Ŷ��
�������ʽ��
��һ���������� n m
n��ʾ������Ŀ
������ m �У�ÿ���������� a b ����ʾ a �� b ���ܽ�����һ��
�������ʽ��
һ��һ��������ʾ��ģ 10^9 + 7 �Ľ����
���������롹
2 1
1 2
�����������
544
�����ݷ�Χ��
���� 30% �����ݣ�n <= 5
���� 60% �����ݣ�n <= 100
���� 100% �����ݣ�0 < n <= 10^9, m <= 36
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 2000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
ע�⣺��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
ע�⣺��������ֱ����ǣ�Main��������Ч���봦��

����:dp+������+���������
 */
public class a9_01_������_�ݹ� {
	//�洢���ֵ���ụ���ų��
	static int dir[]= new int[7];
	static int count=0;
	static final int MOD = (int) (Math.pow(10, 9)+7);
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt(); 
		for (int i = 0; i <m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			dir[a] = b;
			dir[b] = a;
		}
		System.out.println("n:"+n+"  m:"+m);
		System.out.println(Arrays.toString(dir));
		for (int i = 1; i <= 6; i++) {
			//4����ǰ��ȷ���󣬿����Զ���ת4������
			count = (count +4*dfs(n-1,i))%MOD;  //��Ҳ���Բ���4�����ע�͵�����һ��  
		}
		
//		System.out.println((int)Math.pow(4, n)*count);
		System.out.println(count);
	}
	
	static int dfs(int n,int point) {
		if(n==0) {
		//������һ����ȷ������ת��Ӧ����1��������4��
		return 1;
		}
		int ans  = 0;
		//��ǰ��Ķ�����
		int p = opp(point);
		for (int point1 = 1; point1 <= 6; point1++) {
			if(point1 == dir[p]) continue;
			//4����ǰ��ȷ���󣬿����Զ���ת4������
			ans = (ans+4*dfs(n-1, point1))%MOD;
	 }
		return ans;
	}
	//�������
	static int opp(int point) {
		switch (point) {
		case 1:return 4;
		case 2:return 5;
		case 3:return 6;
		case 4:return 1;
		case 5:return 2;
		case 6:return 3;
		default:return -1;
		}
	}
	
}

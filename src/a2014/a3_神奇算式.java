package a2014;

import java.util.HashSet;

/*
 * 3.���⣺������ʽ
    ��4����ͬ�����֣���ɵ�һ���˷���ʽ�����ǵĳ˻���Ȼ����4��������ɡ�
    ���磺 
210 x 6 = 1260 
8 x 473 = 3784
27 x 81 = 2187 
    ������Ҫ��
    �������˷������ɵ���ʽ����ͬһ���������ô�������ϱ����г���3�������һ���ж���������Ҫ�����ʽ��
    ����д�����֣�ͨ��������ύ�𰸣���Ҫ��д�������ݣ����磺�г�������ʽ����
��:12,�����е����org���ҵ�˼·��2��forö��1-999���ǳ˻�������˻���Ҫ����2��������һ��������4λ��
�ڶ��������ǲ�ͬ��������ϣ������������ӡ�����жϣ�����i��j����������ҪΪ4�����ö��i��j��ȫ�����Ҵ�
pass:���������ҵĴ�����ע����if(flag==1)��ɸ�أ���ûע��ǰ�Աȿ��Կ����ҵ��𰸣�
18-15=3������ζ����3�����ظ����ֵĴ𰸣��������������ж���
 */
public class a3_������ʽ {
public static void main(String[] args) {
	HashSet<String> set = new HashSet<>();
	int sum = 0;
	for (int i = 1; i < 1000; i++) {
	tag:	for (int j = 1; j <1000; j++) {
			int a = i*j;
			String a2 = "" +a;
			if(a2.length()!=4)continue tag;
			String s = "" + i + j;
			if(s.length()!= 4)continue tag;
			int[] t = new int[] {0,0,0,0,0,0,0,0,0,0};
			for(int m=0;m<4;m++) {
				if(!s.contains("" +a2.charAt(m)))continue tag;
				t[Integer.parseInt(""+a2.charAt(m))]+=1;
			}
			int[] tt = new int[] {0,0,0,0,0,0,0,0,0,0};
			for(int m=0;m<4;m++) {
				if(!a2.contains("" +s.charAt(m)))
					continue tag;
				tt[Integer.parseInt(""+s.charAt(m))]+=1;
			}
			for (int k = 0; k <t.length; k++) {
				if (t[k]!=tt[k]) {
					continue tag;
				}
			}
			System.out.println(i + " "+ j);
			set.add(a2);
		}
	}
	System.out.println(set.size());
}
}

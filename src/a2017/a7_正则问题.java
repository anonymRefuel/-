package a2017;

import java.util.Scanner;

import javax.swing.text.Position;

/*
 * 7.��������������
����һ�ּ򵥵�������ʽ��
ֻ�� x ( ) | ��ɵ�������ʽ��
С����������������ʽ�ܽ��ܵ���ַ����ĳ��ȡ�  
���� ((xx|xxx)x|(x|xx))xx �ܽ��ܵ���ַ����ǣ� xxxxxx��������6��
����
----
һ����x()|��ɵ�������ʽ�����볤�Ȳ�����100����֤�Ϸ���  
���
----
���������ʽ�ܽ��ܵ���ַ����ĳ��ȡ�  
���磬
���룺
((xx|xxx)x|(x|xx))xx  
����Ӧ�������
6  
��ԴԼ����
��ֵ�ڴ����ģ���������� < 256M
CPU����  < 1000ms
���ϸ�Ҫ���������Ҫ��������ش�ӡ���ƣ�����������...�� �Ķ������ݡ�
���д������ͬһ��Դ�ļ��У�����ͨ���󣬿����ύ��Դ�롣
��Ҫʹ��package��䡣��Ҫʹ��jdk1.7�����ϰ汾�����ԡ�
��������ֱ����ǣ�Main��������Ч���봦��
�������Ŀ�����û�н�����,xx|xxx����"|"������ȡ����ֵ��
��Ϊ3
 */
public class a7_�������� {
	static String s;
	static char[] c;
	static int pos = 0;
public static void main(String[] args) {
	Scanner	sc = new Scanner(System.in);
	s = sc.next();
	c = s.toCharArray();
	int m = fun();
	System.out.println(m);
}

static int fun() {
	int m=0;
    int tmp=0;  
	while(pos<c.length) {
		if(c[pos] == 'x') {		
			tmp++;
		}else if (c[pos] == '(') {
			pos++;
			tmp += fun();
		}else if(c[pos] == '|') {
			m = Math.max(m,tmp); 
			tmp=0;
		}else if(c[pos] == ')') {
			break;			
		}
		pos++;
	}
	return Math.max(m,tmp); 
}
}

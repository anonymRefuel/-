package a2017;

import java.util.Scanner;

import javax.swing.text.Position;

/*
 * 7.描述：正则问题
考虑一种简单的正则表达式：
只由 x ( ) | 组成的正则表达式。
小明想求出这个正则表达式能接受的最长字符串的长度。  
例如 ((xx|xxx)x|(x|xx))xx 能接受的最长字符串是： xxxxxx，长度是6。
输入
----
一个由x()|组成的正则表达式。输入长度不超过100，保证合法。  
输出
----
这个正则表达式能接受的最长字符串的长度。  
例如，
输入：
((xx|xxx)x|(x|xx))xx  
程序应该输出：
6  
资源约定：
峰值内存消耗（含虚拟机） < 256M
CPU消耗  < 1000ms
请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
不要使用package语句。不要使用jdk1.7及以上版本的特性。
主类的名字必须是：Main，否则按无效代码处理。
这题的题目真的是没有讲明白,xx|xxx其中"|"是左右取最大的值，
答案为3
 */
public class a7_正则问题 {
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

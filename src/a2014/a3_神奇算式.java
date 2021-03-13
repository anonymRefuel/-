package a2014;

import java.util.HashSet;

/*
 * 3.标题：神奇算式
    由4个不同的数字，组成的一个乘法算式，它们的乘积仍然由这4个数字组成。
    比如： 
210 x 6 = 1260 
8 x 473 = 3784
27 x 81 = 2187 
    都符合要求。
    如果满足乘法交换律的算式算作同一种情况，那么，包含上边已列出的3种情况，一共有多少种满足要求的算式。
    请填写该数字，通过浏览器提交答案，不要填写多余内容（例如：列出所有算式）。
答案:12,这题有点恶心org，我的思路是2个for枚举1-999他们乘积，这个乘积先要满足2个条件第一个是它是4位，
第二个是它是不同的数字组合，这个可以最后打印肉眼判断，还有i和j加起来长度要为4，最后枚举i和j的全排列找答案
pass:后来发现我的代码中注释了if(flag==1)的筛重，和没注释前对比可以快速找到答案，
18-15=3个，意味着有3个有重复数字的答案，不过还是肉眼判断稳
 */
public class a3_神奇算式 {
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

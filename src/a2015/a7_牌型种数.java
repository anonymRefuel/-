package a2015;
/*
 * 7.牌型种数
小明被劫持到X赌城，被迫与其他3人玩牌。
一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
这时，小明脑子里突然冒出一个问题：
如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
请填写该整数，不要填写任何多余的内容或说明文字。

答案:3598180
考点递归，其实前面一直下来都没考到dp和递归，从这角度想，应该会用到了把，
不过我是暴力模拟到开头就发现可以递归了org，这里呢，每种纸牌有5种取法，
有13种纸牌，可以选择取1个，取2个，取3个，取4个，取0个，注意不取的情况一定不能漏qaq，
第一次漏了，粗心鸭= =，所以考试记得回头检查
 */
public class a7_牌型种数 {
	static int ans;
public static void main(String[] args) {
	fun(0,0);
	System.out.println(ans);
}
/**
 * @param k    表示A-2-3-4------J-Q-K这13个数
 * @param cnt  表示cnt+第k个数的个数
 */
public static void fun(int k,int cnt) {
	if(k==13&cnt==13) {
		ans++;
		return;
	}
	if(k>13||cnt>13)return;
//	fun(k+1, cnt);
//	fun(k+1, cnt+1);
//	fun(k+1, cnt+2);
//	fun(k+1, cnt+3);
//	fun(k+1, cnt+4);
	for (int i = 0; i <5; i++) {
		fun(k+1, cnt+i);
	}
}
}

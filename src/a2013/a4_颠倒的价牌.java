package a2013;

import java.util.ArrayList;

/*
 * 4.标题: 颠倒的价牌
    小李的店里专卖其它店中下架的样品电视机，可称为：样品电视专卖店。
    其标价都是4位数字（即千元不等）。
    小李为了标价清晰、方便，使用了预制的类似数码管的标价签，只要用颜色笔涂数字就可以了（参见p1.jpg）。
    这种价牌有个特点，对一些数字，倒过来看也是合理的数字。如：1 2 5 6 8 9 0 都可以。
    这样一来，如果牌子挂倒了，有可能完全变成了另一个价格，比如：1958 倒着挂就是：8561，差了几千元啊!!      
    当然，多数情况不能倒读，比如，1110 就不能倒过来，因为0不能作为开始数字。
    有一天，悲剧终于发生了。某个店员不小心把店里的某两个价格牌给挂倒了。并且这两个价格牌的电视机都卖出去了!
    庆幸的是价格出入不大，其中一个价牌赔了2百多，另一个价牌却赚了8百多，综合起来，反而多赚了558元。
    请根据这些信息计算：赔钱的那个价牌正确的价格应该是多少？

答案是一个4位的整数，请通过浏览器直接提交该数字。
注意：不要提交解答过程，或其它辅助说明类的内容。
 */
public class a4_颠倒的价牌 {
	public static void main(String[] args) {
		//储存大致筛选结果
		ArrayList<Price> arrayList =new ArrayList<Price>();
		
		//大致筛选
		for(int i=1000;i<10000;i++) {
			String prePrice = String.valueOf(i);
			//筛选掉1 2 5 6 8 9 0 以外的
			if(prePrice.contains("3")||prePrice.contains("4")||prePrice.contains("7")) continue;
			//将i翻转
		   int j =Integer.parseInt(reverse(i));
		   int plus = j - i ;  //差价
		   //筛选一个价牌赔了2百多，另一个价牌却赚了8百多的
		   if(plus < -200 && plus > -300) arrayList.add(new Price(i, plus, j));
		   if(plus >800 && plus < 900) arrayList.add(new Price(i, plus, j));
		}
		
		//筛选赚了558元的
		for (Price price : arrayList) {
			for (Price price2 : arrayList) {
				//p1表示亏得商品原价，p2表示赚得商品原价
				if(price.plus + price2.plus == 558) {
					System.out.print(price);
					System.out.println(price2);
					}
				}
			}
			
	}
	
	private static String reverse(int price) {
		String string = String.valueOf(price);
		char[] p = string.toCharArray();
		//交换第一个数和第四个数,第二个个和第三个数
		for(int i = 0;   i<=1;  i++) {
		char temp =fun(p[i]);
		p[i] = fun(p[3-i]);
		p[3-i]= temp;
		}
			return new String(p);
	}
	
	//实现6换成9
	private static char fun(char i) {
		if(i == '6') return '9';
		else if(i == '9') return '6';
		else return i;
	}
	
	 private static class Price{
		int p1;    //原价
		int plus;  //差价
		int p2;    //翻转后价格
		public Price(int p1, int plus, int p2) {
			this.p1 = p1;
			this.plus = plus;
			this.p2 = p2;
		}
		
		public String toString() {
			
			return " 原价" + p1 +"  差价" + plus + "  翻转后价格" + p2;
		}
		
	}
	 
	 //9088
}

package a2013;

import java.util.ArrayList;

/*
 * 4.����: �ߵ��ļ���
    С��ĵ���ר�����������¼ܵ���Ʒ���ӻ����ɳ�Ϊ����Ʒ����ר���ꡣ
    ���۶���4λ���֣���ǧԪ���ȣ���
    С��Ϊ�˱�����������㣬ʹ����Ԥ�Ƶ���������ܵı��ǩ��ֻҪ����ɫ��Ϳ���־Ϳ����ˣ��μ�p1.jpg����
    ���ּ����и��ص㣬��һЩ���֣���������Ҳ�Ǻ�������֡��磺1 2 5 6 8 9 0 �����ԡ�
    ����һ����������ӹҵ��ˣ��п�����ȫ�������һ���۸񣬱��磺1958 ���ŹҾ��ǣ�8561�����˼�ǧԪ��!!      
    ��Ȼ������������ܵ��������磬1110 �Ͳ��ܵ���������Ϊ0������Ϊ��ʼ���֡�
    ��һ�죬�������ڷ����ˡ�ĳ����Ա��С�İѵ����ĳ�����۸��Ƹ��ҵ��ˡ������������۸��Ƶĵ��ӻ�������ȥ��!
    ���ҵ��Ǽ۸���벻������һ����������2�ٶ࣬��һ������ȴ׬��8�ٶ࣬�ۺ�������������׬��558Ԫ��
    �������Щ��Ϣ���㣺��Ǯ���Ǹ�������ȷ�ļ۸�Ӧ���Ƕ��٣�

����һ��4λ����������ͨ�������ֱ���ύ�����֡�
ע�⣺��Ҫ�ύ�����̣�����������˵��������ݡ�
 */
public class a4_�ߵ��ļ��� {
	public static void main(String[] args) {
		//�������ɸѡ���
		ArrayList<Price> arrayList =new ArrayList<Price>();
		
		//����ɸѡ
		for(int i=1000;i<10000;i++) {
			String prePrice = String.valueOf(i);
			//ɸѡ��1 2 5 6 8 9 0 �����
			if(prePrice.contains("3")||prePrice.contains("4")||prePrice.contains("7")) continue;
			//��i��ת
		   int j =Integer.parseInt(reverse(i));
		   int plus = j - i ;  //���
		   //ɸѡһ����������2�ٶ࣬��һ������ȴ׬��8�ٶ��
		   if(plus < -200 && plus > -300) arrayList.add(new Price(i, plus, j));
		   if(plus >800 && plus < 900) arrayList.add(new Price(i, plus, j));
		}
		
		//ɸѡ׬��558Ԫ��
		for (Price price : arrayList) {
			for (Price price2 : arrayList) {
				//p1��ʾ������Ʒԭ�ۣ�p2��ʾ׬����Ʒԭ��
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
		//������һ�����͵��ĸ���,�ڶ������͵�������
		for(int i = 0;   i<=1;  i++) {
		char temp =fun(p[i]);
		p[i] = fun(p[3-i]);
		p[3-i]= temp;
		}
			return new String(p);
	}
	
	//ʵ��6����9
	private static char fun(char i) {
		if(i == '6') return '9';
		else if(i == '9') return '6';
		else return i;
	}
	
	 private static class Price{
		int p1;    //ԭ��
		int plus;  //���
		int p2;    //��ת��۸�
		public Price(int p1, int plus, int p2) {
			this.p1 = p1;
			this.plus = plus;
			this.p2 = p2;
		}
		
		public String toString() {
			
			return " ԭ��" + p1 +"  ���" + plus + "  ��ת��۸�" + p2;
		}
		
	}
	 
	 //9088
}

package a2015;

import java.time.LocalDate;
import java.util.Calendar;

/*
 * 2.��ϵը��
��X��ϵ�Ĺ���ռ���Ư�������X�����조ը������������Ϊ�����е�·�ꡣ
ÿ��ը���������趨������֮��ը��
���磺������ը��2015��1��1�շ��ã���ʱΪ15�죬������2015��1��16�ձ�ը��
��һ������ը����2014��11��9�շ��ã���ʱΪ1000�죬�����������ը��׼ȷ���ڡ�
����д�����ڣ���ʽΪ yyyy-mm-dd  ��4λ���2λ�·�2λ���ڡ����磺2015-02-19
���ϸ��ո�ʽ��д�����ܳ����������ֻ���š�
��:2017-08-05,���ⲻ���ô���ģ�������������ͺã�����������Ҫ������java��API���ã�Calendar���÷��������Ҫע�������ʽ
 */
public class a2_��ϵը�� {
public static void main(String[] args) {
	Calendar a =Calendar.getInstance();
	a.set(2014, 10, 9);
	a.add(Calendar.DATE, 1000);
	LocalDate b = LocalDate.of(2014,11,9);
	b=b.plusDays(1000);
//	a.add(Calendar.DATE,1000);
	System.out.println(a.get(Calendar.YEAR)+ " "+(a.get(Calendar.MONTH)+1)+" "+a.get(Calendar.DAY_OF_MONTH)+" "+(a.get(Calendar.DAY_OF_WEEK)-1));
	System.out.println(b.getYear()+" " + b.getMonthValue()+ " " +b.getDayOfMonth()+" "+b.getDayOfWeek().getValue() );
}
}

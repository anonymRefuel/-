package a2013;

import java.time.LocalDate;

/* ����а�̳�1999��12��31��������ĩ�ա���Ȼ��ҥ���Ѿ��������ơ�

    �����˳ƽ���ĳ������ĩ��12��31�գ����������һ���....

    ��Ȥ���ǣ��κ�һ������ĩ����ݵ�12��31�ն�������������һ!! 

    ���ǣ���ҥ�������̡����޸�Ϊ������......

    1999���12��31���������壬���ʣ�δ����һ�������������һ������ĩ�꣨��xx99�꣩��12��31�������������죨�������գ���

    ��ش����ݣ�ֻд���4λ��������Ҫд12��31�ȶ�����Ϣ��
*/    
public class a1_����ĩ������ {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(1999, 12, 31);
		for(int year=1999,i=1;  i<20; year+=100) {
		localDate = localDate.of(year, 12, 31);
		if(localDate.getDayOfWeek().getValue() == 7)
			break;
	
		}
		System.out.println(localDate.getDayOfWeek().getValue());
		System.out.println(localDate.getYear());
	}
	//2299
}

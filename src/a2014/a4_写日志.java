package a2014;
/*
 * 4.���⣺д��־
    д��־�ǳ���ĳ�����������Ҫ���� t1.log, t2.log, t3.log �����ļ�������д����־��
    Ҳ����˵��һ��д��t1.log���ڶ���д��t2.log��... ���Ĵ���Ȼд��t1.log����˷�����
    ����Ĵ���ģ������������д�벻ͬ��־�ļ����߼���
    
����д���߲���ȱʧ�Ĵ��롣ͨ��������ύ�𰸡�
ע�⣺��Ҫ��д�������е����ݣ�Ҳ��Ҫ��д�κ�˵�����������֡�

1 + n%3  ,��ģ���������԰�n=1,2,3����ȥ��֤
 */
public class a4_д��־ {
	
		private static int n = 1;
		
		public static void write(String msg)
		{
			String filename = "t" + n + ".log";
		//	n = ____________;
			System.out.println("write to file: " + filename + " " + msg);
		}
	
}

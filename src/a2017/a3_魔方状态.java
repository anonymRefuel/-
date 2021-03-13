package a2017;
import java.util.HashSet;
import java.util.Set;

/*
 * 3.���⣺ħ��״̬
����ħ������ֻ��2���ħ����ֻ��8��С����ɡ�
��ͼp1.png��ʾ��
С������������ֻϲ��3����ɫ�����аѼ���Ķ���ħ������Ϳ����ɫ�����£�
ǰ�棺��ɫ    o
���棺��ɫ	 g	
���棺��ɫ	 y
���棺��ɫ	 g
���棺��ɫ    o
���棺��ɫ    y
�������һ�£�������ħ�������Һ�һ���ж����ֲ�ͬ��״̬��
�������״̬����ħ����������ת�󣬸��������ɫ��һ�£�����Ϊ��ͬһ״̬��
���ύ��ʾ״̬������������Ҫ��д�κζ������ݻ�˵�����֡�

�����е����,��8�����¼Ϊһ�����飬ÿ������6���棬���Կ�Ҳ�Ǹ����飬
���Կ�����ά����ģ�⣬ÿ�β�����3�֣���ǰ˳ʱ��,����˳ʱ�� ,����˳ʱ��
�����е��Ի��˰ѣ���֪�������û������ħ���Ĵ�����ħ����ʱ��ֻ��һ����ֻ��3��������ת�أ�
û�����Ǿ���bfs��¼�����е�״̬����ŵ�˼·��������= =
 */
public class a3_ħ��״̬ {
	  static char[][] start = {"oybbgb".toCharArray(),
	      "oygbbb".toCharArray(),
	      "bygbby".toCharArray(),
	      "bybbgy".toCharArray(),
	      "obbogb".toCharArray(),
	      "obgobb".toCharArray(),
	      "bbgoby".toCharArray(),
	      "bbbogy".toCharArray()};
	  static char[][][] q = new char[2000000][8][6];
	  static Set<String> all_state = new HashSet<String>();
	  static int  front, tail;


	  static String to_string(char[][] a) {
	    String ans = "";
	    for (int i = 0; i < 8; ++i) {
	      ans += new String(a[i]);
	    }
	    return ans;
	  }

	  private static void swap(char[] a, int i, int j) {
	    char t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	  }

	  private static void swap(char[][] a, int i, int j) {
	    char[] t = a[i];
	    a[i] = a[j];
	    a[j] = t;
	  }

	  //�ϲ�Ŀ����ת��������λ�õ���
	  static void ucell(char[] a) {
	    swap(a, 0, 2);
	    swap(a, 2, 5);
	    swap(a, 5, 4);
	  }


	  //�ϲ�˳ʱ����ת
	  static void u(char[][] s) {
	    ucell(s[0]);
	    ucell(s[1]);
	    ucell(s[2]);
	    ucell(s[3]);
//	    ������λ�õ���
	    swap(s, 1, 0);
	    swap(s, 2, 1);
	    swap(s, 3, 2);

	  }

	  //�Ҳ���ת�����λ�ñ仯
	  static void rcell(char[] a) {
	    swap(a, 1, 0);
	    swap(a, 0, 3);
	    swap(a, 3, 5);
	  }

	  static void r(char[][] s)//ħ���Ҳ�˳ʱ��ת
	  {
	    rcell(s[1]);
	    rcell(s[2]);
	    rcell(s[6]);
	    rcell(s[5]);
//	    ���λ�ñ仯
	    swap(s, 2, 1);
	    swap(s, 5, 1);
	    swap(s, 6, 5);
	  }

	  static void fcell(char[] a) {
	    swap(a, 2, 1);
	    swap(a, 1, 4);
	    swap(a, 4, 3);
	  }

	  static void f(char[][] s)//ǰ��һ�� ˳ʱ��ת
	  {
	    fcell(s[0]);
	    fcell(s[1]);
	    fcell(s[4]);
	    fcell(s[5]);
	    swap(s, 1, 5);
	    swap(s, 0, 1);
	    swap(s, 4, 0);
	  }

	  static void uwhole(char[][] s)//����ħ���Ӷ����� ˳ʱ��ת ��������
	  {
	    u(s);//�ϲ���ת
//	    �²���ת
	    ucell(s[4]);
	    ucell(s[5]);
	    ucell(s[6]);
	    ucell(s[7]);
//	    ��������󣬿��λ�ñ䶯
	    swap(s, 5, 4);
	    swap(s, 6, 5);
	    swap(s, 7, 6);
	  }

	  static void fwhole(char[][] s)//����ħ����ǰ�濴 ˳ʱ��ת ��������
	  {
	    f(s);
	    fcell(s[2]);
	    fcell(s[6]);
	    fcell(s[7]);
	    fcell(s[3]);
	    swap(s, 2, 6);
	    swap(s, 3, 2);
	    swap(s, 7, 3);
	  }

	  static void rwhole(char[][] s)//����ħ�����ұ߿� ˳ʱ��ת ��������
	  {
	    r(s);
	    rcell(s[0]);
	    rcell(s[3]);
	    rcell(s[4]);
	    rcell(s[7]);
	    swap(s, 3, 7);
	    swap(s, 0, 3);
	    swap(s, 4, 0);
	  }


	  static boolean try_insert(char[][] s) {
	    char[][] k = new char[8][6];
	    memcpy(k, s);
	    for (int i = 0; i < 4; i++) {
	      fwhole(k);
	      for (int j = 0; j < 4; j++) {
	        uwhole(k);
	        for (int q = 0; q < 4; q++) {
	          rwhole(k);
	          if (all_state.contains(to_string(k))) {
	            return false;
	          }
	        }
	      }
	    }
	    all_state.add(to_string(k));
	    return true;

	  }

	  private static void memcpy(char[][] k, char[][] s) {
	    for (int i = 0; i < 8; i++) {
	      for (int j = 0; j < 6; j++) {
	        k[i][j] = s[i][j];
	      }
	    }
	  }

	  static void solve() {
	    front = 0;
	    tail = 1;
	    all_state.add(to_string(start));
	    memcpy(q[front], start);//���q[0]���൱�ڵ�һ��״̬�����
	    while (front < tail) {
	        /*�������б��Σ����Լ���set��*/
	      memcpy(q[tail], q[front]);//������tail
	      u(q[tail]);//�ϲ�˳ʱ����ת
	      if (try_insert(q[tail])) {
	        tail++;//��չ����
	      }
	      memcpy(q[tail], q[front]);//������tail
	      r(q[tail]);//�Ҳ�˳ʱ����ת
	      if (try_insert(q[tail])) {
	        tail++;//��չ����
	      }
	      memcpy(q[tail], q[front]);//������tail
	      f(q[tail]);//ǰ˳ʱ����ת
	      if (try_insert(q[tail])) {
	        tail++;//��չ����
	      }
	      front++;//��������
	    }

	    System.out.println(front);
	  }

	  public static void main(String[] args) {
	    solve();
	  }
	
}

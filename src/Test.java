import java.util.Arrays;

public class Test {
	static boolean[][] tag;
public static void main(String[] args) {
	tag=new boolean[10][10];
	for (int i = 0; i <tag.length; i++) {
		for (int j = 0; j < tag[i].length; j++) {
			tag[i][j]=true;
		}
	}
	System.out.println(Arrays.deepToString(tag));
	tag=new boolean[10][10];
	System.out.println(Arrays.deepToString(tag));
}
}

import java.util.Arrays;

public class Test2 {
public static void main(String[] args) {
	int[] arr = {1,2,3};
		fun(arr,0);
}

static void fun(int[] arr,int k) {
	if(k==arr.length) {
		System.out.println(Arrays.toString(arr));
	}
	for (int i = k; i < arr.length; i++) {
		System.out.println(Arrays.toString(arr) + "   " + k);
		int temp = 0;
		temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
		
		fun(arr, k+1);
		
		temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
	}
}
}

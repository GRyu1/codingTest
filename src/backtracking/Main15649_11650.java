package backtracking;

import java.util.Arrays;
import java.util.Scanner;

public class Main15649_11650 {
	static int N;
	static int M;
	static boolean[] used = new boolean[9];
	static int[] arr = new int[9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
	
		permutation(0);

	}
	
	private static void permutation (int r) {
		if(r==M) {
			int[] sortedArr = new int[9];
			boolean flag=true;
			sortedArr=Arrays.copyOf(arr, M);
			Arrays.sort(sortedArr);
			for(int i=0; i<M ; i++) {
				if(sortedArr[i]!=arr[i]) {flag=false; break;} 
			}
			if(flag) {
				for(int i=0; i<M;i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			
			return ;
		}
		
		for( int i=1; i<=N ;i++) {
			if(!used[i]) {
				arr[r] = i;
				used[i] = true;
				permutation(r+1);
				used[i] = false;
			}
		}
	}
}

package backtracking;

import java.util.Scanner;

public class Main9663NeedReview {
	static int count = 0;
	static int N;
	static int[] arr;
	
 	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		nQueen(0);
		System.out.println(count);
	}

	private static void nQueen(int depth) {
		if(depth == N) {
			count++;
			return ;
		}
		
		for(int i=0; i<N ; i++) {
			arr[depth] = i;
			if(canPut(depth)) {
				nQueen(depth+1);
			}
		}
		
	}

	private static boolean canPut(int col) {
		for(int i=0; i<col; i++) {
			if(arr[col] == arr[i]) {
				return false;
			}
			else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false;
		}
		return true;
	}

}

package dynamicProgramming.knapsack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main12865 {
	static int N, M;
	static int[][] arr;
	static int Dp[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr=new int[N+1][2];
		Dp= new int [N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr , new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		for(int i=1; i<=N ; i++) {
			for(int j=1; j<=M ; j++) {
				if(arr[i][0]>j) Dp[i][j]=Dp[i-1][j];
				else Dp[i][j] = Math.max(Dp[i-1][j], Dp[i-1][j-arr[i][0]]+arr[i][1]);
			}
		}
		
		System.out.println(Dp[N][M]);
		
	}

}

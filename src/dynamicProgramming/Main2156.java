package dynamicProgramming;

import java.util.Scanner;

public class Main2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N+1];
		Integer[] dp = new Integer[N+1];
		
		for(int i=1 ;i<=N; i++) {
			arr[i]=sc.nextInt();
		}
		
		dp[0]=arr[0];
		dp[1]=arr[1];
		if(N>=2) {
			dp[2]=arr[2]+arr[1];
		}
		
		
		for(int i=3; i<=N; i++) {
			int maxtrue=0;
			int maxfalse=0;
			
			if(dp[i]==null) {
				maxtrue=Math.max(arr[i-1]+dp[i-3], dp[i-2])+arr[i];
				maxfalse=Math.max(arr[i-1]+dp[i-3], dp[i-2]);
				maxfalse=Math.max(dp[i-1], maxfalse);
			}
			dp[i]= Math.max(maxtrue, maxfalse);
		}
		
		System.out.println(dp[N]);
	}

}

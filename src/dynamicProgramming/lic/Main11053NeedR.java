package dynamicProgramming.lic;

import java.util.Scanner;

public class Main11053NeedR {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		Integer[] dp = new Integer[N];
		
		for(int i=0;i<N;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0; i<N ; i++) {
			if(dp[i]==null) {
				dp[i]=1;
				for(int j=0; j<i; j++) {
					if(arr[i]>arr[j]&&dp[i]<dp[j]+1) dp[i]=dp[j]+1;
				}
			}
		}
		
		int max=0;
		for(int i=0;i<N;i++) {
			if(max < dp[i]) max=dp[i];
		}
		
		System.out.println(max);
	}

}

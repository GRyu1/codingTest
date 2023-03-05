package dynamicProgramming;

import java.util.Scanner;

public class Main1463 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		int N = sc.nextInt();
		int dp[] = new int[N+1];
		
		if(N>=3) dp[3]=1;
		if(N>=3||N==2) dp[2]=1;
		if(N>=3||N==2||N==1) dp[1]=0;
		
		for(int i=4;i<=N;i++) {
			int[] min = new int[4];
			
			if(i%3==0 && i%2==0) {
				min[0]=Math.min(dp[i/2],dp[i/3]);
				min[0]=Math.min(dp[i-1], min[0]);
				min[0]=min[0]+1;
			}if(i%3==0 && i%2!=0) {
				min[1]=Math.min(dp[i/3], dp[i-1])+1;
			}if(i%2==0 && i%3 !=0 ) {
				min[2]=Math.min(dp[i/2], dp[i-1])+1;
			}if(i%3!=0 && i%2!=0) min[3]=dp[i-1]+1;
			int minimum=2100000000;
			for(int j=0; j<4 ; j++) {
				if(minimum>min[j]&&min[j]!=0) minimum=min[j];
			}
			dp[i]=minimum;
		}
		System.out.println(dp[N]);
	}

}

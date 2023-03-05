package dynamicProgramming;

import java.math.BigInteger;
import java.util.Scanner;

public class Main10844 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		BigInteger[][] dp=new BigInteger[N+1][10];
		
		if(N>=1) {
			dp[1][0]=BigInteger.ZERO;
			dp[1][1]=BigInteger.ONE;
			dp[1][2]=BigInteger.ONE;
			dp[1][3]=BigInteger.ONE;
			dp[1][4]=BigInteger.ONE;
			dp[1][5]=BigInteger.ONE;
			dp[1][6]=BigInteger.ONE;
			dp[1][7]=BigInteger.ONE;
			dp[1][8]=BigInteger.ONE;
			dp[1][9]=BigInteger.ONE;
		}
		
		for(int i=2; i<=N; i++) {
			for(int j=0;j<10;j++) {
				if(j==9) {
					dp[i][j]=dp[i-1][j-1];
				}else if(j==0) {
					dp[i][j]=dp[i-1][j+1];
				}else dp[i][j]=dp[i-1][j+1].add(dp[i-1][j-1]);
			}
		}
		

		
		System.out.println(dp[N][0].add(dp[N][1]).add(dp[N][2]).add(dp[N][3]).add(dp[N][4]).add(dp[N][5])
				.add(dp[N][6]).add(dp[N][7]).add(dp[N][8]).add(dp[N][9]).mod(new BigInteger("1000000000")).toString());
	}
}

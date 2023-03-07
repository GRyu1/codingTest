package dynamicProgramming.lic;

import java.util.Scanner;

public class Main9251re {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr1 = sc.next().toCharArray();
		char[] arr2 = sc.next().toCharArray();
		int[][] dp = new int[arr1.length+1][arr2.length+1];
		
		for(int i=0; i<arr1.length ; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i]==arr2[j]) dp[i+1][j+1]=dp[i][j]+1;
				else dp[i+1][j+1]=Math.max(dp[i+1][j], dp[i][j+1]);
			}
		}
		
		System.out.println(dp[arr1.length][arr2.length]);
		
	}
}

package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2579다시풀기 {
	static int[] arr;
	static Integer[] dp;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new Integer[N+1];
		
		for(int i=1; i<N+1;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		if (N >= 2) {
			dp[2] = arr[1] + arr[2];
		}
		
		System.out.println(main2579(N));
	}

	private static int main2579(int N) {
		if(dp[N]== null) {
			dp[N]=Math.max(main2579(N-2),arr[N-1]+main2579(N-3))+arr[N];
		}
		return dp[N];
		
	}

}

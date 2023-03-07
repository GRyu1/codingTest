package dynamicProgramming.lic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main2565 {
	/*static int N;
	static Integer[] arrA;
	static Integer[] arrB;
	static int[] dp;
	static int count = 0; */
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] line = new int[N][2];
		Integer[] dp = new Integer[N];
		
		for(int i=0; i<N; i++) {
			line[i][0]= sc.nextInt();
			line[i][1]= sc.nextInt();
		}
		
		Arrays.sort(line , new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0]-o2[0];
			}
		});
		
		for(int i=0; i<N; i++) {
			if(dp[i]==null) dp[i]=1;
			for(int j=0; j<i; j++) {
				if(line[i][1]>line[j][1] && dp[i]<dp[j]+1) dp[i] = dp[j]+1;
			}
		}
		int max=0;
		for(int i=0; i<dp.length;i++) {
			max=Math.max(max, dp[i]);
		}
		System.out.println(N-max);
		
		/*Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arrA = new Integer[N];
		arrB = new Integer[N];
		dp= new int[N];
		
		for(int i=0;i<N; i++) {
			arrA[i]=sc.nextInt();
			arrB[i]=sc.nextInt();
		}
		
		countDot();
		System.out.println(count);*/
	}
	
	/*private static void removeLine() {
		int max=-1;
		int maxIdx=0;
		
		for(int i=0; i<dp.length; i++) {
			if(max<dp[i]) {
				max=dp[i];
				maxIdx=i;
			}
		}
		if(max == 0 ) return;
		count++;
		arrA[maxIdx]=null;
		arrB[maxIdx]=null;
		countDot();
	}
	
	private static void countDot() {
		for(int i=0; i<N; i++) {
			dp[i]=0;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i!=j&&arrA[i]!=null&&arrB[i]!=null&&arrA[j]!=null&&arrB[j]!=null) {
					if((arrA[i]-arrA[j])*(arrB[i]-arrB[j])<0) dp[i]++;
				}
			}
		}
		removeLine();
	}*/

}

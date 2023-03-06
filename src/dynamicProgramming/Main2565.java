package dynamicProgramming;

import java.util.Scanner;

public class Main2565 {
	static int N;
	static Integer[] arrA;
	static Integer[] arrB;
	static int[] dp;
	static int count = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arrA = new Integer[N];
		arrB = new Integer[N];
		dp= new int[N];
		
		for(int i=0;i<N; i++) {
			arrA[i]=sc.nextInt();
			arrB[i]=sc.nextInt();
		}
		
		countDot();
		System.out.println(count);
	}
	
	private static void removeLine() {
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
	}

}

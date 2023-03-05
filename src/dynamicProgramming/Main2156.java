package dynamicProgramming;

import java.util.Scanner;

public class Main2156 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0 ;i<N; i++) {
			arr[i]=sc.nextInt();
		}
		
		int A=0;
		int B=0;
		int C=0;
		for(int i=0;i<N; i++) {
			if(i%3!=0) A+=arr[i];
			if(i%3!=1) B+=arr[i];
			if(i%3!=2) C+=arr[i];
		}
		int max = Math.max(A,B);
		max = Math.max(max, C);
		System.out.println(max);
	}

}

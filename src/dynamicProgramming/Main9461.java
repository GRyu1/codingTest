package dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Main9461 {
	//P(N) = P(N-1) + P(N-5)
	// P(5) = P(4) + P(0)
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<N ; i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<Long> al = new ArrayList<Long>();
		al.add((long) 1);
		al.add((long) 1);
		al.add((long) 1);
		al.add((long) 2);
		al.add((long) 2);
		
		for(int j=0;j<N;j++) {
			for(int i=5; i<arr[j]; i++) {
				al.add((long)(al.get(al.size()-1)+al.get(al.size()-5)));
			}
			System.out.println(al.get(arr[j]-1));
		}

	}

}

package temp;

import java.util.Scanner;

public class Main13241 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		long M = sc.nextLong();
		
		System.out.println(M*N/Euclid(N , M));

	}

	private static long Euclid(long n, long m) {
		long min = Math.min(n, m);
		long max = Math.max(m, n);
		long temp;
		while(true) {
			if (max%min==0) break;
			temp=max%min;
			max=min;
			min=temp;
		}
		return min;
	}

}

package numberAndCombination;

import java.util.Scanner;

public class Main1934 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		for(int i=0; i<N; i++) {
			System.out.println(LMC(sc.nextInt(), sc.nextInt()));
		}
	}
	
	public static int LMC (int a , int b) {
		int gcd=0;
		for(int i=1; i<=Math.min(a,b);i++) {
			if(a%i==0 && b%i==0) gcd=i;
		}
		return a*b/gcd;
	}

}

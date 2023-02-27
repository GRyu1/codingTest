package numberAndCombination;

import java.math.BigInteger;
import java.util.Scanner;

public class Main11050 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		BigInteger b = new BigInteger(10007+"");
		
		System.out.println(combination(n,r).mod(b));

	}
	
	public static BigInteger combination (int n , int r) {
		BigInteger numer = new BigInteger("1");
		BigInteger denom = new BigInteger("1");
		
		BigInteger N = new BigInteger(n+"");
		BigInteger R = new BigInteger(r+"");
		
		BigInteger One = new BigInteger("1");
	
		for(int i=n;i>n-r;i--) {
			numer=numer.multiply(N);
			N=N.subtract(One);
		}
		for(int i=r;i>0;i--) {
			denom=denom.multiply(R);
			R=R.subtract(One);
		}
		
		return numer.divide(denom);
	}

}

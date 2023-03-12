package temp;

import java.math.BigInteger;
import java.util.Scanner;

public class Main15829 {
	static String str;
	static int N;

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		N = sc.nextInt();
		str = sc.next();
		
		long sum=0;
		for(int i=0; i<N; i++) {
			sum+=hashing(i);
		}
		sum%=1234567891;
		System.out.println(sum);

	}

	private static int hashing(int i) {
		BigInteger result=BigInteger.ONE;
		BigInteger thirtyOne =new BigInteger("31");
		for(int j=0; j<i ; j++) {
			result=result.multiply(thirtyOne);
		}
		int a = str.charAt(i)-'a'+1;
		result=result.multiply(new BigInteger(""+a)).mod(new BigInteger("1234567891"));
		return result.intValue();
	}

}

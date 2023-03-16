package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main10986 {
	static BigInteger[] checker;
	static int[] arr;
	static int M;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		checker = new BigInteger[M];
		
		st = new StringTokenizer(br.readLine()," ");
		arr[0]=Integer.parseInt(st.nextToken())%M;
		checker[arr[0]]=BigInteger.ZERO;
		checker[arr[0]]=checker[arr[0]].add(BigInteger.ONE);
		for(int i=1; i<N; i++) {
			arr[i]+=arr[i-1];
			arr[i]+=Integer.parseInt(st.nextToken());
			arr[i]%=M;
			if(checker[arr[i]]==null) checker[arr[i]] = BigInteger.ZERO;
			checker[arr[i]]=checker[arr[i]].add(BigInteger.ONE);
		}
		
		System.out.println(counter());
		
	}

	private static int counter() {
		BigInteger sum=BigInteger.ZERO;
		BigInteger check; 
		
		for(int i=0; i<M; i++) {
			if(checker[i]!=null&& !checker[i].equals(BigInteger.ZERO)) {
				sum=sum.add(checker[i].multiply(checker[i].add(new BigInteger("-1"))).divide(BigInteger.TWO));
			}
		}
		return sum.intValue()+checker[0].intValue();
	}

}

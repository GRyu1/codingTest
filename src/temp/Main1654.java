package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1654 {
	static int N;
	static int M;
	static long arr[];
	static long arr1[];
	static long GCD;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		arr = new long[N];
		arr1 = new long[N-1];
		for(int i=0; i<N;i++) {
			arr[i]=Long.parseLong(br.readLine());
		}
		Arrays.sort(arr);
		
		for(int i=0; i<N-1;i++) {
			arr1[i]=arr[i+1]-arr[i];
		}
		
		
		GCD = arr1[0];
		getGCD();
		System.out.println(GCD);

	}

	private static void getGCD() {
		if(N==1) {
			return ;
		}
		
		for(int i=1; i<N-1; i++) {
			GCD = Euclid(arr1[i], GCD);
		}
		
	}

	private static long Euclid(long arr2, long gCD2) {
		long min = Math.min(gCD2,arr2);
		long max = Math.max(gCD2,arr2);
		while(true) {
			if(max%min==0) break;
			min=max%min;
		}
		return min;
	}
	

}

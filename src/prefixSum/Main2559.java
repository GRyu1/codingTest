package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2559 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] sum = new int[N+1-M];
		
		st = new StringTokenizer(br.readLine(), " ");
		int t=0;
		
		
		
		for(int i=0; i<arr.length ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(i>=M-1) {
				for(int j=i; j>i-M; j--) {
					sum[t]+=arr[j]; 
				}
				t++;
			}
		}
		
		int max=sum[0];
		
		for(int i=0; i<sum.length;i++) {
			max = Math.max(max, sum[i]);
		}
		System.out.println(max);
		
	}

}

package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1932 {
	static int[][] max;
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine() , " ");
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		max = new int[N][N];
		for(int i=0; i<N ; i++) {
		st = new StringTokenizer(br.readLine(), " ");
			for(int j=0 ; j<=i ; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		max[0][0] = arr[0][0];
		for(int i=1; i<N;i++) {
			for(int j=0; j<=i; j++) {
				if(j==0) {
					max[i][j]=max[i-1][j]+arr[i][j];
				}else if(j==i) {
					max[i][j]=max[i-1][j-1]+arr[i][j];
				}else {
					max[i][j]=Math.max(max[i-1][j]+arr[i][j], max[i-1][j-1]+arr[i][j]);
				}
			}
		}
		int maxint =0;
		for( int i=0; i<N; i++) {
			if(max[N-1][i]>=maxint) maxint=max[N-1][i];
		}
		System.out.println(maxint);
	}

}

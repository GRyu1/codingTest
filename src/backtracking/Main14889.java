package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14889{
	static boolean[] picked;
	static int[][] arr;
	static int N;
	static int min=2147483647;
   

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		picked = new boolean[N+1];
		
		StringTokenizer st;
		
		for(int i = 0 ;i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<N; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		teamDivide(1,0);
		System.out.println(min);
	}

	private static void teamDivide(int start ,int depth) {
		
		if(depth==N/2) {
			int A=0;
			for(int i=1; i<=N; i++) {
				for (int j=i+1; j<=N; j++) {
					if(picked[i]&&picked[j]) {
						A+=arr[i-1][j-1]+arr[j-1][i-1];
					}
					else if(!picked[i]&&!picked[j]) {
						A-=arr[i-1][j-1]+arr[j-1][i-1];
					}
				}
			}
			min = Math.min(Math.abs(A), min);
			return;
		}
		
		for(int i=start; i<=N ; i++) {
			if(!picked[i]) {
				picked[i]=true;
				teamDivide(start+1,depth+1);
				picked[i]=false;
			}
		}
	}

}

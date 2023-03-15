package prefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main16139 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String str = br.readLine();
		int M = str.length();
		int N = Integer.parseInt(br.readLine());
		int[][] memo = new int[M+1][26];
		
		for(int i=1; i<=M ;i++) {
			for(int j=0; j<26 ; j++) {
				if(str.charAt(i-1)-'a'==j) {
					memo[i][j]=memo[i-1][j];
					memo[i][j]++;
				}else {
					memo[i][j]=memo[i-1][j];
				}
			}
		}
		
				
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int target = st.nextToken().charAt(0)-'a';
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			bw.write(memo[end+1][target]-memo[start][target]+ "\n");
		
		}
		bw.flush();
		bw.close();

	}

}

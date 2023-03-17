package prefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][N];
		int[][] prefixSum = new int[N+1][N+1];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				prefixSum[i+1][j+1] = prefixSum[i+1][j] + prefixSum[i][j+1] - prefixSum[i][j] + arr[i][j];
			}
			
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int idxX1 = Integer.parseInt(st.nextToken());
			int idxY1 = Integer.parseInt(st.nextToken());
			int idxX2 = Integer.parseInt(st.nextToken());
			int idxY2 = Integer.parseInt(st.nextToken());
			
			System.out.println(prefixSum[idxX2][idxY2]-prefixSum[idxX2][idxY1-1]-prefixSum[idxX1-1][idxY2]+prefixSum[idxX1-1][idxY1-1]);
			
		}
	}

}

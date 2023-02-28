package backtracking;

import java.io.*;
import java.util.StringTokenizer;

public class Main2580 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int[9][9];
		StringTokenizer st;
		for(int i=0;i<9;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0;j<9;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}

	}

}

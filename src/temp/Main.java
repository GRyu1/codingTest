package temp;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N][2];
		
		for(int i=0; i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
	}

	public static int[][] mergeSort(int[][] arr){
		//데이터 갯수 반으로
		
		//왼쪽도 정렬, 오른쪽도 정렬
		
		
		return arr;
	}
}

package prefixSum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main11659 {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1];
		st=new StringTokenizer(br.readLine(), " ");
		
		for(int i=1; i<=N;i++) {
			arr[i] += Integer.parseInt(st.nextToken());
			arr[i] += arr[i-1];
		}
		
		for(int i=0; i<M;i++) {
			st = new StringTokenizer(br.readLine()," ");
			bw.write(-arr[Integer.parseInt(st.nextToken())-1]+arr[Integer.parseInt(st.nextToken())]+"\n");
		}
		bw.flush();
		bw.close();

	}

}

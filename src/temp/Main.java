package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Integer, Integer> rankingMap = new HashMap<Integer, Integer>();
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		int[] sorted=new int[N];
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i]=sorted[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(sorted);
		
		int rank=0;
		
		for(int v : sorted) {
			if(!rankingMap.containsKey(v)) {
				rankingMap.put(v, rank);
				rank++; }
		}
		
		for(int key : arr) {
			int ranking = rankingMap.get(key);
			bw.write(ranking+" ");
		}
		bw.close();
	}
}

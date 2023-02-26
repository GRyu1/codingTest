package setAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(st.nextToken());
			if(!hm.containsKey(a)) {
				hm.put(a, 1);
			}
			else hm.put(a, hm.get(a)+1);
		}
		
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(hm.containsKey(a)) bw.write(hm.get(a)+" ");
			else bw.write(0+" ");
		}
		bw.close();
	}
	
}

package setAndMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1269 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<Integer , Integer> hm = new HashMap<Integer , Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<N ; i++) {
			hm.put(Integer.parseInt(st.nextToken()), 0);
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int j=0; j<M ; j++) {
			int a = Integer.parseInt(st.nextToken());
			if(hm.containsKey(a)) hm.put(a, hm.get(a)+1);
			else hm.put(a, 0);
		}
		
		for(int s : hm.keySet()) {
			if(hm.get(s)==0) al.add(s);
		}
		
		System.out.println(al.size());
	}
}
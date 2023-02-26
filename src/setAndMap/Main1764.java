package setAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String , Integer> hm = new HashMap<String , Integer>();
		ArrayList<String> al = new ArrayList<String>();
		
		for(int i=0; i<N ; i++) {
			hm.put(br.readLine(), 0);
		}
		
		for(int j=0; j<M ; j++) {
			String str = br.readLine();
			if(hm.containsKey(str)) hm.put(str, hm.get(str)+1);
			else hm.put(str, 0);
		}
		
		for(String s : hm.keySet()) {
			if(hm.get(s)!=0) al.add(s);
		}
		
		al.sort(null);
		
		System.out.println(al.size());
		for(String s : al) {
			bw.write(s+"\n");
		}
		bw.close();
	}
}

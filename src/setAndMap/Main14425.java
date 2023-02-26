package setAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main14425 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		HashMap<String , Integer> hm = new HashMap<String, Integer>();
		ArrayList<String> al = new ArrayList<String>();
		
		for(int i=0; i<N ; i++) {
			al.add(br.readLine());
		}
		int count=0;
		for(int i=0; i<M ; i++) {
			String str = br.readLine();
			if(al.contains(str)) {
				count++;
			}
		}
		System.out.println(count);
	}
}

package numberAndCombination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main9375 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int i=0 ; i<testCase; i++) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hm = new HashMap<String , Integer>();
			HashSet<String> hs = new HashSet<String>();
			for(int j=0 ; j<N; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				String str1 = st.nextToken();
				String str2 = st.nextToken();
				hs.add(str2);
				if(!hm.containsKey(str2)) hm.put(str2, 1);
				else hm.put(str2, hm.get(str2)+1);
			}
			int a = 1;
			for(String s : hs) {
				a*=hm.get(s)+1;
			}
			System.out.println(a-1);
		}
	}
}


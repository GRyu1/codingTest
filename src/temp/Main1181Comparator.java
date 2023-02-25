package temp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;

public class Main1181Comparator {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<String> arrlist = new ArrayList<String>();
		
		for(int i=0; i<N; i++) {
			String str=br.readLine();
			if(arrlist.indexOf(str)==-1) arrlist.add(str);
		}
		arrlist.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()==o2.length()) {
					int s=0;
					for(int i=0; i<o1.length();i++) {
						s=o1.charAt(i)-o2.charAt(i);
						if(s!=0) break;
					}
					return s;
					}
				else return o1.length()-o2.length();
			}
			
		});
		
		for(int i=0; i<arrlist.size(); i++) {
			bw.write(arrlist.get(i)+"\n");
		}
		bw.close();
	}
}

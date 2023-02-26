package setAndMap;

import java.util.*;
import java.io.*;

public class Main11478 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		HashSet<String> hs = new HashSet<String>();
		
		for(int i = 0 ; i < str.length() ; i++) {
			for(int j = i+1; j<str.length()+1 ; j++) {
				hs.add(str.substring(i,j));
			}
		}
		
		System.out.println(hs.size());
	}
}

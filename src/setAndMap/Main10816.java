package setAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main10816 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		al.sort(null);
		int M = Integer.parseInt(br.readLine());
		for(int i=0; i<M;i++) {
			int target = Integer.parseInt(br.readLine());
			binarySearch(al , target , 0 , al.size()-1);
		}
	}
	private static void binarySearch (ArrayList<Integer> al, int target , int start , int end) {
		int count=0;
		while(start<=end) {
			int mid = (start + end) /2;
			if(al.get(mid)<=target) {start=mid+1;}
			else if(al.get(end)>target) {end=mid;}
		}
	}
}

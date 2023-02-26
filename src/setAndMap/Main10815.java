package setAndMap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main10815 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++){
			al.add(Integer.parseInt(st.nextToken()));
		}
		int M= Integer.parseInt(br.readLine());
		al.sort(null);
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<M;i++) {
			int a = Integer.parseInt(st.nextToken());
			if(binarySearch(al, a , 0 ,al.size()-1)) {
				bw.write("1 ");
			}
			else bw.write("0 ");
		}
		bw.close();
	}

	private static boolean binarySearch(ArrayList<Integer> al, int target , int start , int end) {
		while(start<=end) {
			int mid=(start+end)/2;
			if(target<al.get(mid)) end=mid-1;
			else if(target>al.get(mid)) start=mid+1;
			else return true;
		}
		return false;
	}
}

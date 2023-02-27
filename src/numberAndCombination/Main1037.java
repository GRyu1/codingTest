package numberAndCombination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		int max=0;
		int min=2147483647;
		for(int i=0; i<N; i++) {
			int a=Integer.parseInt(st.nextToken());
			max=Math.max(max, a);
			min=Math.min(min, a);
		}
		
		System.out.println(max*min);
	}
}

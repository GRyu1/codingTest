package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



 // O(n) = n^2-n / 2
public class Main1912 {
	static int max;
	static int[] arr;
	static int N;
	static Integer[] tmp;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		tmp = new Integer[N];
		
		for(int i=0 ; i< N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		tmp[0] = arr[0];
		max = arr[0];
		
		main1912(N-1);
		
		System.out.println(max);

	}

	private static int main1912(int top) {
		if(tmp[top] == null) {
			
			tmp[top] = Math.max(arr[top]+main1912(top-1), arr[top]);
			max = Math.max(tmp[top], max);
		}
	
		return tmp[top];
	}

	
}

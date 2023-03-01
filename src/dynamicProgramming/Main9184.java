package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main9184 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st;
		int a=0;
		int b=0;
		int c=0;
		while(!(a==-1&&b==-1&&c==-1)) {
			int sum=0;
			st = new StringTokenizer(br.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			if (a <= 0 || b <= 0 || c <= 0) {
		        sum+= 1;
		    } else if (a > 20 || b > 20 || c > 20) {
		        a=20;
		        b=20;
		        c=20;
		    } else if (a < b && b < c) {
		        return w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		    } else {
		        return w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
		    }
		}

	}
	
	public static int w(int a, int b, int c) {
	    
	}


}

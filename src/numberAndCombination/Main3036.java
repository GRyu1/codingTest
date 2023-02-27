package numberAndCombination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main3036 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int first = Integer.parseInt(st.nextToken());
		for(int i=0; i<N-1 ; i++) {
			int a = Integer.parseInt(st.nextToken());
			int gcdTmp=getGCD(first, a);
			bw.write((first/gcdTmp)+"/"+(a/gcdTmp)+"\n");
		}
		bw.close();
	}

	private static int getGCD(int a, int b) {
		int tmp;
		int gcd=1;
		while(true) {
			if(a>b) {
				tmp=a%b;
				a=b;
				b=tmp;
				if(b==0) {gcd=a; break;}
			}
			else if(a<b) {
				tmp=b%a;
				b=a;
				a=tmp; 
				if(a==0){gcd=b; break;}
			}
			else {gcd=a; break;}
			
		}
		return gcd;
	}
}

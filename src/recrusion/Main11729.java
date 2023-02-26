package recrusion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main11729 {
	static BufferedWriter bw =new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count=1;
		
		for(int i=0; i<N;i++) {
			count*=2;
		}
		count--;
		bw.write(count+"\n");
		hanoi(N, 1, 3 ,2);
		
		bw.close();
	}

	private static void hanoi(int N, int start , int end , int sub) throws IOException {
		if(N==1) {
			bw.write(start + " " + end + "\n");
		}
		else {
			hanoi(N-1,start,sub,end);
			bw.write(start + " " + end + "\n");
			hanoi(N-1,sub,end,start);
		}
	}

}

package backtracking;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main14888 {
	static int[] operator = new int[4];
	static ArrayList<Integer> al1 = new ArrayList<>();
	static int[] operatorIn;
	static int max=-1000000000;
	static int min=1000000000;
	static int N;

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			
			N = Integer.parseInt(br.readLine());
			operatorIn = new int[N-1];
					
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) {
				al1.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}
			
			operating(0);
			System.out.println(al1.toString());
			System.out.println(Arrays.toString(operatorIn));
			
			System.out.println(max);
			System.out.println(min);
			
	}

	private static void operating(int depth) {
		if(depth==N-1) {
			int answer=al1.get(0);
			for(int i=0; i<al1.size()-1 ; i++) {
				switch(operatorIn[i]) {
				case 0 : answer = answer + al1.get(i+1);break;
				case 1 : answer = answer - al1.get(i+1);break;
				case 2 : answer = answer * al1.get(i+1);break; 
				case 3 : answer = answer / al1.get(i+1);break;
				}
			}
			if(answer>max) max=answer;
			if(answer<min) min=answer;
			return;
		}
		
		for(int i=0; i<4 ; i++) {
			if(canUse(i)) {
				operator[i]--;
				operatorIn[depth]=i;
				operating(depth+1);
				operator[i]++;
			}
		}
		
	}

	private static boolean canUse(int i) {
		if(operator[i]==0) return false;
		return true;
	}
	
}

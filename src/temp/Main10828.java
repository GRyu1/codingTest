package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main10828 {
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			switch(st.nextToken()) {
			
			case "push" : 
				int a=Integer.parseInt(st.nextToken());
				stack.push(a);
				break;
			case "pop" : 
				try {
				System.out.println(stack.pop());
				}catch(EmptyStackException ee) {
					System.out.println("-1");
				}
				break;
			case "size" : 	
				System.out.println(stack.size());
				break;
			case "empty" : 
				System.out.println(stack.isEmpty()? 1:0);
				break;
			case "top" : 
				int b;
				try {
					b = stack.pop();
				}catch(EmptyStackException ee) {
					b=-1;
				}
				if(b!=-1) {System.out.println(b); stack.push(b);}
				else System.out.println(b);
				break;
			
			}
		}

	}

}

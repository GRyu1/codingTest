package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773 {

	public static void main(String[] args) throws IOException {
		Stack<Integer> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a!=0) {
				stack.push(a);
			}else stack.pop();
		}
		int sum=0;
		while(!stack.isEmpty()) {
			sum+=stack.pop();
		}
		System.out.println(sum);

		
	}

}

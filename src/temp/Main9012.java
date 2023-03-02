package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012 {
	static Stack<Integer> stack; 

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i = 0 ; i<N ; i++) {
			String str = br.readLine();
			stack = new Stack();
			
			System.out.println(check(str)?"YES":"NO");
		}
		
	}

	private static boolean check(String str) {
		for(int i=0 ; i<str.length(); i++) {
			if(str.charAt(i)=='(') {
				stack.add(1);
			}else if(str.charAt(i)==')') {
				if(stack.empty()) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		return stack.empty()? true : false;
	}
}

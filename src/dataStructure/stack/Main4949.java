package dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main4949 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			char tmp;
			boolean balance=true;
			String str = br.readLine();
			if(str.equals(".")) break;
			Stack<Character> s = new Stack<>();
			for(int i=0; i<str.length();i++) {
				if(str.charAt(i)=='(') s.push('(');
				else if(str.charAt(i)=='[') s.push('[');
				else if(str.charAt(i)==')') {
					if(!s.isEmpty()) {
						if(s.pop()=='(')
						balance=true;
						else {
							balance=false;
							break;
						}
					}
					else {
						balance=false;
						break;
					}
				}
				else if(str.charAt(i)==']') {
					if(!s.isEmpty()) {
						if(s.pop()=='[')
						balance=true;
						else {
							balance=false;
							break;
						}
					}
					else {
						balance=false;
						break;
					}
				}
			}
            if(s.isEmpty() && balance ) balance = true;
            else balance = false;
            
			System.out.println(balance? "yes" : "no");
		}

	}

}
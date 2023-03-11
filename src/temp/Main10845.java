package temp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main10845 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Integer> q = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		int N = sc.nextInt();
		Integer tmp=0;
		for(int i=0; i<N; i++) {
			String input = sc.next();
			
			switch(input) {
			case "push" :
				int a = sc.nextInt();
				q.add(a);
				tmp = a;
				break;
			case "pop" : 
				if(q.isEmpty()) {
					sb.append(-1+"\n");
				}else
					sb.append(q.poll()+"\n");
				break;
			case "size" : sb.append(q.size()+"\n"); break;
			case "empty" : sb.append(q.isEmpty()? 1+"\n" : 0+"\n");break;
			case "front" : 
				if(q.isEmpty()) {
					sb.append(-1+"\n");
				}else
					sb.append(q.peek()+"\n");
				break;
			case "back" : 
				if(q.isEmpty()) {
					sb.append(-1+"\n");
				}else
					sb.append(tmp+"\n");
				break;
			
			}
		}
		System.out.println(sb);	

	}

}

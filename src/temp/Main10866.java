package temp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main10866 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		Deque<Integer> deq = new LinkedList<>();
		for(int i=0; i<N; i++) {
			String str = sc.next();
			switch(str){
				case "push_front" :
					deq.offerFirst(sc.nextInt());
					break;
				case "push_back" :
					deq.offerLast(sc.nextInt());
					break;
				case "pop_front" :
					if(!deq.isEmpty()) {
					sb.append(deq.pollFirst()+"\n");
					break;
					}
					else {
						sb.append(-1+"\n");
						break;
					}
				case "pop_back" :
					if(!deq.isEmpty()) {
						sb.append(deq.pollLast()+"\n");
						break;
					}
					else {
						sb.append(-1+"\n");
						break;
					}
				case "size" :
					sb.append(deq.size()+"\n");
					break;
				case "empty" :
					if(deq.isEmpty()) sb.append(1+"\n");
					else sb.append(0+"\n");
					break;
				case "front" :
					if(deq.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(deq.peekFirst()+"\n");
					} break;
				case "back" :
					if(deq.isEmpty()) {
						sb.append(-1+"\n");
					} else {
						sb.append(deq.peekLast()+"\n");
					} break;
					
			}
		}
		System.out.println(sb);
		
	}

}

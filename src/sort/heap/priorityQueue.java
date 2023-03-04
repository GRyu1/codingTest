package sort.heap;

import java.util.PriorityQueue;

public class priorityQueue {
	static int[] arr;
	static PriorityQueue<Integer> heap = new PriorityQueue<>();

	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
        System.out.println("작업시작시간 : "+millis);
		
		StringBuilder sb = new StringBuilder();
		arr = new int[10000000];
		for(int i=0; i<arr.length;i++) {
			arr[i] = (int)(Math.random()*10000000);
			heap.add(arr[i]);
		}
		
		for(int i=0; i<arr.length ; i++) {
			sb.append(heap.poll()+"\n");
		}
		System.out.println(sb);
		
		long millisAfter = System.currentTimeMillis();
        System.out.println("종료시간 : " + millisAfter);
        System.out.println("걸린시간 : " +(millisAfter-millis));

	}

}

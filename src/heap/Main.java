package heap;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long millis = System.currentTimeMillis();
        System.out.println(millis);
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N+1];
		arr[0]=0;
						
		for(int i=1;i<=N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		
		for(int i = 0; i < arr.length; i++) {
			heap.add(arr[i]);
		}
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = heap.poll();
		}
		
		for(int i=1;i<=arr.length-1;i++) {
			bw.write(arr[i]+"\n");
		}
		
		bw.flush();
		bw.close();
		long millisAfter = System.currentTimeMillis();
        System.out.println(millisAfter);
        System.out.println(millisAfter-millis);
	}	
}




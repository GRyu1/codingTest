package sort.heap;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr=new int[10000000];
		
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*10000000+1);
		}
		
		long millis = System.currentTimeMillis();
        System.out.println(millis);
		
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
		
		long millisAfter = System.currentTimeMillis();
        System.out.println(millisAfter);
        System.out.println(millisAfter-millis);
		
	}	
}




package Heap;

import java.util.*;
import java.io.*;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
				
		for(int i=0;i<N;i++) {
			arr[i]=
		}
		
	}
}

public class Heap<E>{
	private final Comparator<? super E> comparator;
	private final int DEFAULT_SIZE = 10;
	
	private int size;
	
	private Object[] array;
	
	public Heap() {
		this(null);
	}
	
	public Heap(Comparator<? super E> comparator) {
		this.array=new Object[DEFAULT_SIZE];
		this.size=0;
		this.comparator=comparator;
	}
	
	private int getParent(int index) {
		return index/2;
	}
	private int getLeftChild(int index) {
		return index*2;
	}
	private int getRightChilde(int index) {
		return index*2+1;
	}
}

package sort.heap;

import java.io.*;
import java.util.*;

public class Main11650heap {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		
		int[][] arr=new int[N][2];
		
		for(int i=0; i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}		
		heapSort0(arr, N);
		for(int i=0; i<N ;i++) {
			int range=0;
			
			for(int j=1; j<N;j++) {
				if(arr[i][0]==arr[j][0]) range++;
			}
			
			
			heapSort1(arr, range);
			i+=range;
		}
		for(int i=0; i<N;i++) {
			bw.write(arr[i][0]+" "+arr[i][1]+"\n");
		}
		bw.close();
		
	}

	//전체 배열 arr[0][*] 값 기준으로 maxHeap 구현
	public static void heapSort0(int[][] arr, int N){
		int n=N;
		//Max heap 구성
		for(int i=n/2-1;i>=0;i--) {
			heapify0(arr, n, i);
		}
		//Sort
		for(int i=n-1;i>0;i--) {
			swap(arr,0,i);
			heapify0(arr,i,0);
		}
	}
		
	//트리 단위로 해당 부분과 그 밑 트리 까지 쭉 maxheap 구성
	public static void heapify0(int[][] arr, int n,int i) {
		
		int parentIdx=i;
		int rightChildIdx=i*2+2;
		int leftChildIdx=i*2+1;
		
		if(rightChildIdx<n && arr[parentIdx][0]<arr[rightChildIdx][0]) {
			parentIdx=rightChildIdx;
		}
		if(leftChildIdx<n && arr[parentIdx][0]<arr[leftChildIdx][0]) {
			parentIdx=leftChildIdx;
		}
		
		if(i!=parentIdx) {
			swap(arr, parentIdx, i);
			heapify0(arr, n, parentIdx);
		}
	}
	
	//SawpAll 배열[0][*] 값 기준
	public static void swap (int[][] arr, int n, int i) {
		int tmp1 = arr[n][0];
		arr[n][0] = arr[i][0];
		arr[i][0] = tmp1;
		
		int tmp2 = arr[n][1];
		arr[n][1] = arr[i][1];
		arr[i][1] = tmp2;
	}

	public static void heapSort1(int[][] arr, int range) {
		int n=range+1;
		//Max heap 구성
		for(int i=n/2-1;i>=0;i--) {
			heapify0(arr, n, i);
		}
		//Sort
		for(int i=n-1;i>0;i--) {
			swap(arr,0,i);
			heapify0(arr,i,0);
		}
	}
	
	public static void heapify1(int[][] arr, int n,int i) {
		int parentIdx=i;
		int rightChildIdx=i*2+2;
		int leftChildIdx=i*2+1;
		
		if(rightChildIdx<n && arr[parentIdx][1]<arr[rightChildIdx][1]) {
			parentIdx=rightChildIdx;
		}
		if(leftChildIdx<n && arr[parentIdx][1]<arr[leftChildIdx][1]) {
			parentIdx=leftChildIdx;
		}
		
		if(i!=parentIdx) {
			swap(arr, parentIdx, i);
			heapify0(arr, n, parentIdx);
		}
	}
	
}
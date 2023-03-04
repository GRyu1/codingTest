package sort.merge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main24060 {
	static int count = 0;
	static int[] tmp = new int[500000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		mergeSort(arr,0,arr.length-1, M);
		if(count<M) System.out.println("-1");
	}

	private static void mergeSort(int[] arr, int start , int end, int M) {
		
		if(start<end) {
		int mid = (start+end)/2;
		mergeSort(arr, start, mid, M);
		mergeSort(arr, mid+1 , end, M);
		merge(arr, start, mid, end, M);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end, int M) {
		int i=start;
		int j=mid+1;
		
		int t=start;
		while(i<=mid && j<=end) {
			if(arr[i]<arr[j]) {
				tmp[t++]=arr[i++];
			}
			else {
				tmp[t++]=arr[j++];
			}
		}
		while(i<=mid) {
			tmp[t++]=arr[i++];
		}
		while(j<=end) {
			tmp[t++]=arr[j++];
		}
		i=start;
		while(i<=end) {
			arr[i]=tmp[i++];
			count++;
			if(count==M) System.out.println(arr[i-1]);
		}
	}

}

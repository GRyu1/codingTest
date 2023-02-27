package numberAndCombination;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main2981 {
	static int[] tmp = new int[101];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		mergeSort(arr , 0 , arr.length-1);
		
		int gcdTmp = arr[1]-arr[0];
		
		for(int i=2; i<N ; i++) {
			gcdTmp=getGCD(gcdTmp,arr[i]-arr[i-1]);
		}
		
		for(int i=2; i<=Math.sqrt(gcdTmp);i++) {
			if(gcdTmp%i==0) {
				al.add(i);
				if(i!=gcdTmp/i)
				al.add(gcdTmp/i);
			}
		}
		al.add(gcdTmp);
		al.sort(null);
		
		for(int i : al) {
			bw.write(i+ " ");
		}
		
		bw.close();
	}
	
	public static void mergeSort(int[] arr , int start , int end) {
		if(start<end){
		int mid = (start + end) / 2;
		mergeSort(arr, start, mid);
		mergeSort(arr , mid+1 , end);
		
		merge(arr ,start , mid , end);
		}
	}
	
	private static void merge(int[] arr, int start, int mid, int end) {
		int i=start;
		int j=mid +1;
		int t=start;
	
		while(i<=mid && j<= end) {
			if(arr[i]>arr[j]) tmp[t++] = arr[j++];
			else tmp[t++] = arr[i++];
		}
		while(i<=mid) {
			tmp[t++] = arr[i++];
		}
		while(j<=end) {
			tmp[t++] = arr[j++];
		}
		i=start;
		while(i<=end) {
			arr[i]=tmp[i++];
		}
	}

	public static int getGCD(int a, int b) {
		int tmp;
		while(b!=0) {
			tmp = a%b;
			a=b;
			b=tmp;
		}
		return a;
	}
}

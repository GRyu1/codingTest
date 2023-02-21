import java.io.*;
import java.util.Arrays;

class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int[] arr=new int[N];
		for(int i=0; i<N; i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		printArr(mergeSort(arr));
	
	}
	
	static int[] mergeSort(int[] arr) {
		if(arr.length<2) return arr;
		
		int mid=arr.length/2;
		int[] left=mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right=mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		
		int[] mergedarr=new int[arr.length];
		int m=0,l=0,h=0;
		
		while(l<left.length&&h<right.length) {
			if(left[l]<=right[h]) {
				mergedarr[m++]=left[l++];
			}
			else mergedarr[m++]=right[h++];
		}
		while (l < left.length) {
            mergedarr[m++] = left[l++];
        }
        while (h < right.length) {
            mergedarr[m++] = right[h++];
        }
        return mergedarr;
	}
	
	static void printArr(int[] arr) throws IOException {
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0;i<arr.length;i++) {
			bw.write(arr[i]+"\n");
			}
		bw.flush();
	}
}

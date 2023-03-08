package sort.bubble;

public class BubbleSortV3 {

	public static void main(String[] args) {
		int[] arr = new int[100];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*100+1);
		}
		
		bubbleSort(arr);
		for(int i : arr) {
			System.out.println(i);
		}

	}
	
	
	private static void bubbleSort(int[] arr) {
		int k=0;
		int n= arr.length;
		while(k<n-1) {
			int last = n-1;
			for(int j=0; j<n-1;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr ,j, j+1);
					last = j;
				}
			}
			k=last;
		}
	}

	
	private static void swap(int[] arr, int j, int i) {
		int tmp = arr[j];
		arr[j] = arr[j+1];
		arr[j+1] = tmp;
	}

}

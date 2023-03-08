package sort.bubble;

public class BubbleSrotV2 {
	
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
		for(int i=0; i<arr.length-1 ; i++) {
			boolean isSwaped = false;
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr , j , j+1);
					isSwaped = true;
				}
				
			}
			if(!isSwaped) break;
		}
		
	}


	private static void swap(int[] arr, int j, int i) {
		int tmp = arr[j];
		arr[j] = arr[j+1];
		arr[j+1] = tmp;
	}

}

package sort.bubble;
 
public class CocktailSort {
	public static void main(String[] args) {
		int[] arr = new int[100];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int) (Math.random()*100+1);
		}
		
		cocktailSort(arr);
		for(int i : arr) {
			System.out.println(i);
		}
	}

 
	public static void cocktailSort(int[] array) {
		boolean swapped = true;
		int j = array.length - 1;
		for (int i = 0; i < j && swapped; i++) {
			swapped = false;
			for (int k = i; k < j; k++) {
				if (array[k] > array[k + 1]) {
					int temp = array[k];
					array[k] = array[k + 1];
					array[k + 1] = temp;
					swapped = true;
					}
				}
			j--;
			
			if (swapped) {
				swapped = false;
				for (int k = j; k > i; k--) {
					if(array[k] < array[k - 1]) {
						int temp = array[k];
						array[k] = array[k - 1];
						array[k - 1] = temp;
						swapped = true;
						}
					}
				}
			}
        }

}
package quickSort;

public class doublePivot {
	static int[] arr;

	public static void main(String[] args) {
		arr = new int[1000];
		for(int i=0; i<arr.length; i++) {
			arr[i]=(int)(Math.random()*1000);
		}
		quicksort();
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<arr.length; i++) {
			sb.append(arr[i]+"\n");
		}
		System.out.println(sb);
	}

	private static void quicksort() {
		
	}

}

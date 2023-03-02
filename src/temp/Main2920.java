package temp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[8];
		int[] sortedArr = new int[8];
		for(int i=0; i<8 ; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			sortedArr[i]=arr[i];
		}
		Arrays.sort(sortedArr);
		
		boolean flagSort = true;
		boolean flagSortR = true;
		
		for(int i=0 ; i<8; i++) {
			if(arr[i]!=sortedArr[i]) flagSort = false;
			if(arr[i]!=sortedArr[7-i]) flagSortR = false;
		}
		
		if(flagSort) System.out.println("ascending");
		else if(flagSortR) System.out.println("descending");
		else System.out.println("mixed");
		

	}

}

package temp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i =0; i<N ; i++) {
			arr[i]=sc.nextInt();
		}
		ArrayList<Integer> al = new ArrayList<Integer>();
		
		for(int i=0; i<N-2 ; i++) {
			for(int j=i+1; j<N-1 ;j++) {
				for(int k=j+1; k<N ; k++) {
					if(arr[i]+arr[j]+arr[k]<=M) {
						al.add(arr[i]+arr[j]+arr[k]);
					}
				}
			}
		}
		al.sort(null);
		System.out.println(al.get(al.size()-1));
	}

}

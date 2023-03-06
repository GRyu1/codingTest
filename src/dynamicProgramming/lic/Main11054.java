package dynamicProgramming.lic;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11054 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0 ;i<N; i++) {
			arr[i]= sc.nextInt();
		}
		
		Integer[] rDp = new Integer[N];
		Integer[] lDp = new Integer[N];
		
		int[] total = new int[N];
		
		for(int i=0; i<N; i++) {
			if(rDp[N-1-i]==null) rDp[N-1-i]=1;
			if(lDp[i]==null) lDp[i]=1;
			for(int j=0; j<i; j++) {
				if(arr[i]>arr[j]&&lDp[i]<lDp[j]+1) lDp[i] = lDp[j]+1;
				if(arr[N-1-i]>arr[N-1-j]&&rDp[N-1-i]<rDp[N-1-j]+1) rDp[N-1-i] = rDp[N-1-j]+1;
			}
		}
		
		
		for(int i=0; i<N; i++) {
			total[i]=rDp[i]+lDp[i];
		}
		
		int max=total[0];
		for(int i=0; i<N; i++) {
			if(total[i]>max) max=total[i];
		}
		System.out.println(max-1);
	}

}

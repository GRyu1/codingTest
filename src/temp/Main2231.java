package temp;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al =new ArrayList<Integer>();
		
		int N = sc.nextInt();
		int[] arr = new int[6];
		
		for(int i=0; i<N; i++) {
			int tmp = i;
			int j=0;
			int length=0;
			
			while(true) {
			arr[j++]=tmp%10;
			tmp/=10;
			length++;
			if(tmp==0) break;
			}
			int tmp2 = N;
			for(int k=0; k<length; k++) {
				tmp2-=arr[k];				
			}
			
			if(tmp2==i) al.add(i);
		}
		
		if(al.size()==0) System.out.println(0);
		else{
			al.sort(null);
			System.out.println(al.get(0));
		}
		
	}
}

package geomatics01;

import java.util.Scanner;

public class Main2477 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[6];
		int[] dir = new int[6];
		int[] count = new int[5];

		String str = "";
		
		for(int i=0; i<5 ; i++) {
			count[i]=0;
		}
		
		for(int i=0; i<6; i++) {
			dir[i] = sc.nextInt();
			arr[i] = sc.nextInt();
			count[dir[i]]++;
		}
		
		for(int i=0;i<6;i++) {
			str+=count[dir[i]]==2?"2":"1";
		}
		
		str+=str;
		
		int idx1=(str.indexOf("2222")+1)%6;
		int idx2=(str.indexOf("2222")+2)%6;
		int idx3=str.indexOf("1");
		int idx4=str.indexOf("1", idx3+1);
		
		System.out.println(N*(arr[idx3]*arr[idx4]-arr[idx1]*arr[idx2]));
		
	}
}
